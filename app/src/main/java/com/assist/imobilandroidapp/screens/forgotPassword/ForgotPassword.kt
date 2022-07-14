package com.assist.imobilandroidapp.screens.forgotPassword

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
import com.google.android.material.textfield.TextInputLayout

class ForgotPassword : AppCompatActivity() {

    private lateinit var emailInputLayout: TextInputLayout
    private lateinit var sendEmailLinkButton : MaterialButton
    private lateinit var backToLoginTextView: TextView

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_forgot_password)

        emailInputLayout = findViewById(R.id.forgot_password_email_textInputLayout)
        sendEmailLinkButton = findViewById(R.id.forgot_password_material_button)
        backToLoginTextView = findViewById(R.id.back_to_login_textView)

        emailInputLayout.editText?.addTextChangedListener(object : TextWatcher{
            override fun beforeTextChanged(p0: CharSequence?, p1: Int, p2: Int, p3: Int) {

            }

            override fun onTextChanged(p0: CharSequence?, p1: Int, p2: Int, p3: Int) {
                val value = emailInputLayout.editText?.text!!

                if ( value.isEmpty() ) {
                    emailInputLayout.error = ""
                } else {
                    if (!Patterns.EMAIL_ADDRESS.matcher(value).matches()) {
                        emailInputLayout.error = "Wrong email."
                    } else {
                        emailInputLayout.error = ""
                    }
                }
            }

            override fun afterTextChanged(p0: Editable?) {
            }

        })

        sendEmailLinkButton.setOnClickListener {

            if ( emailValidationEmptyCase(emailInputLayout) ) {

                Toast.makeText(this, "Clicked on button!", Toast.LENGTH_SHORT).show()
            }
        }

        backToLoginTextView.setOnClickListener {
            startActivity(Intent(this, Login::class.java))
            finish()
        }
    }

    private fun emailValidationEmptyCase( input: TextInputLayout) : Boolean {

        val value = input.editText?.text!!

        if ( value.isEmpty() ) {
            input.error = "Please enter your email."
            return false
        }
        return true
    }
}