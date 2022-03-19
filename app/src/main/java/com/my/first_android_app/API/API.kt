package com.my.first_android_app.API

import retrofit2.Call
import retrofit2.http.Field
import retrofit2.http.FormUrlEncoded
import retrofit2.http.GET
import retrofit2.http.POST

interface API {
    @FormUrlEncoded
    @POST("/login")
    fun login(
        @Field("username") username: String,
        @Field("password") password: String,
    ): Call<LoginResponse>

    @GET("/get-all-articles")
    fun getAllArticles(): Call<ArrayList<AllArticlesResponse>>
}
