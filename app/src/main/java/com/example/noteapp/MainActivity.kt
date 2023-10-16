package com.example.noteapp

import android.os.Bundle
import android.view.animation.Animation
import android.view.animation.AnimationUtils
import androidx.appcompat.app.AppCompatActivity
import com.example.noteapp.databinding.ActivityMainBinding
import kotlin.random.Random

class MainActivity : AppCompatActivity() {

    private lateinit var binding: ActivityMainBinding

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        binding = ActivityMainBinding.inflate(layoutInflater)
        setContentView(binding.root)
        actionBar?.hide()

        val rotateAnimation = AnimationUtils.loadAnimation(this, R.anim.rotate)

        rotateAnimation.setAnimationListener(object : Animation.AnimationListener {
            override fun onAnimationStart(animation: Animation?) {}

            override fun onAnimationEnd(animation: Animation?) {
                val random = Random.nextBoolean()
                if (random) {
                    binding.imageView.setImageResource(R.drawable.yazi)
                } else {
                    binding.imageView.setImageResource(R.drawable.tura)
                }
            }

            override fun onAnimationRepeat(animation: Animation?) {}
        })

        binding.btnFlip.setOnClickListener {
            binding.imageView.startAnimation(rotateAnimation)
        }
    }
}
