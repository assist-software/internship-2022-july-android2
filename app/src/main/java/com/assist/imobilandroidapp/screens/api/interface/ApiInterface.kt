package com.assist.imobilandroidapp.screens.api.`interface`

import com.assist.imobilandroidapp.screens.api.calsses.LogInBody
import com.assist.imobilandroidapp.screens.api.calsses.SingUpBody
import okhttp3.ResponseBody
import retrofit2.http.Body
import retrofit2.http.POST
import retrofit2.http.Url

interface ApiInterface {

    @POST("api/User/Authenticate")
    fun logIn(@Body logInBody: LogInBody): retrofit2.Call<ResponseBody>

    @POST
    fun registerUser(@Url url:String,@Body sinUpBody: SingUpBody): retrofit2.Call<ResponseBody>
}