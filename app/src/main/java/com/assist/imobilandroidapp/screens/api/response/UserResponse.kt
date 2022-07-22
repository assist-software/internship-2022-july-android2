package com.assist.imobilandroidapp.screens.api.response

import com.assist.imobilandroidapp.screens.api.calsses.UserActivities
import com.assist.imobilandroidapp.screens.averageUser.screens.normalScreen.Classes.ChildModel
import com.google.gson.annotations.SerializedName

data class UserResponse(
    @SerializedName("id")
    val id : String?,
    @SerializedName("fullName")
    val fullName : String?,
    @SerializedName("email")
    val email : String?,
    @SerializedName("password")
    val password : String?,
    @SerializedName("gender")
    val gender : Int,
    @SerializedName("phone")
    val phone : String?,
    @SerializedName("role")
    val role : Int,
    @SerializedName("dateOfBirth")
    val dateOfBirth : String?,
    @SerializedName("address")
    val address : String?,
    @SerializedName("photo")
    val photo : String?,
    @SerializedName("userActivities")
    val userActivities : UserActivities?,
    @SerializedName("token")
    var token : String?,
    @SerializedName("createdAt")
    val createdAt : String?,
    @SerializedName("updatedAt")
    val updatedAt : String?,
    @SerializedName("isActive")
    val isActive : Boolean,
    @SerializedName("listings")
    val listings : List<ChildModel>?
)
