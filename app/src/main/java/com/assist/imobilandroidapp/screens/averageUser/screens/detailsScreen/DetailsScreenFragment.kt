package com.assist.imobilandroidapp.screens.averageUser.screens.detailsScreen

import android.os.Bundle
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import android.widget.TextView
import android.widget.Toast
import androidx.fragment.app.Fragment
import androidx.navigation.fragment.findNavController
import com.assist.imobilandroidapp.R
import com.assist.imobilandroidapp.databinding.FragmentDetailsScreenBinding
import com.assist.imobilandroidapp.screens.averageUser.screens.normalScreen.Classes.DataSharing
import com.assist.imobilandroidapp.screens.averageUser.screens.normalScreen.Classes.Interfaces.DetailsInterface

class DetailsScreenFragment : Fragment() , DetailsInterface {

    private lateinit var binding: FragmentDetailsScreenBinding
    private lateinit var textView : TextView

    override fun onCreateView(
        inflater: LayoutInflater, container: ViewGroup?,
        savedInstanceState: Bundle?
    ): View {
        // Inflate the layout for this fragment
        binding = FragmentDetailsScreenBinding.inflate(inflater, container, false)

        textView = requireActivity().findViewById(R.id.input_textView)
        textView.visibility = View.GONE

        initFragment()

        binding.selectedItemPhotoGaleryImageButton.setOnClickListener {
            itemPhotoGalleryButtonClick(it,getString(R.string.gallery_button_click))
        }

        binding.selectedItemShareRelativeLayout.setOnClickListener {
            itemShareClick(it,getString(R.string.share_click))
        }

        binding.selectedItemDetailsPurchaseMaterialButton.setOnClickListener {
            itemPurchaseButtonClick(it,getString(R.string.purchase_click))
        }

        binding.itemDetailsFavouriteImageButton.setOnClickListener {
            itemFavouriteButtonClick(it,getString(R.string.favorite_image))
        }

        binding.selectedItemDetailsContactSellerMaterialButton.setOnClickListener {
            itemContactSellerButtonClick(it,getString(R.string.contact_seller_click))
        }

        return binding.root
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

    override fun itemContactSellerButtonClick(view: View, string: String) {
        Toast.makeText(context, string, Toast.LENGTH_SHORT).show()
    }

    override fun itemFavouriteButtonClick(view: View, string: String) {
        Toast.makeText(context, string, Toast.LENGTH_SHORT).show()
    }

    override fun itemPurchaseButtonClick(view: View, string: String) {
        Toast.makeText(context, string, Toast.LENGTH_SHORT).show()
    }

    override fun itemShareClick(view: View, string: String) {
        Toast.makeText(context, string, Toast.LENGTH_SHORT).show()
    }

    override fun itemPhotoGalleryButtonClick(view: View, string: String) {
        Toast.makeText(context, string, Toast.LENGTH_SHORT).show()
        findNavController().navigate(R.id.action_detailsScreenFragment_to_photoGalleryFragment)
    }
}