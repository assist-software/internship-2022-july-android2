package com.assist.imobilandroidapp.screens.signup

import android.content.Intent
import android.os.Bundle
import android.os.Handler
import android.text.Editable
import android.text.TextWatcher
import android.util.Patterns
import android.widget.Toast
import androidx.appcompat.app.AppCompatActivity
import com.assist.imobilandroidapp.R
import com.assist.imobilandroidapp.databinding.ActivitySignUpBinding
import com.assist.imobilandroidapp.screens.api.`interface`.ApiInterface
import com.assist.imobilandroidapp.screens.api.calsses.BASE_URL
import com.assist.imobilandroidapp.screens.api.calsses.LogInBody
import com.assist.imobilandroidapp.screens.api.calsses.RetrofitInstance
import com.assist.imobilandroidapp.screens.api.calsses.SingUpBody
import com.assist.imobilandroidapp.screens.averageUser.screens.mainScreen.MainScreen
import com.assist.imobilandroidapp.screens.forgotPassword.EMPTY_STRING
import com.assist.imobilandroidapp.screens.login.Login
import com.google.android.material.textfield.TextInputLayout
import okhttp3.ResponseBody
import retrofit2.Call
import retrofit2.Callback
import retrofit2.Response
import java.util.regex.Pattern

class SignUp : AppCompatActivity() {

    private lateinit var binding: ActivitySignUpBinding

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

        binding.singupSignUpButton.setOnClickListener {
            if (emptyInputValidation(binding.singupEmailTextInputLayout) && emptyInputValidation(binding.singupPasswordTextInputLayout)) {
                singUpButtonClick(binding.singupEmailTextInputLayout.editText?.text.toString(),binding.singupPasswordTextInputLayout.editText?.text.toString())
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

    private fun singUpButtonClick(email: String, password: String) {
        val retrofitInstance = RetrofitInstance.getRetrofitInstance().create(ApiInterface::class.java)
        val singUpBody = SingUpBody(email,password)

        retrofitInstance.registerUser("{$BASE_URL}api/User/Register?email=$email&password=$password",singUpBody).enqueue(object : Callback<ResponseBody> {
            override fun onResponse(call: Call<ResponseBody>, response: Response<ResponseBody>) {
                if ( response.code() == 200) {
                    Toast.makeText(this@SignUp, getString(R.string.singUp_success), Toast.LENGTH_SHORT).show()
                    Handler().postDelayed({
                        startActivity(Intent(this@SignUp, Login::class.java))
                        finish()
                    },1000)
                } else {
                    Toast.makeText(this@SignUp, getString(R.string.singUp_failed), Toast.LENGTH_SHORT).show()
                }
            }

            override fun onFailure(call: Call<ResponseBody>, t: Throwable) {
            }
        })
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

    private fun emptyInputValidation(input: TextInputLayout): Boolean {
        val value = input.editText?.text!!

        if (value.isEmpty()) {
            input.error = "Please fill in the field."
            return false
        }
        return true
    }


}