package com.assist.imobilandroidapp.screens.averageUser.screens.normalScreen.Classes

import com.google.gson.annotations.SerializedName

data class Listing(
    @SerializedName("id")
    val id: String = "",
    @SerializedName("title")
    val title: String? = null ,
    @SerializedName("description")
    val description: String? = null,
    @SerializedName("shortDescription")
    val shortDescription: String? = null,
    @SerializedName("location")
    val location: ArrayList<String>? = null,
    @SerializedName("price")
    val price: Int? = null,
    @SerializedName("status")
    val status: Int? = null,
    @SerializedName("images")
    val images: ArrayList<String>? = null,
    @SerializedName("category")
    val category: String? = null,
    @SerializedName("author")
    val author: Author? = null,
    @SerializedName("viewCounter")
    val viewCounter: Int? = null ,
    @SerializedName("approvedBy")
    val approvedBy: String? = null ,
    @SerializedName("createdAt")
    val createdAt: String? = null ,
    @SerializedName("updatedAt")
    val updatedAt: String? = null,
)