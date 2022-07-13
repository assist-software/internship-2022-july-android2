package com.assist.imobilandroidapp.screens.main

import android.content.Intent
import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.view.View
import com.assist.imobilandroidapp.R

class Login : AppCompatActivity() {
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_login)
    }




    fun goToForgotPassword(view: View){
        val intent = Intent(this, ForgotPassword::class.java)
        startActivity(intent)
    }

    fun goToSignUp(view: View ){
        val intent = Intent(this, SignUp::class.java)
        startActivity(intent)
    }
}