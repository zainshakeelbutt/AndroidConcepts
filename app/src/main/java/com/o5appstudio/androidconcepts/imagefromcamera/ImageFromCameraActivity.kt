package com.o5appstudio.androidconcepts.imagefromcamera

import android.Manifest
import android.app.Activity
import android.content.Intent
import android.content.pm.PackageManager
import android.graphics.Bitmap
import android.net.Uri
import android.os.Build
import android.os.Bundle
import android.provider.MediaStore
import android.widget.Button
import android.widget.ImageView
import androidx.activity.enableEdgeToEdge
import androidx.activity.result.ActivityResultLauncher
import androidx.activity.result.contract.ActivityResultContracts
import androidx.appcompat.app.AppCompatActivity
import androidx.core.app.ActivityCompat
import androidx.core.content.ContextCompat
import androidx.core.view.ViewCompat
import androidx.core.view.WindowInsetsCompat
import com.o5appstudio.androidconcepts.R

class ImageFromCameraActivity : AppCompatActivity() {
    lateinit var imageView: ImageView
    lateinit var btnCam: Button
    lateinit var btnGallery: Button
    private lateinit var takePictureLauncher: ActivityResultLauncher<Intent>
    private lateinit var selectImageLauncher: ActivityResultLauncher<Intent>
    private val cameraPermissions = arrayOf(Manifest.permission.CAMERA, Manifest.permission.WRITE_EXTERNAL_STORAGE)
    private val galleryPermissions = arrayOf(Manifest.permission.READ_EXTERNAL_STORAGE)

    companion object {
        private const val REQUEST_CAMERA_PERMISSION = 100
        private const val REQUEST_STORAGE_PERMISSION = 101    }

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_image_from_camera)

        imageView = findViewById(R.id.imageFromCamID)
        btnCam = findViewById(R.id.btnCapture)
        btnGallery = findViewById(R.id.btnGallery)

        takePictureLauncher = registerForActivityResult(ActivityResultContracts.StartActivityForResult()) { result ->
            if (result.resultCode == RESULT_OK) {
                val imageBitmap = result.data?.extras?.get("data") as Bitmap
                imageView.setImageBitmap(imageBitmap)
            }
        }
        selectImageLauncher = registerForActivityResult(ActivityResultContracts.StartActivityForResult()) { result ->
            if (result.resultCode == RESULT_OK) {
                val imageUri: Uri? = result.data?.data
                imageView.setImageURI(imageUri)
            }
        }

        btnCam.setOnClickListener {
            if (Build.VERSION.SDK_INT >= Build.VERSION_CODES.M) {
                if (arePermissionsGranted(cameraPermissions)) {
                    dispatchTakePictureIntent()
                } else {
                    requestPermissions(cameraPermissions, REQUEST_CAMERA_PERMISSION)
                }
            } else {
                dispatchTakePictureIntent()
            }
        }



        btnGallery.setOnClickListener {

//            if (Build.VERSION.SDK_INT >= Build.VERSION_CODES.M) {
//                if (arePermissionsGranted(galleryPermissions)) {
//                    dispatchSelectPictureIntent()
//                } else {
//                    requestPermissions(galleryPermissions, REQUEST_STORAGE_PERMISSION)
//                }
//            } else {
//                dispatchSelectPictureIntent()
//            }
            dispatchSelectPictureIntent()
        }

    }

    private fun dispatchTakePictureIntent() {
        val takePictureIntent = Intent(MediaStore.ACTION_IMAGE_CAPTURE)
        takePictureLauncher.launch(takePictureIntent)
    }

    private fun dispatchSelectPictureIntent() {
        val selectPictureIntent = Intent(Intent.ACTION_PICK)
        selectPictureIntent.setData( MediaStore.Images.Media.EXTERNAL_CONTENT_URI)
        selectImageLauncher.launch(selectPictureIntent)
    }

    private fun arePermissionsGranted(permissions: Array<String>): Boolean {
        return permissions.all { ContextCompat.checkSelfPermission(this, it) == PackageManager.PERMISSION_GRANTED }
    }

    override fun onRequestPermissionsResult(requestCode: Int, permissions: Array<out String>, grantResults: IntArray) {
        super.onRequestPermissionsResult(requestCode, permissions, grantResults)
        when (requestCode) {
            REQUEST_CAMERA_PERMISSION -> {
                if ((grantResults.isNotEmpty() && grantResults[0] == PackageManager.PERMISSION_GRANTED)) {
                    dispatchTakePictureIntent()
                } else {
                    // Permission denied, show a message to the user
                }
            }
            REQUEST_STORAGE_PERMISSION -> {
                if ((grantResults.isNotEmpty() && grantResults[0] == PackageManager.PERMISSION_GRANTED)) {
                    dispatchSelectPictureIntent()
                } else {
                    // Permission denied, show a message to the user
                }
            }
        }
    }

}