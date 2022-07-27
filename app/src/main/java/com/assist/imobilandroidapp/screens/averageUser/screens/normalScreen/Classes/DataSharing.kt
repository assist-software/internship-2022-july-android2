package com.assist.imobilandroidapp.screens.averageUser.screens.normalScreen.Classes

import android.content.SharedPreferences
import com.google.gson.Gson
import com.google.gson.reflect.TypeToken

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
const val USER_ID = "userId"
const val USER_FULLNAME = "userFullName"
const val USER_EMAIL = "userEmail"
const val USER_PASSWORD = "userPassword"
const val USER_GENDER = "userGender"
const val USER_PHONE = "userPhone"
const val USER_ROLE = "userRole"
const val USER_DATEOFBIRTH = "userDateOfBirth"
const val USER_ADDRESS = "userAddress"
const val USER_PHOTO = "userPhoto"
const val USER_USERACTIVITIES = "userActivities"
const val USER_CREATEDAT = "userCreatedAt"
const val USER_UPDATEDAT = "userUpdatedAt"
const val USER_ISACTIVE = "userIsActive"
const val USER_LISTINGS = "userListings"
const val USER_LOGIN_TOKEN = "userToken"
const val REMEMBER_LOGIN_TOKEN = "rememberLoginToken"
const val USER = "justUser"

object DataSharing {

    private lateinit var sharedPreferences: SharedPreferences
    private lateinit var editor: SharedPreferences.Editor

    fun init(_sharedPreferences: SharedPreferences) {
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

    fun commit() {
        editor.commit()
    }

    fun clear() {
        editor.clear()
    }

    fun logoutUser(value: String?){
        editor.remove(value)
    }

    fun saveUserId(value: String) {
        editor.putString(USER_ID, value)
    }

    fun saveUserFullName(value: String) {
        editor.putString(USER_FULLNAME, value)
    }

    fun saveUserEmail(value: String) {
        editor.putString(USER_EMAIL, value)
    }

    fun saveUserPassword(value: String) {
        editor.putString(USER_PASSWORD, value)
    }

    fun saveUserGender(value: Int) {
        editor.putInt(USER_GENDER, value)
    }

    fun saveUserPhone(value: String) {
        editor.putString(USER_PHONE, value)
    }

    fun saveUserRole(value: Int) {
        editor.putInt(USER_ROLE, value)
    }

    fun saveUserDateOfBirth(value: String) {
        editor.putString(USER_DATEOFBIRTH, value)
    }

    fun saveUserAddress(value: String) {
        editor.putString(USER_ADDRESS, value)
    }

    fun saveUserPhoto(value: String) {
        editor.putString(USER_PHOTO, value)
    }

    fun saveUserActivities(value: UserActivities) {
        val gson = Gson()
        val stringObj = gson.toJson(value)
        editor.putString(USER_USERACTIVITIES, stringObj)
    }

    fun saveUserLoginToken(value: String?) {
        if(value!=null){
            editor.putString(USER_LOGIN_TOKEN,value)
        }
    }

    fun saveUserCreatedAt(value: String) {
        editor.putString(USER_CREATEDAT, value)
    }

    fun saveUserUpdatedAt(value: String) {
        editor.putString(USER_UPDATEDAT, value)
    }

    fun saveUserIsActive(value: Boolean) {
        editor.putBoolean(USER_ISACTIVE, value)
    }

    fun saveUserListings(value: List<Listing?>) {
        val gson = Gson()
        val listObj = gson.toJson(value)
        editor.putString(USER_LISTINGS, listObj)
    }

    fun saveUser(author: Author){
        val gson = Gson()
        val authorResponseObj = gson.toJson(author)
        editor.putString(USER,authorResponseObj)
    }

    fun saveRememberUser(author: Author){
        val gson = Gson()
        val savedAuthorObj = gson.toJson(author)
        editor.putString(REMEMBER_LOGIN_TOKEN,savedAuthorObj)
    }

    fun rememberUserLogin(value : String){
        editor.putString(REMEMBER_LOGIN_TOKEN,value)
    }

    fun getUserId(): String  {
        return sharedPreferences.getString(USER_ID, null).toString()
    }

    fun getUserFullName(): String {
        return sharedPreferences.getString(USER_FULLNAME, null).toString()
    }

    fun getUserEmail(): String {
        return sharedPreferences.getString(USER_EMAIL, null).toString()
    }

    fun getUserPassword(): String {
        return sharedPreferences.getString(USER_PASSWORD, null).toString()
    }

    fun getUserGender(): Int {
        return sharedPreferences.getInt(USER_GENDER, -1)
    }

    fun getUserPhone(): String {
        return sharedPreferences.getString(USER_PHONE, null).toString()
    }

    fun getUserRole(): Int {
        return sharedPreferences.getInt(USER_ROLE, -1)
    }

    fun getUserDateOfBirth(): String {
        return sharedPreferences.getString(USER_DATEOFBIRTH, null).toString()
    }

    fun getUserAddress(): String {
        return sharedPreferences.getString(USER_ADDRESS, null).toString()
    }

    fun getUserPhoto(): String {
        return sharedPreferences.getString(USER_PHOTO, null).toString()
    }

    fun getUserActivities(): UserActivities {
        val gson = Gson()
        val stringListObj = sharedPreferences.getString(USER_LISTINGS, null)

        return gson.fromJson(stringListObj, UserActivities::class.java)
    }

    fun getUserLoginToken(): String {
        return sharedPreferences.getString(USER_LOGIN_TOKEN, null).toString()
    }

    fun getUserCreatedAt(): String {
        return sharedPreferences.getString(USER_CREATEDAT, null).toString()
    }

    fun getUserUpdatedAt(): String {
        return sharedPreferences.getString(USER_UPDATEDAT, null).toString()
    }

    fun getUserIsActive(): Boolean {
        return sharedPreferences.getBoolean(USER_ISACTIVE, false)
    }

    inline fun <reified T> Gson.fromJson(json: String) = fromJson<T>(json, object: TypeToken<T>() {}.type)

    fun getUserListings(): List<Listing> {
        val stringListObj = sharedPreferences.getString(USER_LISTINGS,null)
        var listings : List<Listing> = listOf()
        if ( stringListObj != null ) {
            listings = Gson().fromJson(stringListObj)
        }
        return listings
    }

    fun getUser() : Author? {
        val authorObj = sharedPreferences.getString(USER,null)
        var author: Author? = null
        if ( authorObj != null ) {
            author = Gson().fromJson(authorObj)
        }
        return author
    }

    fun getSavedAuthor() : Author? {
        val savedAuthObj = sharedPreferences.getString(REMEMBER_LOGIN_TOKEN,null)
        var author: Author? = null
        if ( savedAuthObj != null ) {
            author = Gson().fromJson(savedAuthObj)
        }
        return author
    }
}
