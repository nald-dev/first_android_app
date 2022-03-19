package com.my.first_android_app

import android.content.Intent
import android.content.SharedPreferences
import android.os.Bundle
import android.widget.Button
import android.widget.EditText
import android.widget.ImageView
import androidx.appcompat.app.AppCompatActivity

// import com.bumptech.glide.Glide
import com.squareup.picasso.Picasso

class MainActivity : AppCompatActivity()  {
    private lateinit var sharedPref: SharedPreferences

    private lateinit var imageView: ImageView
    private lateinit var button: Button

    private lateinit var usernameEditText: EditText
    private lateinit var passwordEditText: EditText

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_main)

        sharedPref = getSharedPreferences("myPreferences", MODE_PRIVATE)

        imageView = findViewById<ImageView>(R.id.imageView)
        button = findViewById<Button>(R.id.button)

        usernameEditText = findViewById<EditText>(R.id.editTextTextPersonName)
        passwordEditText = findViewById<EditText>(R.id.editTextTextPassword2)

        // Glide.with(this).load("http://goo.gl/gEgYUd").into(imageView)

        Picasso
            .get()
            .load("https://i.imgur.com/DvpvklR.png")
            .into(imageView)

        button.setOnClickListener {
            sharedPref.edit().putString("username", usernameEditText.text.toString()).commit();

            val intent = Intent(this, Activity2::class.java)
                .putExtra("successMessage", "Successfully login")

            // Add flags to replace activity
            // intent.flags = Intent.FLAG_ACTIVITY_NEW_TASK or Intent.FLAG_ACTIVITY_CLEAR_TASK or Intent.FLAG_ACTIVITY_CLEAR_TOP

            startActivity(intent)
        }
    }
}