package com.assist.imobilandroidapp.screens.averageUser.screens.mainScreen

import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.widget.Toolbar
import com.assist.imobilandroidapp.R
import kotlinx.android.synthetic.main.activity_main_screen.*

class MainScreen : AppCompatActivity() {

    private lateinit var mainScreenToolBar : androidx.appcompat.widget.Toolbar

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_main_screen)

        mainScreenToolBar = findViewById(R.id.main_screen_toolbar)

        mainScreenToolBar.title = ""
        setSupportActionBar(mainScreenToolBar)

    }
}