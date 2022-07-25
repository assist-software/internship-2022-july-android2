package com.assist.imobilandroidapp.screens.main

import android.content.Intent
import android.os.Bundle
import androidx.appcompat.app.AppCompatActivity
import com.assist.imobilandroidapp.R
import com.assist.imobilandroidapp.screens.averageUser.screens.mainScreen.MainScreen
import com.assist.imobilandroidapp.screens.averageUser.screens.normalScreen.Classes.DataSharing
import com.assist.imobilandroidapp.screens.averageUser.screens.normalScreen.Classes.SHARED_KEY
import com.assist.imobilandroidapp.screens.averageUser.screens.normalScreen.Classes.TOKENS
import com.assist.imobilandroidapp.screens.login.Login

class MainActivity : AppCompatActivity() {
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_sign_up)

        verifyUserTokenLogin()
    }

    private fun verifyUserTokenLogin(){

        DataSharing.init(getSharedPreferences(SHARED_KEY, MODE_PRIVATE))

        val author = DataSharing.getUser()

        if ( author != null ){
            startActivity(Intent(this,MainScreen::class.java))
            finish()
        } else {
            startActivity(Intent(this,Login::class.java))
            finish()
        }
    }
}