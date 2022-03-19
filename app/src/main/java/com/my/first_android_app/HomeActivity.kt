package com.my.first_android_app

import android.content.SharedPreferences
import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.util.Log
import android.widget.TextView
import androidx.recyclerview.widget.LinearLayoutManager
import androidx.recyclerview.widget.RecyclerView
import com.my.first_android_app.API.AllArticlesResponse
import com.my.first_android_app.API.Article
import com.my.first_android_app.API.RetrofitClient
import retrofit2.Call
import retrofit2.Callback
import retrofit2.Response
import retrofit2.Retrofit

class HomeActivity : AppCompatActivity() {
//    private lateinit var sharedPref: SharedPreferences

    private var list = ArrayList<Article>()

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_2)

        val rvArticle = findViewById<RecyclerView>(R.id.rvArticle)

        rvArticle.setHasFixedSize(true)
        rvArticle.layoutManager = LinearLayoutManager(this)

        RetrofitClient.instance.getAllArticles().enqueue(object: Callback<AllArticlesResponse> {
            override fun onResponse(
                call: Call<AllArticlesResponse>,
                response: Response<AllArticlesResponse>
            ) {
                response.body()?.data?.let {
                    list.addAll(it)
                }

                val adapter = ArticleAdapter(list)
                rvArticle.adapter = adapter
            }

            override fun onFailure(call: Call<AllArticlesResponse>, t: Throwable) {
            }

        })

        //rvArticle

//        sharedPref = getSharedPreferences("myPreferences", MODE_PRIVATE)
//
//        titleTextView = findViewById(R.id.textView)
//        subtitleTextView = findViewById(R.id.article_title)
//
//        titleTextView.text = intent.getStringExtra("greeting" +
//                "Message")
//        subtitleTextView.text = "Halo, " + sharedPref.getString("username", "")
    }
}