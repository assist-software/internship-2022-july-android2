package com.assist.imobilandroidapp.screens.averageUser.screens.normalScreen.Classes

import com.google.gson.annotations.SerializedName

data class Author(
    @SerializedName("address")
    val address: String?,
    @SerializedName("createdAt")
    val createdAt: String?,
    @SerializedName("dateOfBirth")
    val dateOfBirth: String?,
    @SerializedName("email")
    var email: String?,
    @SerializedName("fullName")
    var fullName: String?,
    @SerializedName("gender")
    val gender: Int?,
    @SerializedName("google")
    val google: Boolean?,
    @SerializedName("id")
    val id: String?,
    @SerializedName("isActive")
    val isActive: Boolean?,
    @SerializedName("listings")
    val listings: List<Listing?>?,
    @SerializedName("password")
    val password: String?,
    @SerializedName("phone")
    val phone: String?,
    @SerializedName("photo")
    val photo: String?,
    @SerializedName("role")
    val role: Int?,
    @SerializedName("token")
    val token: String?,
    @SerializedName("updatedAt")
    val updatedAt: String?,
    @SerializedName("userActivities")
    val userActivities: UserActivities?
)