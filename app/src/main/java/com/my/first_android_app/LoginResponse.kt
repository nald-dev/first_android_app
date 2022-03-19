package com.my.first_android_app

data class LoginDataModel(val id:Int, val username:String)

data class LoginResponse(
    val status: String,
    val info: String,
    val data: LoginDataModel
)
