package com.assist.imobilandroidapp.screens.login

import android.content.Intent
import android.os.Bundle
import android.widget.Toast
import androidx.appcompat.app.AppCompatActivity
import com.assist.imobilandroidapp.R
import com.assist.imobilandroidapp.databinding.ActivityLoginBinding
import com.assist.imobilandroidapp.screens.averageUser.screens.mainScreen.MainScreen
import com.assist.imobilandroidapp.screens.signup.SignUp

class Login : AppCompatActivity() {

    private lateinit var binding: ActivityLoginBinding

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        binding = ActivityLoginBinding.inflate(layoutInflater)
        setContentView(binding.root)

        binding.loginButton.setOnClickListener {
            loginButtonClick()
        }

        binding.loginWithGoogleButton.setOnClickListener {
            loginWithGoogleButtonClick()
        }

        binding.signUPTextView.setOnClickListener {
            singUpTextViewClick()
        }
    }

    private fun singUpTextViewClick() {
        startActivity(Intent(this,SignUp::class.java))
        finish()
    }

    private fun loginWithGoogleButtonClick() {
        Toast.makeText(this, getString(R.string.login_google_button) , Toast.LENGTH_SHORT).show()
    }

    private fun loginButtonClick() {
        startActivity(Intent(this,MainScreen::class.java))
        finish()
    }
}