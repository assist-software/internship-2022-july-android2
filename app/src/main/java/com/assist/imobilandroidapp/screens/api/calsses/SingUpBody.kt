package com.assist.imobilandroidapp.screens.api.calsses

import com.google.gson.annotations.SerializedName

data class SingUpBody(
    @SerializedName("email")
    val email : String,
    @SerializedName("password")
    val password: String
)
