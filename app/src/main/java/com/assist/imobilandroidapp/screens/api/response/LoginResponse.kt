package com.assist.imobilandroidapp.screens.api.response

import com.google.gson.annotations.SerializedName

class LoginResponse {
    @SerializedName("token")
    lateinit var token : String
}