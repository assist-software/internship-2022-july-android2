package com.assist.imobilandroidapp.screens.averageUser.screens.mainScreen

import android.os.Bundle
import android.view.View
import android.widget.TextView
import android.widget.Toast
import androidx.appcompat.app.AppCompatActivity
import androidx.appcompat.widget.SearchView
import androidx.navigation.findNavController
import com.assist.imobilandroidapp.R
import com.assist.imobilandroidapp.databinding.ActivityMainScreenBinding
import com.assist.imobilandroidapp.screens.averageUser.screens.normalScreen.Classes.DataSharing
import com.assist.imobilandroidapp.screens.averageUser.screens.normalScreen.Classes.SHARED_KEY
import com.assist.imobilandroidapp.screens.averageUser.screens.normalScreen.NormalScreenFragment
import com.assist.imobilandroidapp.screens.client.screens.Adapters.ClientFragmentAdapter
import com.assist.imobilandroidapp.screens.forgotPassword.EMPTY_STRING
import com.google.android.material.tabs.TabLayout
import com.google.android.material.tabs.TabLayoutMediator

val userResponse = DataSharing.getUser()

class MainScreen : AppCompatActivity() {

    private lateinit var binding: ActivityMainScreenBinding

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        binding = ActivityMainScreenBinding.inflate(layoutInflater)

        setContentView(binding.root)

        init()

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
            resources.getDrawable(R.drawable.ic_search).constantState -> {
                Toast.makeText(
                    this,
                    getString(R.string.search_image),
                    Toast.LENGTH_SHORT
                ).show()
                requireViewById<SearchView>(R.id.search_searchView).visibility = View.VISIBLE
            }
            resources.getDrawable(R.drawable.ic_share).constantState -> {
                Toast.makeText(
                    this,
                    getString(R.string.share_click),
                    Toast.LENGTH_SHORT
                ).show()
            }
        }
    }

    private fun favoriteImageViewClick() {
        Toast.makeText(this, getString(R.string.favorite_image), Toast.LENGTH_SHORT).show()
        binding.apply {
            clientViewPager.visibility = View.GONE
            clientTabLatyout.visibility = View.GONE
            mainScreenFragmentContainerView.visibility = View.VISIBLE
        }
        if (userResponse?.isActive == true) {
            findNavController(R.id.mainScreenFragmentContainerView).navigate(R.id.favouriteScreenFragment)
        } else {
            findNavController(R.id.mainScreenFragmentContainerView).navigate(R.id.favouriteNotConnectScreenFragment)
        }
    }

    private fun chatMessageButtonClick() {
        Toast.makeText(this, getString(R.string.chat_button), Toast.LENGTH_SHORT).show()
    }

    private fun init() {

        binding.apply {
            mainScreenFragmentContainerView.visibility = View.GONE
            inputTextView.text = getString(R.string.login_message) + userResponse?.fullName
            clientViewPager.visibility = View.VISIBLE
            clientTabLatyout.visibility = View.VISIBLE
            clientTabLatyout.addTab(binding.clientTabLatyout.newTab().setText("All listings"))
            clientTabLatyout.addTab(binding.clientTabLatyout.newTab().setText("My listings"))
            clientViewPager.adapter = ClientFragmentAdapter(supportFragmentManager)
            clientViewPager.addOnPageChangeListener(TabLayout.TabLayoutOnPageChangeListener(this.clientTabLatyout))
            clientTabLatyout.addOnTabSelectedListener(object : TabLayout.OnTabSelectedListener{
                override fun onTabSelected(tab: TabLayout.Tab?) {
                    clientViewPager.currentItem = tab!!.position
                }

                override fun onTabUnselected(tab: TabLayout.Tab?) {
                }
                override fun onTabReselected(tab: TabLayout.Tab?) {
                }
            })
        }
    }
}