package com.assist.imobilandroidapp.screens.main

import android.content.Intent
import android.os.Bundle
import android.text.Editable
import android.text.TextWatcher
import android.util.Patterns
import android.widget.TextView
import android.widget.Toast
import androidx.appcompat.app.AppCompatActivity
import com.assist.imobilandroidapp.R
import com.assist.imobilandroidapp.screens.login.Login
import com.google.android.material.button.MaterialButton
import com.google.android.material.textfield.TextInputEditText
import com.google.android.material.textfield.TextInputLayout
import java.util.regex.Pattern

class SignUp : AppCompatActivity() {

    private lateinit var emailEditTextView: TextInputEditText
    private lateinit var passwordEditTextView: TextInputEditText
    private lateinit var signupButton: MaterialButton
    private lateinit var emailContainerLayout: TextInputLayout
    private lateinit var passwordContainerLayout: TextInputLayout
    private lateinit var logInTextView : TextView


    private val passwordPattern: Pattern = Pattern.compile(
        "^" +
                "(?=.*[!?@#$%^&+=])" +     // at least 1 special character
                "(?=\\S+$)" +            // no white spaces
                ".{8,}" +                // at least 8 characters
                "$"
    )


    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)

        setContentView(R.layout.activity_sign_up)

        emailEditTextView = findViewById(R.id.emailEditText)
        passwordEditTextView = findViewById(R.id.passwordEditText)
        signupButton = findViewById(R.id.signUpButton)
        emailContainerLayout = findViewById(R.id.emailContainer)
        passwordContainerLayout = findViewById(R.id.passwordContainer)
        logInTextView = findViewById(R.id.logInTextView)


        emailContainerLayout.editText?.addTextChangedListener(object : TextWatcher {
            override fun beforeTextChanged(p0: CharSequence?, p1: Int, p2: Int, p3: Int) {
            }

            override fun onTextChanged(p0: CharSequence?, p1: Int, p2: Int, p3: Int) {
                val emailTextValue = emailContainerLayout.editText!!.text.toString()

                if (emailTextValue.isEmpty()) {
                    emailContainerLayout.error = "Email is required"
                } else {
                    if (!Patterns.EMAIL_ADDRESS.matcher(emailTextValue).matches()) {
                        emailContainerLayout.error = "Invalid email address"
                    } else {
                        emailContainerLayout.error = ""
                    }
                }
            }

            override fun afterTextChanged(p0: Editable?) {
            }
        })


        passwordContainerLayout.editText?.addTextChangedListener(object : TextWatcher {
            override fun beforeTextChanged(p0: CharSequence?, p1: Int, p2: Int, p3: Int) {
            }

            override fun onTextChanged(p0: CharSequence?, p1: Int, p2: Int, p3: Int) {
                val passwordValue = passwordContainerLayout.editText!!.text.toString()

                if (passwordValue.isEmpty()) {
                    passwordContainerLayout.error = "Password is required"
                } else {
                    if (!passwordPattern.matcher(passwordValue).matches()) {
                        passwordContainerLayout.error =
                            "Password needs to contain at least 8 characters and one number."
                    } else {
                        passwordContainerLayout.error = ""
                    }
                }
            }

            override fun afterTextChanged(p0: Editable?) {
            }
        })
        signupButton.setOnClickListener {

            if (emptyInputValidation(emailContainerLayout) && emptyInputValidation(passwordContainerLayout)) {
                Toast.makeText(this, "Yaaay!", Toast.LENGTH_SHORT).show()
            }
        }

        logInTextView.setOnClickListener{
            startActivity(Intent(this, Login::class.java))
            finish()
        }

    }

    private fun emptyInputValidation(input: TextInputLayout): Boolean {
        val value  = input.editText?.text!!

        if(value.isEmpty()){
            input.error = "Please fill in the field."
            return false
        }

        return true
    }


}