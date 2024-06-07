package com.o5appstudio.androidconcepts.mvvmpractice.albumsapi

import android.os.Bundle
import android.util.Log
import android.widget.Toast
import androidx.appcompat.app.AppCompatActivity
import androidx.lifecycle.ViewModelProvider
import androidx.recyclerview.widget.LinearLayoutManager
import com.o5appstudio.androidconcepts.databinding.ActivityAlbumsApiMainBinding
import com.o5appstudio.androidconcepts.mvvmpractice.albumsapi.adapters.AlbumAdapter
import com.o5appstudio.androidconcepts.mvvmpractice.albumsapi.api.AlbumServices
import com.o5appstudio.androidconcepts.mvvmpractice.albumsapi.api.ApiHelper
import com.o5appstudio.androidconcepts.mvvmpractice.albumsapi.model.AlbumList
import com.o5appstudio.androidconcepts.mvvmpractice.albumsapi.repository.AlbumRepository
import com.o5appstudio.androidconcepts.mvvmpractice.albumsapi.repository.AlbumResponse
import com.o5appstudio.androidconcepts.mvvmpractice.albumsapi.viewmodel.AlbumViewModel
import com.o5appstudio.androidconcepts.mvvmpractice.albumsapi.viewmodel.AlbumViewModelFactory

class AlbumsApiMainActivity : AppCompatActivity() {
    private lateinit var viewModel: AlbumViewModel
    private lateinit var albumAdapter: AlbumAdapter
    lateinit var binding: ActivityAlbumsApiMainBinding
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        binding = ActivityAlbumsApiMainBinding.inflate(layoutInflater)
        setContentView(binding.root)

        binding.albumList.layoutManager = LinearLayoutManager(this)
        albumAdapter = AlbumAdapter(this, arrayListOf())

        binding.albumList.adapter = albumAdapter
        val albumServices = ApiHelper.getInstance().create(AlbumServices::class.java)
        val repository = AlbumRepository(albumServices)

        viewModel = ViewModelProvider.create(this, AlbumViewModelFactory(repository))[AlbumViewModel::class.java]


       viewModel.albumList.observe(this) { value ->
           when (value) {
               is AlbumResponse.Failure -> {
                   Toast.makeText(this, "Error", Toast.LENGTH_SHORT).show()
               }

               is AlbumResponse.Loading -> {
                   Toast.makeText(this, "Loading", Toast.LENGTH_SHORT).show()
               }

               is AlbumResponse.Success -> {
                   value.data?.let { albumAdapter.updateAlbum(it) }
//                   value.data?.forEach {
//                       Log.d("AlbumbItem",it.title)
//                   }
//                   Log.d("AlbumList",value.data.toString())
                   Toast.makeText(this, "Success", Toast.LENGTH_SHORT).show()
               }
           }
       }


    }
}