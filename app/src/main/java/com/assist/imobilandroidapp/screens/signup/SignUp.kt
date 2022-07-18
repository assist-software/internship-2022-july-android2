package com.assist.imobilandroidapp.screens.signup

import android.content.Intent
import android.os.Bundle
import android.text.Editable
import android.text.TextWatcher
import android.util.Patterns
import android.widget.Toast
import androidx.appcompat.app.AppCompatActivity
import com.assist.imobilandroidapp.R
import com.assist.imobilandroidapp.databinding.ActivitySignUpBinding
import com.assist.imobilandroidapp.screens.forgotPassword.EMPTY_STRING
import com.assist.imobilandroidapp.screens.login.Login
import com.google.android.material.textfield.TextInputLayout
import java.util.regex.Pattern

class SignUp : AppCompatActivity() {

    private lateinit var binding: ActivitySignUpBinding

    private val passwordPattern: Pattern = Pattern.compile(
        "^" +
                "(?=.*[!?@#$%^&+=])" +     // at least 1 special character
                "(?=\\S+$)" +            // no white spaces
                ".{8,}" +                // at least 8 characters
                "$"
    )

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        binding = ActivitySignUpBinding.inflate(layoutInflater)
        setContentView(binding.root)


        binding.singupEmailTextInputLayout.editText?.addTextChangedListener(object : TextWatcher {
            override fun beforeTextChanged(p0: CharSequence?, p1: Int, p2: Int, p3: Int) {
            }

            override fun onTextChanged(p0: CharSequence?, p1: Int, p2: Int, p3: Int) {
                emailOnTextChanged(binding.singupEmailTextInputLayout)
            }

            override fun afterTextChanged(p0: Editable?) {
            }
        })

        binding.singupPasswordTextInputLayout.editText?.addTextChangedListener(object : TextWatcher {
            override fun beforeTextChanged(p0: CharSequence?, p1: Int, p2: Int, p3: Int) {
            }

            override fun onTextChanged(p0: CharSequence?, p1: Int, p2: Int, p3: Int) {
                passwordOnTextChanged(binding.singupPasswordTextInputLayout)
            }

            override fun afterTextChanged(p0: Editable?) {
            }
        })

        binding.singupSignUpButton.setOnClickListener {
            if (emptyInputValidation(binding.singupEmailTextInputLayout) && emptyInputValidation(binding.singupPasswordTextInputLayout)) {
                Toast.makeText(this, "Yaaay!", Toast.LENGTH_SHORT).show()
            }
        }

        binding.singupLogInTextView.setOnClickListener {
            loginTextViewClick()
        }

        binding.singupLogInTextView.setOnClickListener {
            startActivity(Intent(this,Login::class.java))
            finish()
        }

    }

    private fun loginTextViewClick() {
        startActivity(Intent(this, Login::class.java))
        finish()
    }

    private fun emailOnTextChanged(input: TextInputLayout){
        val emailTextValue = input.editText?.text ?: ""

        input.error = if (emailTextValue.isEmpty()) {
            EMPTY_STRING
        } else {
            if (!Patterns.EMAIL_ADDRESS.matcher(emailTextValue).matches()) {
                getString(R.string.wrong_email)
            } else {
                EMPTY_STRING
            }
        }
    }

    private fun passwordOnTextChanged(input: TextInputLayout){
        val passwordValue = input.editText?.text?: ""

        input.error =  if (passwordValue.isEmpty()) {
            EMPTY_STRING
        } else {
            if (!passwordPattern.matcher(passwordValue).matches()) {
                getString(R.string.password_not_match)
            } else {
                EMPTY_STRING
            }
        }
    }

    private fun emptyInputValidation(input: TextInputLayout): Boolean {
        val value = input.editText?.text!!

        if (value.isEmpty()) {
            input.error = "Please fill in the field."
            return false
        }
        return true
    }


}