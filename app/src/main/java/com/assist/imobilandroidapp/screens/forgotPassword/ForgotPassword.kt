package com.assist.imobilandroidapp.screens.forgotPassword

import android.content.Intent
import android.os.Bundle
import android.text.Editable
import android.text.TextWatcher
import android.util.Patterns
import android.widget.Toast
import androidx.appcompat.app.AppCompatActivity
import com.assist.imobilandroidapp.R
import com.assist.imobilandroidapp.databinding.ActivityForgotPasswordBinding
import com.assist.imobilandroidapp.screens.login.Login
import com.google.android.material.textfield.TextInputLayout

const val EMPTY_STRING = ""

class ForgotPassword : AppCompatActivity() {

    private lateinit var binding: ActivityForgotPasswordBinding

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        binding = ActivityForgotPasswordBinding.inflate(layoutInflater)
        setContentView(binding.root)

        binding.forgotPasswordEmailTextInputLayout.editText?.addTextChangedListener(object : TextWatcher {
            override fun beforeTextChanged(p0: CharSequence?, p1: Int, p2: Int, p3: Int) {
            }

            override fun onTextChanged(p0: CharSequence?, p1: Int, p2: Int, p3: Int) {
                onTextChanged(binding.forgotPasswordEmailTextInputLayout)
            }

            override fun afterTextChanged(p0: Editable?) {
            }
        })

        binding.forgotPasswordMaterialButton.setOnClickListener {
            sendEmailLinkButtonClick(binding.forgotPasswordEmailTextInputLayout)
        }

        binding.backToLoginTextView.setOnClickListener {
            backToLoginTextViewCLick()
        }
    }

    private fun backToLoginTextViewCLick(){
        startActivity(Intent(this, Login::class.java))
        finish()
    }

    private fun sendEmailLinkButtonClick(input: TextInputLayout) {
        val value = input.editText?.text ?: ""
        if ( value.isEmpty() ) {
            input.error = getString(R.string.please_enter_your_email)
        } else {
            Toast.makeText(this, "Success", Toast.LENGTH_SHORT).show()
        }
    }

    private fun onTextChanged(input: TextInputLayout) {
        val value = input.editText?.text ?: ""
        input.error = if (value.isEmpty()) {
            EMPTY_STRING
        } else {
            if (!Patterns.EMAIL_ADDRESS.matcher(value).matches()) {
                getString(R.string.wrong_email)
            } else {
                EMPTY_STRING
            }.toString()
        }.toString()
    }
}
