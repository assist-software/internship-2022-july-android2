package com.assist.imobilandroidapp.screens.main

import android.content.Intent
import android.os.Bundle
import android.util.Log
import androidx.appcompat.app.AppCompatActivity
import com.assist.imobilandroidapp.R
import com.assist.imobilandroidapp.screens.averageUser.screens.mainScreen.ClientMainScreen
import com.assist.imobilandroidapp.screens.averageUser.screens.normalScreen.Classes.DataSharing
import com.assist.imobilandroidapp.screens.averageUser.screens.normalScreen.Classes.SHARED_KEY
import com.assist.imobilandroidapp.screens.login.Login

var TOKEN = ""

class MainActivity : AppCompatActivity() {
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_sign_up)

        verifyUserTokenLogin()
    }

    private fun verifyUserTokenLogin(){

        DataSharing.init(getSharedPreferences(SHARED_KEY, MODE_PRIVATE))

        TOKEN = DataSharing.getUserLoginToken()

        if (TOKEN.isNotEmpty()) {
            startActivity(Intent(this, ClientMainScreen::class.java))
            finish()
        } else {
            startActivity(Intent(this,Login::class.java))
            finish()
        }
    }
}