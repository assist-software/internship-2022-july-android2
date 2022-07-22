package com.assist.imobilandroidapp.screens.averageUser.screens.normalScreen.Classes

import com.google.gson.annotations.SerializedName

data class Listing(
    @SerializedName("approvedBy")
    val approvedBy: String?,
    @SerializedName("author")
    val author: Author?,
    @SerializedName("category")
    val category: String?,
    @SerializedName("createdAt")
    val createdAt: String?,
    @SerializedName("description")
    val description: String?,
    @SerializedName("id")
    val id: String?,
    @SerializedName("images")
    val images: String?,
    @SerializedName("location")
    val location: String?,
    @SerializedName("price")
    val price: Int?,
    @SerializedName("shortDescription")
    val shortDescription: String?,
    @SerializedName("status")
    val status: Int?,
    @SerializedName("title")
    val title: String?,
    @SerializedName("updatedAt")
    val updatedAt: String?,
    @SerializedName("viewCounter")
    val viewCounter: Int?
)