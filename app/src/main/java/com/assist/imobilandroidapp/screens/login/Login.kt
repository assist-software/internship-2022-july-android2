package com.assist.imobilandroidapp.screens.login

import android.content.Intent
import android.os.Bundle
import android.util.Log
import android.widget.Toast
import androidx.appcompat.app.AppCompatActivity
import com.assist.imobilandroidapp.R
import com.assist.imobilandroidapp.databinding.ActivityLoginBinding
import com.assist.imobilandroidapp.screens.api.`interface`.ApiInterface
import com.assist.imobilandroidapp.screens.api.calsses.LogInBody
import com.assist.imobilandroidapp.screens.api.calsses.RetrofitInstance
import com.assist.imobilandroidapp.screens.api.response.UserResponse
import com.assist.imobilandroidapp.screens.averageUser.screens.mainScreen.MainScreen
import com.assist.imobilandroidapp.screens.averageUser.screens.normalScreen.Classes.DataSharing
import com.assist.imobilandroidapp.screens.averageUser.screens.normalScreen.Classes.SHARED_KEY
import com.assist.imobilandroidapp.screens.forgotPassword.ForgotPassword
import com.assist.imobilandroidapp.screens.signup.SignUp
import retrofit2.Call
import retrofit2.Callback
import retrofit2.Response

class Login : AppCompatActivity() {

    private lateinit var binding: ActivityLoginBinding
    private lateinit var userResponse : UserResponse

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

//        verifyUserTokenLogin()
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

        DataSharing.init(getSharedPreferences(SHARED_KEY, MODE_PRIVATE))

        retrofitInstance.logIn(LogInBody(email,password)).enqueue(object : Callback<UserResponse> {
            override fun onResponse(call: Call<UserResponse>, response: Response<UserResponse>) {
                if ( response.code() == 200 ){
                    if(response.body()?.id.equals(DataSharing.getUserId()) && binding.loginRememberMeCheckBox.isChecked){
                        DataSharing.saveUserLoginToken(response.body()?.token.toString())
                        userResponse = UserResponse(
                            DataSharing.getUserId(),
                            DataSharing.getUserFullName(),
                            DataSharing.getUserEmail(),
                            DataSharing.getUserPassword(),
                            DataSharing.getUserGender(),
                            DataSharing.getUserPhone(),
                            DataSharing.getUserRole(),
                            DataSharing.getUserDateOfBirth(),
                            DataSharing.getUserAddress(),
                            DataSharing.getUserPhoto(),
                            DataSharing.getUserActivities(),
                            DataSharing.getUserLoginToken(),
                            DataSharing.getUserCreatedAt(),
                            DataSharing.getUserUpdatedAt(),
                            DataSharing.getUserIsActive(),
                            DataSharing.getUserListings()
                        )
                        DataSharing.commit()
                        Log.d("USERAFTERLOGIN",userResponse.toString())
                    }
                    toMainScreen()
                } else {
                    Toast.makeText(this@Login, getString(R.string.login_failed), Toast.LENGTH_SHORT).show()
                }
            }

            override fun onFailure(call: Call<UserResponse>, t: Throwable) {
            }
        })
    }

    private fun toMainScreen(){
        Toast.makeText(this, getString(R.string.login_success), Toast.LENGTH_SHORT).show()
        startActivity(Intent(this,MainScreen::class.java))
        finish()
    }

//    private fun verifyUserTokenLogin(){
//        val retrofitInstance = RetrofitInstance.getRetrofitInstance().create(ApiInterface::class.java)
//
//        retrofitInstance.getUserByEmail(userResponse.email.toString()).enqueue(object : Callback<UserResponse>{
//            override fun onResponse(call: Call<UserResponse>, response: Response<UserResponse>) {
//                if(response.code() == 200 ) {
//                    if (userResponse.token.equals(response.body()?.token)){
//                        toMainScreen()
//                    }
//                }
//            }
//
//            override fun onFailure(call: Call<UserResponse>, t: Throwable) {
//            }
//        })
//    }
}