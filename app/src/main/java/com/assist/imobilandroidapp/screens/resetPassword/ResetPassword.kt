package com.assist.imobilandroidapp.screens.resetPassword

import android.content.Intent
import android.os.Bundle
import android.text.Editable
import android.text.TextWatcher
import android.widget.Toast
import androidx.appcompat.app.AppCompatActivity
import com.assist.imobilandroidapp.R
import com.assist.imobilandroidapp.databinding.ActivityResetPasswordBinding
import com.assist.imobilandroidapp.screens.forgotPassword.EMPTY_STRING
import com.assist.imobilandroidapp.screens.login.Login
import com.google.android.material.textfield.TextInputLayout
import java.util.regex.Pattern

class ResetPassword : AppCompatActivity() {

    private lateinit var binding: ActivityResetPasswordBinding
    private var newPasswordValue: String = ""

    private val passwordPattern: Pattern = Pattern.compile(
        "^" +
                "(?=.*[!?@#$%^&+=])" +     // at least 1 special character
                "(?=\\S+$)" +            // no white spaces
                ".{8,}" +                // at least 8 characters
                "$"
    )

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        binding = ActivityResetPasswordBinding.inflate(layoutInflater)
        setContentView(binding.root)

        binding.resetPasswordNewPasswordTextInputLayout.editText?.addTextChangedListener(object : TextWatcher {
            override fun beforeTextChanged(p0: CharSequence?, p1: Int, p2: Int, p3: Int) {
            }

            override fun onTextChanged(p0: CharSequence?, p1: Int, p2: Int, p3: Int) {
                newPasswordInputOnTextChanged(binding.resetPasswordNewPasswordTextInputLayout)
            }

            override fun afterTextChanged(p0: Editable?) {
            }
        })

        binding.resetPasswordConfirmPasswordTextInputLayout.editText?.addTextChangedListener(object : TextWatcher {
            override fun beforeTextChanged(p0: CharSequence?, p1: Int, p2: Int, p3: Int) {
            }

            override fun onTextChanged(p0: CharSequence?, p1: Int, p2: Int, p3: Int) {
                confirmPasswordInputOnTextChanged(binding.resetPasswordConfirmPasswordTextInputLayout)
            }

            override fun afterTextChanged(p0: Editable?) {
            }
        })

        binding.resetPasswordMaterialButton.setOnClickListener {
            resetPasswordButtonClick(binding.resetPasswordNewPasswordTextInputLayout, binding.resetPasswordConfirmPasswordTextInputLayout)
        }
    }

    private fun newPasswordInputOnTextChanged(input: TextInputLayout) {
        val value = input.editText?.text?.toString()

        input.error = if (value.isNullOrEmpty()) {
            EMPTY_STRING
        } else {
            if (!passwordPattern.matcher(value).matches()) {
                getString(R.string.password_not_match)
            } else {
                EMPTY_STRING
            }
        }.toString()

        newPasswordValue = value.toString()
    }

    private fun confirmPasswordInputOnTextChanged(input: TextInputLayout) {
        val value = input.editText?.text?.toString()

        input.error = if (newPasswordValue.isEmpty()) {
            getString(R.string.new_password_not_exist)
        } else {
            if (value.isNullOrEmpty()) {
                EMPTY_STRING
            } else {
                if (newPasswordValue != value) {
                    getString(R.string.confirm_password_not_match_with_new_password)
                } else {
                    EMPTY_STRING
                }
            }
        }.toString()
    }

    private fun resetPasswordButtonClick(newPasswordInput: TextInputLayout, confirmPasswordInput: TextInputLayout) {
        val newPasswordValue = newPasswordInput.editText?.text?.toString()
        val confirmPasswordValue = confirmPasswordInput.editText?.text?.toString()

        newPasswordInput.error = if (newPasswordValue.isNullOrEmpty()) {
            getString(R.string.password_not_typed)
        } else {
            EMPTY_STRING
        }.toString()

        confirmPasswordInput.error = if (confirmPasswordValue.isNullOrEmpty()) {
            getString(R.string.password_not_typed)
        } else {
            EMPTY_STRING
        }.toString()

        if (!newPasswordValue.isNullOrEmpty() && !confirmPasswordValue.isNullOrEmpty()) {
            Toast.makeText(this, "Clicked on button!", Toast.LENGTH_SHORT).show()
            startActivity(Intent(this, Login::class.java))
            finish()
        }
    }
}