package com.assist.imobilandroidapp.screens.resetPassword

import android.content.Intent
import android.os.Bundle
import android.text.Editable
import android.text.TextWatcher
import android.widget.Toast
import androidx.appcompat.app.AppCompatActivity
import com.assist.imobilandroidapp.R
import com.assist.imobilandroidapp.screens.main.Login
import com.google.android.material.button.MaterialButton
import com.google.android.material.textfield.TextInputLayout
import java.util.regex.Pattern

class ResetPassword : AppCompatActivity() {

    private lateinit var newPasswordTextInputLayout: TextInputLayout
    private lateinit var confirmPasswordTextInputLayout: TextInputLayout
    private lateinit var confirmPasswordButton : MaterialButton
    private  var newPasswordValue : String? = null

    private val passwordPattern : Pattern = Pattern.compile("^" +
            "(?=.*[!?@#$%^&+=])" +     // at least 1 special character
            "(?=\\S+$)" +            // no white spaces
            ".{8,}" +                // at least 8 characters
            "$")

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_reset_password)

        confirmPasswordButton = findViewById(R.id.reset_password_material_button)
        newPasswordTextInputLayout = findViewById(R.id.reset_password_new_password_textInputLayout)
        confirmPasswordTextInputLayout = findViewById(R.id.reset_password_confirm_password_textInputLayout)

        newPasswordTextInputLayout.editText?.addTextChangedListener(object : TextWatcher {
            override fun beforeTextChanged(p0: CharSequence?, p1: Int, p2: Int, p3: Int) {

            }

            override fun onTextChanged(p0: CharSequence?, p1: Int, p2: Int, p3: Int) {
                val value = newPasswordTextInputLayout.editText!!.text.toString()
                if (value.isEmpty()) {
                    newPasswordTextInputLayout.error = ""
                } else {
                    if (!passwordPattern.matcher(value).matches()) {
                        newPasswordTextInputLayout.error = "The password doesn't meet the criteria."
                    } else {
                        newPasswordTextInputLayout.error = ""
                        newPasswordValue = value
                    }
                }
            }

            override fun afterTextChanged(p0: Editable?) {

            }

        })

        confirmPasswordTextInputLayout.editText?.addTextChangedListener(object : TextWatcher {
            override fun beforeTextChanged(p0: CharSequence?, p1: Int, p2: Int, p3: Int) {

            }

            override fun onTextChanged(p0: CharSequence?, p1: Int, p2: Int, p3: Int) {
                val value = confirmPasswordTextInputLayout.editText!!.text.toString()

                if (value.isEmpty()) {
                    confirmPasswordTextInputLayout.error = ""
                } else {
                    if (newPasswordValue == null) {
                        confirmPasswordTextInputLayout.error = "Your new password was not entered!"
                    } else {

                        if (value != newPasswordValue) {
                            confirmPasswordTextInputLayout.error = "Password doesn't match with the new password."
                        } else {
                            confirmPasswordTextInputLayout.error = ""
                        }
                    }
                }
            }

            override fun afterTextChanged(p0: Editable?) {

            }

        })

        confirmPasswordButton.setOnClickListener {
            Toast.makeText(this, "Clicked on button!", Toast.LENGTH_SHORT).show()
            startActivity(Intent(this,Login::class.java))
            finish()
        }
    }
}