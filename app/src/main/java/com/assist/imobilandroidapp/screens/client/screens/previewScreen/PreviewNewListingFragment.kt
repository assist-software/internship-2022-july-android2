package com.assist.imobilandroidapp.screens.client.screens.previewScreen

import android.os.Bundle
import androidx.fragment.app.Fragment
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import com.assist.imobilandroidapp.R
import com.assist.imobilandroidapp.databinding.FragmentPreviewNewListingBinding
import com.assist.imobilandroidapp.screens.averageUser.screens.normalScreen.Classes.Data.ChildDataFactory

class PreviewNewListingFragment : Fragment() {

    private lateinit var binding : FragmentPreviewNewListingBinding

    override fun onCreateView(
        inflater: LayoutInflater, container: ViewGroup?,
        savedInstanceState: Bundle?
    ): View {
        // Inflate the layout for this fragment
        binding = FragmentPreviewNewListingBinding.inflate(inflater, container, false)

        binding.apply {
            newItemTitleTextView.text = ChildDataFactory.newListing.title
            newItemPriceTextView.text = ChildDataFactory.newListing.price.toString()
            newItemDescriptionTextView.text = ChildDataFactory.newListing.description
            newItemLocationTextView.text = ChildDataFactory.newListing.location.toString()
            newSellerNameTextView.text = ChildDataFactory.newListing.author?.fullName

            newListingPublishButton.setOnClickListener {
                ChildDataFactory.addNewListing(ChildDataFactory.newListing)
            }
        }
        return binding.root
    }

}