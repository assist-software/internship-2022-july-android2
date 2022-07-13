package com.assist.imobilandroidapp.screens.Validations

import android.util.Patterns
import com.google.android.material.textfield.TextInputEditText

class Validations {
    companion object {

        fun validEmail(emailText: TextInputEditText): String? {


            val emailTextValue = emailText.text.toString();
            if (!Patterns.EMAIL_ADDRESS.matcher(emailTextValue).matches()) {
                return "Invalid email address"
            }
            return null
        }

        fun validPassword(passwordEditText: TextInputEditText): String? {

            val passwordText = passwordEditText.text.toString();

            if (passwordText.length < 8) {
                return "At least 8 characters and one number."
            }

//        if(!passwordText.matches(".*[A-Z]*.".toRegex()))
//        {
//            return "Must contain 1 uppercase caracter"
//        }

//        if(!passwordText.matches(".*[a-z]*.".toRegex()))
//        {
//            return "Must contain 1 lowercase caracter"
//        }

//        if(!passwordText.matches(".*[@#\$%^&+=]*.".toRegex()))
//        {
//            return "Must contain 1 special caracter"
//        }
            return null
        }


    }
}