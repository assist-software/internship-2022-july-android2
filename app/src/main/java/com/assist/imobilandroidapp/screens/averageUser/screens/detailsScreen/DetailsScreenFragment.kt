package com.assist.imobilandroidapp.screens.averageUser.screens.detailsScreen

import android.content.Context
import android.content.SharedPreferences
import android.os.Bundle
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import android.widget.Toast
import androidx.fragment.app.Fragment
import androidx.navigation.fragment.findNavController
import com.assist.imobilandroidapp.R
import com.assist.imobilandroidapp.databinding.FragmentDetailsScreenBinding
import com.assist.imobilandroidapp.screens.averageUser.screens.normalScreen.Classes.DataSharing

class DetailsScreenFragment : Fragment() {

    private lateinit var binding: FragmentDetailsScreenBinding

    override fun onCreateView(
        inflater: LayoutInflater, container: ViewGroup?,
        savedInstanceState: Bundle?
    ): View {
        // Inflate the layout for this fragment
        binding = FragmentDetailsScreenBinding.inflate(inflater, container, false)

        initFragment()

        binding.selectedItemPhotoGaleryImageButton.setOnClickListener {
            itemPhotoGalleryButtonClick()
        }

        binding.selectedItemShareRelativeLayout.setOnClickListener {
            itemShareClick()
        }

        binding.selectedItemDetailsPurchaseMaterialButton.setOnClickListener {
            itemPurchaseButtonClick()
        }

        binding.itemDetailsFavouriteImageButton.setOnClickListener {
            itemFavouriteButtonClick()
        }

        binding.selectedItemDetailsContactSellerMaterialButton.setOnClickListener {
            itemContactSellerButtonClick()
        }

        return binding.root
    }

    private fun itemContactSellerButtonClick() {
        Toast.makeText(context, getString(R.string.contact_seller_click), Toast.LENGTH_SHORT).show()
    }

    private fun itemFavouriteButtonClick() {
        Toast.makeText(context, getString(R.string.child_favorit_button_add), Toast.LENGTH_SHORT)
            .show()
    }

    private fun itemPurchaseButtonClick() {
        Toast.makeText(context, getString(R.string.purchase_click), Toast.LENGTH_SHORT).show()
    }

    private fun itemShareClick() {
        Toast.makeText(context, getString(R.string.share_click), Toast.LENGTH_SHORT).show()
    }

    private fun itemPhotoGalleryButtonClick() {
        Toast.makeText(context, getString(R.string.gallery_button_click), Toast.LENGTH_SHORT).show()
        findNavController().navigate(R.id.action_detailsScreenFragment_to_photoGalleryFragment)
    }

    private fun initFragment() {
        binding.selectedItemImageImageView.setImageResource(DataSharing.getItemImage())
        binding.selectedItemTitleTextView.text = DataSharing.getItemTitle()
        binding.selectedItemPriceTextView.text = DataSharing.getItemPrice()
        binding.selectedItemLocationTextView.text = DataSharing.getItemLocation()
        binding.selectedItemDescriptionTextView.text = DataSharing.getItemDescription()
        binding.sellerProfileImageImageView.setImageResource(DataSharing.getItemSellerImage())
        binding.sellerNameTextView.text = DataSharing.getItemSellerName()
        binding.sellerJoinedTextView.text = DataSharing.getItemSellerJoined()
        binding.sellerResponseRateTextView.text = DataSharing.getItemSellerResponseRate()
        binding.sellerResponseTimeTextView.text = DataSharing.getItemSellerResponseTime()
    }

    override fun onDestroyView() {
        super.onDestroy()
    }
}