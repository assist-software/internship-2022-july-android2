package com.assist.imobilandroidapp.screens.averageUser.screens.detailsScreen

import android.os.Bundle
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import android.widget.TextView
import android.widget.Toast
import androidx.constraintlayout.widget.ConstraintLayout
import androidx.fragment.app.Fragment
import androidx.fragment.app.FragmentContainerView
import androidx.navigation.fragment.findNavController
import androidx.viewpager.widget.ViewPager
import com.assist.imobilandroidapp.R
import com.assist.imobilandroidapp.databinding.FragmentDetailsScreenBinding
import com.assist.imobilandroidapp.screens.averageUser.screens.normalScreen.Classes.Data.ChildDataFactory
import com.assist.imobilandroidapp.screens.averageUser.screens.normalScreen.Classes.DataSharing
import com.bumptech.glide.Glide
import kotlinx.android.synthetic.main.activity_client_main_screen.*

class DetailsScreenFragment : Fragment() {

    private lateinit var binding: FragmentDetailsScreenBinding
    private lateinit var textView: TextView

    override fun onCreateView(
        inflater: LayoutInflater, container: ViewGroup?,
        savedInstanceState: Bundle?
    ): View {
        // Inflate the layout for this fragment
        binding = FragmentDetailsScreenBinding.inflate(inflater, container, false)

        initFragment()

        binding.selectedItemPhotoGaleryImageButton.setOnClickListener {
            itemPhotoGalleryButtonClick(getString(R.string.gallery_button_click))
        }

        binding.selectedItemShareRelativeLayout.setOnClickListener {
            itemShareClick(getString(R.string.share_click))
        }

        binding.selectedItemDetailsPurchaseMaterialButton.setOnClickListener {
            itemPurchaseButtonClick(getString(R.string.purchase_click))
        }

        binding.itemDetailsFavouriteImageButton.setOnClickListener {
            itemFavouriteButtonClick(getString(R.string.favorite_image))
        }

        binding.selectedItemDetailsContactSellerMaterialButton.setOnClickListener {
            itemContactSellerButtonClick(getString(R.string.contact_seller_click))
        }

        return binding.root
    }

    private fun initFragment() {
        binding.apply {
            val author = DataSharing.getUser()
            val images : ArrayList<String>? = ChildDataFactory.listing.images
            Glide.with(requireContext()).load(images?.get(0)).into(selectedItemImageImageView)
            selectedItemTitleTextView.text = ChildDataFactory.listing.title
            selectedItemPriceTextView.text = ChildDataFactory.listing.price.toString()
            selectedItemLocationTextView.text = ChildDataFactory.listing.location.toString()
            selectedItemDescriptionTextView.text = ChildDataFactory.listing.description
            Glide.with(requireContext()).load(author?.photo).into(sellerProfileImageImageView)
            sellerNameTextView.text = author?.fullName
            sellerJoinedTextView.text = author?.createdAt
//            sellerResponseRateTextView.text = DataSharing.getItemSellerResponseRate()
//            sellerResponseTimeTextView.text = DataSharing.getItemSellerResponseTime()
        }

        requireActivity().apply {
            findViewById<ConstraintLayout>(R.id.clMainScreenFiltersTextIcons).visibility = View.GONE
            findViewById<ViewPager>(R.id.client_viewPager).visibility = View.GONE
            findViewById<FragmentContainerView>(R.id.client_mainScreenFragmentContainerView).visibility = View.VISIBLE
        }

    }

    override fun onDestroyView() {
        super.onDestroy()
        requireActivity().apply {
            findViewById<TextView>(R.id.client_input_textView).text = getString(R.string.login_message) + DataSharing.getUser()?.fullName
        }
    }

    private fun itemContactSellerButtonClick(string: String) {
        Toast.makeText(context, string, Toast.LENGTH_SHORT).show()
    }

    private fun itemFavouriteButtonClick(string: String) {
        Toast.makeText(context, string, Toast.LENGTH_SHORT).show()
    }

    private fun itemPurchaseButtonClick(string: String) {
        Toast.makeText(context, string, Toast.LENGTH_SHORT).show()
    }

    private fun itemShareClick(string: String) {
        Toast.makeText(context, string, Toast.LENGTH_SHORT).show()
    }

    private fun itemPhotoGalleryButtonClick(string: String) {
        Toast.makeText(context, string, Toast.LENGTH_SHORT).show()
        findNavController().navigate(R.id.photoGalleryFragment)
    }
}