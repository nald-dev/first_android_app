package com.my.first_android_app

import android.content.Intent
import android.os.Bundle
import android.widget.Button
import android.widget.ImageView
import androidx.appcompat.app.AppCompatActivity

// import com.bumptech.glide.Glide
import com.squareup.picasso.Picasso


class MainActivity : AppCompatActivity()  {
    private lateinit var imageView: ImageView
    private lateinit var button: Button

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_main)

        imageView = findViewById<ImageView>(R.id.imageView)
        button = findViewById<Button>(R.id.button)

        // Glide.with(this).load("http://goo.gl/gEgYUd").into(imageView)

        Picasso.get().load("https://i.imgur.com/DvpvklR.png").into(imageView)

        button.setOnClickListener {
            val intent = Intent(this, Activity2::class.java).putExtra("example_parameter", "Hey this is parameter from activity 1")
            startActivity(intent)
        }
    }
}