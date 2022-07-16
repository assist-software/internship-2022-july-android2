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

class DetailsScreenFragment : Fragment() {

    private lateinit var binding: FragmentDetailsScreenBinding
    private lateinit var sharedPreferences : SharedPreferences
    private lateinit var editor : SharedPreferences.Editor

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
        Toast.makeText(context, getString(R.string.child_favorit_button_add), Toast.LENGTH_SHORT).show()
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

    private fun initFragment(){
        sharedPreferences = requireContext().getSharedPreferences("pref",Context.MODE_PRIVATE)

        sharedPreferences.let {
            binding.selectedItemImageImageView.setImageResource(it.getInt("image",-1))
            binding.selectedItemTitleTextView.text = it.getString("title",null)
            binding.selectedItemPriceTextView.text = it.getString("price",null)
            binding.selectedItemLocationTextView.text = it.getString("location", null)
            binding.selectedItemDescriptionTextView.text = it.getString("description",null)
            binding.sellerProfileImageImageView.setImageResource(it.getInt("sellerImage",-1))
            binding.sellerNameTextView.text = it.getString("sellerName",null)
            binding.sellerJoinedTextView.text = it.getString("sellerJoined",null)
            binding.sellerResponseRateTextView.text = it.getString("sellerResponseRate",null)
            binding.sellerResponseTimeTextView.text = it.getString("sellerResponseTime",null)
        }
    }

    override fun onDestroyView() {
        super.onDestroy()
        editor = sharedPreferences.edit()
//        editor.clear()
//        editor.commit()
    }
}