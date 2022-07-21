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
import com.assist.imobilandroidapp.screens.api.calsses.*
import com.assist.imobilandroidapp.screens.api.response.UserResponse
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
                singUpButtonClick(
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

    private fun singUpButtonClick(email: String, password: String) {
        val retrofitInstance = RetrofitInstance.getRetrofitInstance().create(ApiInterface::class.java)

        DataSharing.init(getSharedPreferences(SHARED_KEY, MODE_PRIVATE))

        retrofitInstance.registerUser(email, password).enqueue(object : Callback<UserResponse> {
            override fun onResponse(call: Call<UserResponse>, response: Response<UserResponse>) {
                if (response.code() == 200) {
                    Toast.makeText(
                        this@SignUp,
                        getString(R.string.singUp_success),
                        Toast.LENGTH_SHORT
                    ).show()

                    DataSharing.apply {
                        response.body()?.let {
                            saveUserId(it.id.toString())
                            saveUserFullName(it.fullName.toString())
                            saveUserEmail(it.email.toString())
                            saveUserPassword(it.password.toString())
                            saveUserGender(it.gender)
                            saveUserPhone(it.phone.toString())
                            saveUserRole(it.role)
                            saveUserDateOfBirth(it.dateOfBirth.toString())
                            saveUserAddress(it.address.toString())
                            saveUserPhoto(it.photo.toString())
                            it.userActivities?.let { it1 -> saveUserActivities(it1) }
                            saveUserCreatedAt(it.createdAt.toString())
                            saveUserUpdatedAt(it.updatedAt.toString())
                            saveUserIsActive(it.isActive)
                            it.listings?.let { it1 -> saveUserListings(it1) }
                        }
                        commit()
                    }
                    Handler().postDelayed({
                        startActivity(Intent(this@SignUp, Login::class.java))
                        finish()
                    }, 1000)
                } else {
                    Toast.makeText(
                        this@SignUp,
                        getString(R.string.singUp_failed),
                        Toast.LENGTH_SHORT
                    ).show()
                }
            }

            override fun onFailure(call: Call<UserResponse>, t: Throwable) {
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