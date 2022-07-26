package com.assist.imobilandroidapp.screens.api.`interface`

import com.assist.imobilandroidapp.screens.api.calsses.LogInBody
import com.assist.imobilandroidapp.screens.averageUser.screens.normalScreen.Classes.Author
import com.assist.imobilandroidapp.screens.averageUser.screens.normalScreen.Classes.AuthorChange
import com.assist.imobilandroidapp.screens.averageUser.screens.normalScreen.Classes.Listing
import retrofit2.Call
import retrofit2.http.*

interface ApiInterface {

    @POST("api/User/Authenticate")
    fun logIn(@Body logInBody: LogInBody ): Call<Author>

    @POST("api/User/Register")
    fun registerUser(@Query("Email") email: String, @Query("Password") password: String): Call<String>

    @GET("api/User/search")
    fun getUserByEmail(@Query("Email") email: String): Call<Author>

    @POST("api/User/Reset/Password")
    fun forgotPassword(@Query("Email") email: String) : Call<Author>

    @GET("api/Listing")
    fun getListing() : Call<List<Listing>>

    @PUT("api/User")
    fun changeUserName(@Query("id") id : String , @Field("fullName") fullName : String?) : Call<Author>

    @PUT("api/User")
    fun changeEmail(@Query("id") id : String , @Field("email") email : String?) : Call<Author>
}