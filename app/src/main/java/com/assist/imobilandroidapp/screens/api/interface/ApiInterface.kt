package com.assist.imobilandroidapp.screens.api.`interface`

import com.assist.imobilandroidapp.screens.api.calsses.LogInBody
import com.assist.imobilandroidapp.screens.averageUser.screens.normalScreen.Classes.Author
import com.assist.imobilandroidapp.screens.averageUser.screens.normalScreen.Classes.Listing
import retrofit2.Call
import retrofit2.http.Body
import retrofit2.http.GET
import retrofit2.http.POST
import retrofit2.http.Query

interface ApiInterface {

    @POST("api/User/Authenticate")
    fun logIn(@Body logInBody: LogInBody ): Call<Author>

    @POST("api/User/Register")
    fun registerUser(@Query("Email") email: String, @Query("Password") password: String): Call<Author>

    @GET("api/User/search")
    fun getUserByEmail(@Query("Email") email: String): Call<Author>

    @POST("api/User/Reset/Password")
    fun forgotPassword(@Query("Email") email: String) : Call<Author>

    @GET("api/Listing")
    fun getListing() : Call<List<Listing>>
}