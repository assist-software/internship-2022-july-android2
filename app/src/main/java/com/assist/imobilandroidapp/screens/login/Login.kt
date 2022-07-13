package com.assist.imobilandroidapp.screens.login

import android.content.Intent
import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.view.View
import com.assist.imobilandroidapp.R
import com.assist.imobilandroidapp.screens.forgotPassword.ForgotPassword
<<<<<<< HEAD
=======
import com.assist.imobilandroidapp.screens.main.SignUp
>>>>>>> e95ef4ec55e64c82640c90aca2ee13f776e10e20

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