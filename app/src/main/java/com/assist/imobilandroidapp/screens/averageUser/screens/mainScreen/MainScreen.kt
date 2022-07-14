package com.assist.imobilandroidapp.screens.averageUser.screens.mainScreen

import android.os.Bundle
import android.widget.Toast
import androidx.appcompat.app.AppCompatActivity
import com.assist.imobilandroidapp.R
import com.assist.imobilandroidapp.screens.forgotPassword.EMPTY_STRING
import com.assist.imobilandroidapp.databinding.ActivityMainScreenBinding

class MainScreen : AppCompatActivity() {

    private lateinit var binding: ActivityMainScreenBinding

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        binding = ActivityMainScreenBinding.inflate(layoutInflater)

        setContentView(binding.root)

        binding.mainScreenToolbar.title = EMPTY_STRING
        setSupportActionBar(binding.mainScreenToolbar)

        binding.userImageView.setOnClickListener {
            userImageViewClick()
        }

        binding.searchImageView.setOnClickListener {
            searchImageViewClick()
        }

        binding.favoriteImageView.setOnClickListener {
            favoriteImageViewClick()
        }

        binding.mainScreenMessageButton.setOnClickListener {
            chatMessageButtonClick()
        }

    }

    private fun userImageViewClick() {
        Toast.makeText(this, getString(R.string.user_image), Toast.LENGTH_SHORT).show()
    }

    private fun searchImageViewClick() {
        Toast.makeText(this, getString(R.string.search_image), Toast.LENGTH_SHORT).show()
    }

    private fun favoriteImageViewClick() {
        Toast.makeText(this, getString(R.string.favorite_image), Toast.LENGTH_SHORT).show()
    }

    private fun chatMessageButtonClick() {
        Toast.makeText(this, getString(R.string.chat_button), Toast.LENGTH_SHORT).show()
    }
}