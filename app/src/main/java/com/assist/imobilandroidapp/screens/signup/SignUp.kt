package com.assist.imobilandroidapp.screens.main

import android.content.Intent
import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
<<<<<<< HEAD
import android.text.Editable
import android.text.TextWatcher
import android.util.Patterns
=======
>>>>>>> e95ef4ec55e64c82640c90aca2ee13f776e10e20
import android.view.View
import android.widget.Toast
import com.assist.imobilandroidapp.R
import com.assist.imobilandroidapp.databinding.ActivitySignUpBinding
<<<<<<< HEAD
import com.google.android.material.button.MaterialButton
=======
import com.assist.imobilandroidapp.screens.login.Login
>>>>>>> e95ef4ec55e64c82640c90aca2ee13f776e10e20
import com.google.android.material.textfield.TextInputEditText
import com.google.android.material.textfield.TextInputLayout
import java.util.regex.Pattern

class SignUp : AppCompatActivity() {

    private lateinit var emailEditTextView: TextInputEditText
    private lateinit var passwordEditTextView: TextInputEditText
    private lateinit var signupButton : MaterialButton
    private lateinit var emailContainerLayout : TextInputLayout
    private lateinit var passwordContainerLayout : TextInputLayout


    private val passwordPattern : Pattern = Pattern.compile("^" +
            "(?=.*[!?@#$%^&+=])" +     // at least 1 special character
            "(?=\\S+$)" +            // no white spaces
            ".{8,}" +                // at least 8 characters
            "$")


    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)

        setContentView(R.layout.activity_sign_up)

        emailEditTextView = findViewById(R.id.emailEditText)
        passwordEditTextView = findViewById(R.id.passwordEditText)
        signupButton = findViewById(R.id.signUpButton)
        emailContainerLayout = findViewById(R.id.emailContainer)
        passwordContainerLayout = findViewById(R.id.passwordContainer)


        emailContainerLayout.editText?.addTextChangedListener(object: TextWatcher{
            override fun beforeTextChanged(p0: CharSequence?, p1: Int, p2: Int, p3: Int) {
            }

            override fun onTextChanged(p0: CharSequence?, p1: Int, p2: Int, p3: Int) {
                val emailTextValue = emailContainerLayout.editText!!.text.toString()

                if(emailTextValue.isEmpty()){
                    emailContainerLayout.error = "Email is required"
                }
                else{
                    if(!Patterns.EMAIL_ADDRESS.matcher(emailTextValue).matches()) {
                        emailContainerLayout.error = "Invalid email address"
                    }
                    else {
                        emailContainerLayout.error = ""
                    }
                }
            }

            override fun afterTextChanged(p0: Editable?) {
            }
        })


        passwordContainerLayout.editText?.addTextChangedListener(object: TextWatcher {
            override fun beforeTextChanged(p0: CharSequence?, p1: Int, p2: Int, p3: Int) {
            }

            override fun onTextChanged(p0: CharSequence?, p1: Int, p2: Int, p3: Int) {
                val passwordValue  = passwordContainerLayout.editText!!.text.toString()

                if(passwordValue.isEmpty()){
                    passwordContainerLayout.error = "Password is required"
                }

                else {
                    if(!passwordPattern.matcher(passwordValue).matches()){
                        passwordContainerLayout.error = "Password needs to contain at least 8 characters and one number."
                    }
                    else {
                        passwordContainerLayout.error = ""
                    }
                }
            }

            override fun afterTextChanged(p0: Editable?) {
            }
        })
        signupButton.setOnClickListener{
            Toast.makeText(this, "Yaaay!", Toast.LENGTH_SHORT).show()
            startActivity(Intent(this,MainActivity::class.java))
            finish()
        }

    }





}