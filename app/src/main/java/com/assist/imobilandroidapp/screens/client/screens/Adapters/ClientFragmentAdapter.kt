package com.assist.imobilandroidapp.screens.client.screens.Adapters

import androidx.fragment.app.Fragment
import androidx.fragment.app.FragmentManager
import androidx.fragment.app.FragmentPagerAdapter
import com.assist.imobilandroidapp.screens.averageUser.screens.normalScreen.ClientFragment
import com.assist.imobilandroidapp.screens.client.screens.listingsScreen.ClientListingsFragment

class ClientFragmentAdapter(fragmentManager: FragmentManager) : FragmentPagerAdapter(fragmentManager) {
    override fun getCount(): Int {
        return 2
    }

    override fun getItem(position: Int): Fragment {
        return when(position){
            0 -> ClientFragment()
            1 -> ClientListingsFragment()
            else -> getItem(position)
        }
    }

}