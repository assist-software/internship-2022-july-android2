package com.assist.imobilandroidapp.screens.login

import android.content.Intent
import android.os.Bundle
import android.widget.Toast
import androidx.appcompat.app.AppCompatActivity
import com.assist.imobilandroidapp.R
import com.assist.imobilandroidapp.databinding.ActivityLoginBinding
import com.assist.imobilandroidapp.screens.api.`interface`.ApiInterface
import com.assist.imobilandroidapp.screens.api.calsses.LogInBody
import com.assist.imobilandroidapp.screens.api.calsses.RetrofitInstance
import com.assist.imobilandroidapp.screens.averageUser.screens.mainScreen.MainScreen
import com.assist.imobilandroidapp.screens.forgotPassword.ForgotPassword
import com.assist.imobilandroidapp.screens.signup.SignUp
import okhttp3.ResponseBody
import retrofit2.Call
import retrofit2.Callback
import retrofit2.Response

class Login : AppCompatActivity() {

    private lateinit var binding: ActivityLoginBinding

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        binding = ActivityLoginBinding.inflate(layoutInflater)
        setContentView(binding.root)

        binding.loginButton.setOnClickListener {
            loginButtonClick(binding.loginEmailTextInputLayout.editText?.text.toString(),binding.loginPasswordTextInputLayout.editText?.text.toString())
        }

        binding.loginWithGoogleButton.setOnClickListener {
            loginWithGoogleButtonClick()
        }

        binding.signUPTextView.setOnClickListener {
            singUpTextViewClick()
        }

        binding.forgotPasswordTextView.setOnClickListener {
            forgotPasswordTextViewClick()
        }
    }

    private fun forgotPasswordTextViewClick() {
        startActivity(Intent(this,ForgotPassword::class.java))
        finish()
    }

    private fun singUpTextViewClick() {
        startActivity(Intent(this,SignUp::class.java))
        finish()
    }

    private fun loginWithGoogleButtonClick() {
        Toast.makeText(this, getString(R.string.login_google_button) , Toast.LENGTH_SHORT).show()
    }

    private fun loginButtonClick(email:String,password:String) {
        val retrofitInstance = RetrofitInstance.getRetrofitInstance().create(ApiInterface::class.java)
        val logInInfo = LogInBody(email,password)

        retrofitInstance.logIn(logInInfo).enqueue(object : Callback<ResponseBody> {
            override fun onResponse(call: Call<ResponseBody>, response: Response<ResponseBody>) {
                if ( response.code() == 200) {
                    Toast.makeText(this@Login, getString(R.string.login_success), Toast.LENGTH_SHORT).show()
                    startActivity(Intent(this@Login,MainScreen::class.java))
                    finish()
                } else {
                    Toast.makeText(this@Login, getString(R.string.login_failed), Toast.LENGTH_SHORT).show()
                }
            }

            override fun onFailure(call: Call<ResponseBody>, t: Throwable) {

            }
        })
    }
}