package com.o5appstudio.androidconcepts.animations

import android.os.Bundle
import android.view.animation.AnimationUtils
import android.widget.Button
import android.widget.TextView
import androidx.activity.enableEdgeToEdge
import androidx.appcompat.app.AppCompatActivity
import androidx.compose.animation.core.Animation
import com.airbnb.lottie.LottieAnimationView

import com.o5appstudio.androidconcepts.R
import org.w3c.dom.Text

class AnimationsActivity : AppCompatActivity() {
    private lateinit var animText : TextView
    private lateinit var translateBtn : Button
    private lateinit var scaleBtn : Button
    private lateinit var rotateBtn : Button
    private lateinit var alphaBtn : Button

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        enableEdgeToEdge()
        setContentView(R.layout.activity_animations)

        animText = findViewById(R.id.animtext)
        translateBtn = findViewById(R.id.btnTranslate)
        scaleBtn = findViewById(R.id.btnScale)
        rotateBtn = findViewById(R.id.btnRotate)
        alphaBtn = findViewById(R.id.btnAlpha)


        translateBtn.setOnClickListener {
            val move = AnimationUtils.loadAnimation(this,R.anim.move)
            animText.startAnimation(move)
        }

        scaleBtn.setOnClickListener {
            val scale = AnimationUtils.loadAnimation(this, R.anim.scale)
            animText.startAnimation(scale)
        }

        rotateBtn.setOnClickListener {
            val rotate = AnimationUtils.loadAnimation(this,R.anim.rotate)
            animText.startAnimation(rotate)
        }

        alphaBtn.setOnClickListener {
            val alpha = AnimationUtils.loadAnimation(this, R.anim.alpha)
            animText.startAnimation(alpha)
        }


        //Lottie Animations

        val lottieAnimView = LottieAnimationView(this)

        lottieAnimView.setAnimation(R.raw.lottie)
        lottieAnimView.playAnimation()



    }
}