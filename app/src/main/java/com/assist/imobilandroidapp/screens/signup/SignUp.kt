package com.assist.imobilandroidapp.screens.main

import android.content.Intent
import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.view.View
import android.widget.Toast
import com.assist.imobilandroidapp.R
import com.assist.imobilandroidapp.databinding.ActivitySignUpBinding
import com.assist.imobilandroidapp.screens.Validations.Validations
import com.assist.imobilandroidapp.screens.login.Login
import com.google.android.material.textfield.TextInputEditText

class SignUp : AppCompatActivity() {

    private lateinit var binding: ActivitySignUpBinding
    private lateinit var emailEditTextView: TextInputEditText
    private lateinit var passwordEditTextView: TextInputEditText

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        binding = ActivitySignUpBinding.inflate(layoutInflater)
        setContentView(binding.root)
        emailFocusListener()
        passwordFocusListener()
        emailEditTextView = findViewById(R.id.emailEditText)
        passwordEditTextView = findViewById(R.id.passwordEditText)

    }

    private fun emailFocusListener() {
        binding.emailEditText.setOnFocusChangeListener { _, focused ->
            if (!focused) {
                binding.emailContainer.helperText = Validations.validEmail(emailEditTextView)
            }
        }
    }

    private fun passwordFocusListener() {
        binding.passwordEditText.setOnFocusChangeListener { _, focused ->
            if (!focused) {
                binding.passwordContainer.helperText =
                    Validations.validPassword(passwordEditTextView)
            }
        }
    }


    fun signUpButton(view: View){
        // TODO:

        Toast.makeText(getApplicationContext(),"You will be directed to hotels list",Toast.LENGTH_SHORT).show();
    }

    fun goToLogin(view: View){
        val intent = Intent(this, Login::class.java)
        startActivity(intent)
    }

}