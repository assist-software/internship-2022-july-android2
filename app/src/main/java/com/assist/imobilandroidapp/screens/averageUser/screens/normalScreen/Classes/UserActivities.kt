package com.assist.imobilandroidapp.screens.averageUser.screens.normalScreen.Classes

import com.google.gson.annotations.SerializedName

data class UserActivities(
    @SerializedName("connectionDate")
    val connectionDate: String?,
    @SerializedName("device")
    val device: String?,
    @SerializedName("deviceType")
    val deviceType: String?,
    @SerializedName("id")
    val id: String?,
    @SerializedName("location")
    val location: String?,
    @SerializedName("status")
    val status: Int?,
    @SerializedName("users")
    val users: List<String?>?
)