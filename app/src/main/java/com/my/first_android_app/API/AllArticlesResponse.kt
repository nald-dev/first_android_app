package com.my.first_android_app.API

data class Article (
    val id: Int,
    val title: String,
    val content: String,
    val account_id: Int
)

data class AllArticlesResponse (
    val status: String,
    val info: String,
    val data: ArrayList<Article>
)