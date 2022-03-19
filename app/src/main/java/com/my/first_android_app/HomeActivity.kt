package com.my.first_android_app

import android.content.SharedPreferences
import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.widget.TextView

class HomeActivity : AppCompatActivity() {
    private lateinit var sharedPref: SharedPreferences

    lateinit var titleTextView: TextView
    lateinit var subtitleTextView: TextView

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_2)

        sharedPref = getSharedPreferences("myPreferences", MODE_PRIVATE)

        titleTextView = findViewById(R.id.textView)
        subtitleTextView = findViewById(R.id.textView2)

        titleTextView.text = intent.getStringExtra("greeting" +
                "Message")
        subtitleTextView.text = "Halo, " + sharedPref.getString("username", "")
    }
}