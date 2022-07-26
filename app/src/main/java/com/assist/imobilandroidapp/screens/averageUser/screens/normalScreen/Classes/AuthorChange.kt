package com.assist.imobilandroidapp.screens.averageUser.screens.normalScreen.Classes

import com.google.gson.annotations.SerializedName

data class AuthorChange(
    @SerializedName("address")
    val address: String?,
    @SerializedName("dateOfBirth")
    val dateOfBirth: String?,
    @SerializedName("email")
    val email: String?,
    @SerializedName("fullName")
    val fullName: String?,
    @SerializedName("gender")
    val gender: String?,
    @SerializedName("isActive")
    val isActive: Boolean?,
    @SerializedName("password")
    val password: String?,
    @SerializedName("phone")
    val phone: String?,
    @SerializedName("photo")
    val photo: String?
)