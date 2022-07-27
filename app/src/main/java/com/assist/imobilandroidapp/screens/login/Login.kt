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
import com.assist.imobilandroidapp.screens.averageUser.screens.mainScreen.ClientMainScreen
import com.assist.imobilandroidapp.screens.averageUser.screens.normalScreen.Classes.Author
import com.assist.imobilandroidapp.screens.averageUser.screens.normalScreen.Classes.DataSharing
import com.assist.imobilandroidapp.screens.averageUser.screens.normalScreen.Classes.SHARED_KEY
import com.assist.imobilandroidapp.screens.forgotPassword.ForgotPassword
import com.assist.imobilandroidapp.screens.signup.SignUp
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
            loginButtonClick(
                binding.loginEmailTextInputLayout.editText?.text.toString(),
                binding.loginPasswordTextInputLayout.editText?.text.toString()
            )
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
        startActivity(Intent(this, ForgotPassword::class.java))
        finish()
    }

    private fun singUpTextViewClick() {
        startActivity(Intent(this, SignUp::class.java))
        finish()
    }

    private fun loginWithGoogleButtonClick() {
        Toast.makeText(this, getString(R.string.login_google_button), Toast.LENGTH_SHORT).show()
    }

    private fun loginButtonClick(email: String, password: String) {
        val retrofitInstance =
            RetrofitInstance.getRetrofitInstance().create(ApiInterface::class.java)

        DataSharing.init(getSharedPreferences(SHARED_KEY, MODE_PRIVATE))

        retrofitInstance.logIn(LogInBody(email, password)).enqueue(object : Callback<Author> {
            override fun onResponse(call: Call<Author>, response: Response<Author>) {
                if (response.code() == 200) {
                    Toast.makeText(
                        this@Login,
                        getString(R.string.login_success),
                        Toast.LENGTH_SHORT
                    ).show()
                    if (binding.loginRememberMeCheckBox.isChecked) {
                        DataSharing.saveRememberUser(response.body()!!)
                    }
                    DataSharing.saveUser(response.body()!!)
                    DataSharing.commit()
                    toMainScreen()
                } else {
                    Toast.makeText(this@Login, getString(R.string.login_failed), Toast.LENGTH_SHORT)
                        .show()
                }
            }

            override fun onFailure(call: Call<Author>, t: Throwable) {
            }
        })
    }

    private fun toMainScreen() {
        startActivity(Intent(this, ClientMainScreen::class.java))
        finish()
    }
}