package com.assist.imobilandroidapp.screens.averageUser.screens.mainScreen

import android.os.Bundle
import android.widget.TextView
import android.widget.Toast
import androidx.appcompat.app.AppCompatActivity
import androidx.core.view.contains
import androidx.fragment.app.Fragment
import androidx.navigation.findNavController
import com.assist.imobilandroidapp.R
import com.assist.imobilandroidapp.screens.forgotPassword.EMPTY_STRING
import com.assist.imobilandroidapp.databinding.ActivityMainScreenBinding
import com.assist.imobilandroidapp.screens.averageUser.screens.normalScreen.NormalScreenFragment

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
        when (binding.userImageView.drawable.constantState) {
            resources.getDrawable(R.drawable.ic_user).constantState -> Toast.makeText(
                this,
                getString(R.string.user_image),
                Toast.LENGTH_SHORT
            ).show()
            resources.getDrawable(R.drawable.ic_exit).constantState -> findNavController(R.id.mainScreenFragmentContainerView).navigate(
                R.id.action_photoGalleryFragment_to_detailsScreenFragment
            )
        }
    }

    private fun searchImageViewClick() {
        when (binding.searchImageView.drawable.constantState) {
            resources.getDrawable(R.drawable.ic_search).constantState -> Toast.makeText(
                this,
                getString(R.string.search_image),
                Toast.LENGTH_SHORT
            ).show()
            resources.getDrawable(R.drawable.ic_share).constantState -> Toast.makeText(
                this,
                getString(R.string.share_click),
                Toast.LENGTH_SHORT
            ).show()
        }
    }

    private fun favoriteImageViewClick() {
        Toast.makeText(this, getString(R.string.favorite_image), Toast.LENGTH_SHORT).show()
//        findNavController(R.id.mainScreenFragmentContainerView).navigate(R.id.favouriteScreenFragment)
        findNavController(R.id.mainScreenFragmentContainerView).navigate(R.id.favouriteNotConnectScreenFragment)
    }

    private fun chatMessageButtonClick() {
        Toast.makeText(this, getString(R.string.chat_button), Toast.LENGTH_SHORT).show()
    }
}