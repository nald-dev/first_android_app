package com.my.first_android_app

import android.content.DialogInterface
import android.content.Intent
import android.content.SharedPreferences
import android.os.Bundle
import android.util.Log
import android.widget.Button
import android.widget.EditText
import android.widget.ImageView
import androidx.appcompat.app.AlertDialog
import androidx.appcompat.app.AppCompatActivity
import com.my.first_android_app.API.LoginResponse
import com.my.first_android_app.API.RetrofitClient

// import com.bumptech.glide.Glide
import com.squareup.picasso.Picasso
import retrofit2.Call
import retrofit2.Callback
import retrofit2.Response

class LoginActivity : AppCompatActivity()  {
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

        val loginMessage = "Successfully login"

        val thisInstance = this

        button.setOnClickListener {
            RetrofitClient.instance.login(
                usernameEditText.text.toString(),
                passwordEditText.text.toString()
            )
                .enqueue(object : Callback<LoginResponse>{
                override fun onResponse(
                    call: Call<LoginResponse>,
                    response: Response<LoginResponse>
                ) {
                    val positiveButtonClick = { _: DialogInterface, _: Int ->
                        sharedPref.edit()
                            .putString("userId", response.body()!!.data.id.toString())
                            .commit();
                        sharedPref.edit()
                            .putString("username", response.body()!!.data.username)
                            .commit();

                        val intent = Intent(thisInstance, HomeActivity::class.java)
                            .putExtra("greetingMessage", "Welcome")

                        startActivity(intent)

                        // To end current activity, optional if you want to
                        finish()
                    }

                    if (response.body()?.status == "success") {
                        AlertDialog.Builder(thisInstance)
                            .setTitle("Info")
                            .setMessage(response.body()?.info)
                            .setPositiveButton("OK", positiveButtonClick)
                            .create()
                            .show()
                    } else {
                        AlertDialog.Builder(thisInstance)
                            .setTitle("Info")
                            .setMessage(response.body()?.info)
                            .setPositiveButton("OK", null)
                            .create()
                            .show()
                    }
                }

                    override fun onFailure(call: Call<LoginResponse>, t: Throwable) {
                        Log.d("fail", t.toString())
                    }
            })
        }
    }
}