package com.assist.imobilandroidapp.screens.signup

import android.content.Intent
import android.os.Bundle
import android.os.Handler
import android.os.Looper
import android.text.Editable
import android.text.TextWatcher
import android.util.Log
import android.util.Patterns
import android.widget.Toast
import androidx.appcompat.app.AppCompatActivity
import com.assist.imobilandroidapp.R
import com.assist.imobilandroidapp.databinding.ActivitySignUpBinding
import com.assist.imobilandroidapp.screens.api.`interface`.ApiInterface
import com.assist.imobilandroidapp.screens.api.calsses.RetrofitInstance
import com.assist.imobilandroidapp.screens.averageUser.screens.normalScreen.Classes.DataSharing
import com.assist.imobilandroidapp.screens.averageUser.screens.normalScreen.Classes.SHARED_KEY
import com.assist.imobilandroidapp.screens.forgotPassword.EMPTY_STRING
import com.assist.imobilandroidapp.screens.login.Login
import com.google.android.material.textfield.TextInputLayout
import retrofit2.Call
import retrofit2.Callback
import retrofit2.Response

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
            if (emptyInputValidation(binding.singupEmailTextInputLayout) && emptyInputValidation(
                    binding.singupPasswordTextInputLayout
                )
            ) {
                registerUser(
                    binding.singupEmailTextInputLayout.editText?.text.toString(),
                    binding.singupPasswordTextInputLayout.editText?.text.toString()
                )
            }
        }

        binding.singupLogInTextView.setOnClickListener {
            loginTextViewClick()
        }

        binding.singupLogInTextView.setOnClickListener {
            startActivity(Intent(this, Login::class.java))
            finish()
        }
    }

    private fun registerUser(email: String, password: String) {

        val retrofitInstance =
            RetrofitInstance.getRetrofitInstance().create(ApiInterface::class.java)

        DataSharing.init(getSharedPreferences(SHARED_KEY, MODE_PRIVATE))

        retrofitInstance.registerUser(email, password).enqueue(object : Callback<String> {

            override fun onResponse(
                call: Call<String>,
                response: Response<String>
            ) {
                if (response.code() == 200) {
                    Log.d("RESPONSE REGISTER", response.body()!!)
                    Handler(Looper.myLooper()!!).postDelayed({
                        startActivity(Intent(this@SignUp, Login::class.java))
                        finish()
                    }, 1000)
                    Toast.makeText(
                        this@SignUp,
                        getString(R.string.singUp_success),
                        Toast.LENGTH_SHORT
                    ).show()
                } else {
                    Toast.makeText(
                        this@SignUp,
                        getString(R.string.singUp_failed),
                        Toast.LENGTH_SHORT
                    ).show()
                }
            }

            override fun onFailure(call: Call<String>, t: Throwable) {
                Toast.makeText(
                    this@SignUp,
                    getString(R.string.singUp_failed),
                    Toast.LENGTH_SHORT
                ).show()
            }
        })
    }

    private fun loginTextViewClick() {
        startActivity(Intent(this, Login::class.java))
        finish()
    }

    private fun emailOnTextChanged(input: TextInputLayout) {
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