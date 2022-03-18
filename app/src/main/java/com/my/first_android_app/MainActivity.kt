package com.my.first_android_app

import android.os.Bundle
import android.widget.Button
import android.widget.ImageView
import androidx.appcompat.app.AppCompatActivity

// import com.bumptech.glide.Glide
import com.squareup.picasso.Picasso


class MainActivity : AppCompatActivity()  {
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_main)

        val imageView = findViewById<ImageView>(R.id.imageView3)

        val button = findViewById<Button>(R.id.button)

        button.setOnClickListener {
            // Glide.with(this).load("http://goo.gl/gEgYUd").into(imageView)

            Picasso.get().load("https://i.imgur.com/DvpvklR.png").into(imageView)
        }
    }
}