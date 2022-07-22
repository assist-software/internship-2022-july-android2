package com.assist.imobilandroidapp.screens.api.`interface`

import com.assist.imobilandroidapp.screens.api.calsses.LogInBody
import com.assist.imobilandroidapp.screens.api.response.NewPasswordResponse
import com.assist.imobilandroidapp.screens.api.response.UserResponse
import retrofit2.Call
import retrofit2.Callback
import retrofit2.http.Body
import retrofit2.http.GET
import retrofit2.http.POST
import retrofit2.http.Query

interface ApiInterface {

    @POST("api/User/Authenticate")
    fun logIn(@Body logInBody: LogInBody ): Call<UserResponse>

    @POST("api/User/Register")
    fun registerUser(@Query("Email") email: String, @Query("Password") password: String): Call<UserResponse>

    @GET("api/User/search")
    fun getUserByEmail(@Query("Email") email: String): Call<UserResponse>

    @POST("api/User/Reset/Password")
    fun forgotPassword(@Query("Email") email: String) : Call<UserResponse>
}