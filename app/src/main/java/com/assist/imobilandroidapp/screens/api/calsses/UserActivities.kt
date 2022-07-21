package com.assist.imobilandroidapp.screens.api.calsses

import com.google.gson.annotations.SerializedName

data class UserActivities(
    @SerializedName("id")
    val id : String?,
    @SerializedName("device")
    val device : String?,
    @SerializedName("deviceType")
    val deviceType : String?,
    @SerializedName("location")
    val location : String?,
    @SerializedName("connectionDate")
    val connectionDate : String?,
    @SerializedName("status")
    val status : Boolean
) {
}