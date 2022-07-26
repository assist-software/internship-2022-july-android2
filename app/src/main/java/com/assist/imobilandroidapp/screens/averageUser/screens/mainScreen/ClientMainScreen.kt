package com.assist.imobilandroidapp.screens.averageUser.screens.mainScreen

import android.os.Bundle
import android.view.View
import android.widget.Toast
import androidx.appcompat.app.AppCompatActivity
import androidx.appcompat.widget.SearchView
import androidx.navigation.findNavController
import com.assist.imobilandroidapp.R
import com.assist.imobilandroidapp.databinding.ActivityClientMainScreenBinding
import com.assist.imobilandroidapp.screens.averageUser.screens.normalScreen.Classes.DataSharing
import com.assist.imobilandroidapp.screens.averageUser.screens.normalScreen.Classes.SHARED_KEY
import com.assist.imobilandroidapp.screens.client.screens.Adapters.ClientFragmentAdapter
import com.assist.imobilandroidapp.screens.forgotPassword.EMPTY_STRING
import com.bumptech.glide.Glide
import com.google.android.material.tabs.TabLayout

class ClientMainScreen : AppCompatActivity() {

    private lateinit var binding: ActivityClientMainScreenBinding

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        binding = ActivityClientMainScreenBinding.inflate(layoutInflater)

        setContentView(binding.root)

        init()

        binding.clientMainScreenToolbar.title = EMPTY_STRING
        setSupportActionBar(binding.clientMainScreenToolbar)

        binding.clientImageView.setOnClickListener {
            userImageViewClick()
        }

        binding.clientSearchImageView.setOnClickListener {
            searchImageViewClick()
        }

        binding.clientFavoriteImageView.setOnClickListener {
            favoriteImageViewClick()
        }

        binding.mainScreenMessageButton.setOnClickListener {
            chatMessageButtonClick()
        }
    }

    private fun userImageViewClick() {
        when (binding.clientImageView.drawable.constantState) {
            resources.getDrawable(R.drawable.ic_user).constantState -> {
                findNavController(R.id.client_mainScreenFragmentContainerView).navigate(R.id.clientProfileFragment)
                binding.apply {
                    clMainScreenFiltersTextIcons.visibility = View.GONE
                    clientViewPager.visibility = View.GONE
                    clientMainScreenFragmentContainerView.visibility = View.VISIBLE
                    clientLLUsersButtons.visibility = View.GONE
                }
            }
            resources.getDrawable(R.drawable.ic_exit).constantState -> findNavController(R.id.client_mainScreenFragmentContainerView).navigate(
                R.id.action_photoGalleryFragment_to_detailsScreenFragment
            )
        }
    }

    private fun searchImageViewClick() {
        when (binding.clientSearchImageView.drawable.constantState) {
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
            clientMainScreenFragmentContainerView.visibility = View.VISIBLE
        }
        if (DataSharing.getUser()?.isActive == true) {
            findNavController(R.id.client_mainScreenFragmentContainerView).navigate(R.id.favouriteScreenFragment)
        }
    }

    private fun chatMessageButtonClick() {
        Toast.makeText(this, getString(R.string.chat_button), Toast.LENGTH_SHORT).show()
    }

    private fun init() {

        DataSharing.init(getSharedPreferences(SHARED_KEY, MODE_PRIVATE))

        val author = DataSharing.getUser()

        binding.apply {
            clientMainScreenFragmentContainerView.visibility = View.GONE
            clientMainScreenFragmentContainerView.isEnabled = false
            clientMainScreenFragmentContainerView.isActivated = false
            clientInputTextView.text = getString(R.string.login_message) + author?.fullName
//            Glide.with(applicationContext).load(author?.photo).into(clientImageView)
            clientViewPager.visibility = View.VISIBLE
            clientTabLatyout.visibility = View.VISIBLE
            clientLLUsersButtons.visibility = View.VISIBLE
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