package com.assist.imobilandroidapp.screens.averageUser.screens.normalScreen

import android.content.Context
import android.os.Bundle
import androidx.fragment.app.Fragment
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import android.widget.LinearLayout
import android.widget.TextView
import androidx.constraintlayout.widget.ConstraintLayout
import androidx.fragment.app.FragmentContainerView
import androidx.navigation.findNavController
import androidx.navigation.fragment.findNavController
import androidx.recyclerview.widget.LinearLayoutManager
import com.assist.imobilandroidapp.R
import com.assist.imobilandroidapp.databinding.FragmentNormalScreenBinding
import com.assist.imobilandroidapp.screens.averageUser.screens.normalScreen.Classes.*
import com.assist.imobilandroidapp.screens.averageUser.screens.normalScreen.Classes.Adapters.ParentAdapter
import com.assist.imobilandroidapp.screens.averageUser.screens.normalScreen.Classes.Data.ChildDataFactory
import com.assist.imobilandroidapp.screens.averageUser.screens.normalScreen.Classes.Data.ParentDataFactory
import com.assist.imobilandroidapp.screens.averageUser.screens.normalScreen.Classes.Interfaces.ListingInterface
import kotlinx.android.synthetic.main.activity_main_screen.*

class NormalScreenFragment : Fragment() , ListingInterface {

    private lateinit var binding: FragmentNormalScreenBinding

    override fun onCreateView(
        inflater: LayoutInflater, container: ViewGroup?,
        savedInstanceState: Bundle?
    ): View {
        // Inflate the layout for this fragment
        binding = FragmentNormalScreenBinding.inflate(inflater, container, false)

        initFragment()

        return binding.root
    }

    private fun initRecycler(){
        binding.normalScreenRecycleView.apply {
            layoutManager = LinearLayoutManager(context,
                LinearLayout.VERTICAL, false)
            adapter = ParentAdapter(
                ParentDataFactory
                .getParents(10),this@NormalScreenFragment)
        }
    }

    override fun onCategoryClicked(category: String, categoryList: List<Listing>) {
        ChildDataFactory.category = category
        ChildDataFactory.addCategoryChildrens(categoryList)
        findNavController().navigate(R.id.categoryListScreenFragment)
    }

    override fun onItemClicked(childModel: Listing) {
        ChildDataFactory.addFavouriteChildren(childModel)
    }

    override fun onChildItemCLick(childModel: Listing) {
        DataSharing.init(requireContext().getSharedPreferences(SHARED_KEY, Context.MODE_PRIVATE))

        DataSharing.addItemImage(ITEM_IMAGE,childModel.image)
        DataSharing.addItemText(ITEM_TITLE,childModel.title)
        DataSharing.addItemText(ITEM_LOCATION,childModel.location)
        DataSharing.addItemText(ITEM_DESCRIPTION,childModel.description)
        DataSharing.addItemText(ITEM_PRICE,childModel.price)
        childModel.seller?.let { it1 ->
            DataSharing.addSellerImage(ITEM_SELLER_IMAGE,it1.image)
            DataSharing.addSellerInfo(ITEM_SELLER_NAME,it1.name)
            DataSharing.addSellerInfo(ITEM_SELLER_JOINED,it1.joined)
            DataSharing.addSellerInfo(ITEM_SELLER_RESPONSE_RATE,it1.responseRate)
            DataSharing.addSellerInfo(ITEM_SELLER_RESPONSE_TIME,it1.responseTime)
        }
        DataSharing.addItemImage(ITEM_SECOND_IMAGE,childModel.secondImage)
        DataSharing.addItemImage(ITEM_THIRD_IMAGE,childModel.thirdImage)

        DataSharing.commit()

        ChildDataFactory.childModel = childModel

        findNavController().navigate(R.id.detailsScreenFragment)
    }

    private fun initFragment() {
        requireActivity().apply {
            findViewById<ConstraintLayout>(R.id.clMainScreenFiltersTextIcons).visibility = View.VISIBLE
        }
        initRecycler()
    }
}