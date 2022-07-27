package com.assist.imobilandroidapp.screens.client.screens.listingsScreen

import android.os.Bundle
import androidx.fragment.app.Fragment
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import androidx.recyclerview.widget.LinearLayoutManager
import com.assist.imobilandroidapp.R
import com.assist.imobilandroidapp.databinding.FragmentClientListingsBinding
import com.assist.imobilandroidapp.screens.averageUser.screens.normalScreen.Classes.Adapters.ChildAdapter
import com.assist.imobilandroidapp.screens.averageUser.screens.normalScreen.Classes.Adapters.NewListingAdapter
import com.assist.imobilandroidapp.screens.averageUser.screens.normalScreen.Classes.Data.ChildDataFactory
import com.assist.imobilandroidapp.screens.averageUser.screens.normalScreen.Classes.Interfaces.ListingInterface
import com.assist.imobilandroidapp.screens.averageUser.screens.normalScreen.Classes.Listing

class ClientListingsFragment : Fragment() , ListingInterface {

    private lateinit var binding : FragmentClientListingsBinding

    override fun onCreateView(
        inflater: LayoutInflater, container: ViewGroup?,
        savedInstanceState: Bundle?
    ): View {
        // Inflate the layout for this fragment
        binding = FragmentClientListingsBinding.inflate(inflater, container, false)

        binding.clientListingsRV.apply {
            layoutManager = LinearLayoutManager(context,LinearLayoutManager.VERTICAL,false)
            adapter = NewListingAdapter(context,ChildDataFactory.getNewListings())
            adapter?.notifyDataSetChanged()
        }

        return binding.root
    }

    override fun onAddFavouriteIconClick(listing: Listing) {
    }

    override fun onChildItemCLick(listing: Listing) {
    }
}