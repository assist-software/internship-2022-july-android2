package com.assist.imobilandroidapp.screens.averageUser.screens.normalScreen.Classes

import android.content.Context
import android.content.SharedPreferences
import androidx.appcompat.app.AppCompatActivity

const val SHARED_KEY = "pref"
const val ITEM_IMAGE = "image"
const val ITEM_SECOND_IMAGE = "secondImage"
const val ITEM_THIRD_IMAGE = "thirdImage"
const val ITEM_TITLE = "title"
const val ITEM_PRICE = "price"
const val ITEM_LOCATION = "location"
const val ITEM_DESCRIPTION = "description"
const val ITEM_SELLER_IMAGE = "sellerImage"
const val ITEM_SELLER_NAME = "sellerName"
const val ITEM_SELLER_JOINED = "sellerJoined"
const val ITEM_SELLER_RESPONSE_RATE = "sellerResponseRate"
const val ITEM_SELLER_RESPONSE_TIME = "sellerResponseTime"

object DataSharing {

    private lateinit var sharedPreferences: SharedPreferences
    private lateinit var editor : SharedPreferences.Editor

    fun init(_sharedPreferences: SharedPreferences){
        sharedPreferences = _sharedPreferences
        editor = sharedPreferences.edit()
    }

    fun getItemImage(): Int {
        return sharedPreferences.getInt(ITEM_IMAGE, -1)
    }

    fun getItemSecondImage(): Int {
        return sharedPreferences.getInt(ITEM_SECOND_IMAGE, -1)
    }

    fun getItemThirdImage(): Int {
        return sharedPreferences.getInt(ITEM_THIRD_IMAGE, -1)
    }

    fun getItemTitle(): String {
        return sharedPreferences.getString(ITEM_TITLE, null).toString()
    }

    fun getItemPrice(): String {
        return sharedPreferences.getString(ITEM_PRICE, null).toString()
    }

    fun getItemLocation(): String {
        return sharedPreferences.getString(ITEM_LOCATION, null).toString()
    }

    fun getItemDescription(): String {
        return sharedPreferences.getString(ITEM_DESCRIPTION, null).toString()
    }

    fun getItemSellerImage(): Int {
        return sharedPreferences.getInt(ITEM_SELLER_IMAGE, -1)
    }

    fun getItemSellerName(): String {
        return sharedPreferences.getString(ITEM_SELLER_NAME, null).toString()
    }

    fun getItemSellerJoined(): String {
        return sharedPreferences.getString(ITEM_SELLER_JOINED, null).toString()
    }

    fun getItemSellerResponseRate(): String {
        return sharedPreferences.getString(ITEM_SELLER_RESPONSE_RATE, null).toString()
    }

    fun getItemSellerResponseTime(): String {
        return sharedPreferences.getString(ITEM_SELLER_RESPONSE_TIME, null).toString()
    }

    fun addItemImage(key: String, value: Int) {
        editor.putInt(key, value)
    }

    fun addItemText(key: String, value: String) {
        editor.putString(key, value)
    }

    fun addSellerImage(key: String, value: Int) {
        editor.putInt(key, value)
    }

    fun addSellerInfo(key: String, value: String) {
        editor.putString(key, value)
    }

    fun commit(){
        editor.commit()
    }

    fun clear(){
        editor.clear()
    }
}