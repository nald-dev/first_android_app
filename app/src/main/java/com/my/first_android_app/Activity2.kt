package com.my.first_android_app

import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.widget.TextView

class Activity2 : AppCompatActivity() {
    lateinit var textView: TextView

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_2)

        textView = findViewById(R.id.textView)

        textView.text = intent.getStringExtra("username") + intent.getStringExtra("password")
    }
}