package com.assist.imobilandroidapp.screens.averageUser.screens.categoryListScreen

import android.content.Context
import android.content.res.ColorStateList
import android.os.Bundle
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import android.widget.LinearLayout
import android.widget.TextView
import androidx.core.widget.ImageViewCompat
import androidx.fragment.app.Fragment
import androidx.fragment.app.FragmentContainerView
import androidx.navigation.fragment.findNavController
import androidx.recyclerview.widget.LinearLayoutManager
import androidx.viewpager.widget.ViewPager
import com.assist.imobilandroidapp.R
import com.assist.imobilandroidapp.databinding.FragmentCategoryListScreenBinding
import com.assist.imobilandroidapp.screens.averageUser.screens.normalScreen.Classes.*
import com.assist.imobilandroidapp.screens.averageUser.screens.normalScreen.Classes.Adapters.CategoryParentAdapter
import com.assist.imobilandroidapp.screens.averageUser.screens.normalScreen.Classes.Adapters.ChildAdapter
import com.assist.imobilandroidapp.screens.averageUser.screens.normalScreen.Classes.Data.ChildDataFactory
import com.assist.imobilandroidapp.screens.averageUser.screens.normalScreen.Classes.Interfaces.ListingInterface
import com.google.android.material.tabs.TabLayout

class CategoryListScreenFragment : Fragment() , ListingInterface{

    private lateinit var binding: FragmentCategoryListScreenBinding
    private lateinit var searchView: androidx.appcompat.widget.SearchView
    private var categoryChildrens = ChildDataFactory.getCategoryChildrens() as MutableList<Listing>

    override fun onCreateView(
        inflater: LayoutInflater, container: ViewGroup?,
        savedInstanceState: Bundle?
    ): View {
        // Inflate the layout for this fragment
        binding = FragmentCategoryListScreenBinding.inflate(inflater, container, false)

        initRecycler()
        search()

        return binding.root
    }

    private fun setVisibility() {
        requireActivity().apply {
            findViewById<TextView>(R.id.client_input_textView).visibility = View.VISIBLE
            findViewById<TextView>(R.id.client_input_textView).text = ChildDataFactory.category
            findViewById<LinearLayout>(R.id.client_icons_view_linearLayout).visibility = View.VISIBLE
            ImageViewCompat.setImageTintList(this.findViewById(R.id.ic_list_view),ColorStateList.valueOf(requireContext().getColor(R.color.grayscale_700)))
            findViewById<LinearLayout>(R.id.client_filters_linearLayout).visibility = View.VISIBLE
            findViewById<LinearLayout>(R.id.client_order_filters_linearLayout).visibility = View.VISIBLE
            findViewById<ViewPager>(R.id.client_viewPager).visibility = View.GONE
            findViewById<FragmentContainerView>(R.id.client_mainScreenFragmentContainerView).visibility = View.VISIBLE
            findViewById<TabLayout>(R.id.client_tabLatyout).visibility = View.GONE
        }
    }

    private fun initRecycler(){
        binding.parentCategorySelectedRecyclerView.apply {
            layoutManager = LinearLayoutManager(context,LinearLayout.VERTICAL,false)
            adapter = CategoryParentAdapter(ChildDataFactory.getCategoryChildrens(),context,this@CategoryListScreenFragment)
        }
        setVisibility()
    }

    private fun search(){
        searchView = requireActivity().findViewById(R.id.search_searchView)
        searchView.setOnQueryTextListener(object : androidx.appcompat.widget.SearchView.OnQueryTextListener{
            override fun onQueryTextSubmit(p0: String?): Boolean {
                searchView.visibility = View.GONE
                categoryChildrens.clear()
                return false
            }

            override fun onQueryTextChange(p0: String?): Boolean {
                categoryChildrens = ChildDataFactory.getCategoryChildrens() as MutableList<Listing>
                for ( item in categoryChildrens ) {
                    if (item.title!!.contains(p0.toString())){
                        ChildDataFactory.addSearchChild(item)
                    }
                }
                binding.apply {
                    parentCategorySelectedRecyclerView.adapter = CategoryParentAdapter(ChildDataFactory.getCategoryChildrens(),context!!,this@CategoryListScreenFragment)
                    parentCategorySelectedRecyclerView.adapter?.notifyDataSetChanged()
                }
                return true
            }
        })
    }

    override fun onAddFavouriteIconClick(listing: Listing) {
        ChildDataFactory.addFavouriteChildren(listing)
    }

    override fun onChildItemCLick(listing: Listing) {
        DataSharing.init(requireContext().getSharedPreferences(SHARED_KEY, Context.MODE_PRIVATE))

        ChildDataFactory.listing = listing

        DataSharing.addItemText(ITEM_TITLE, listing.title.toString())
        DataSharing.addItemText(ITEM_LOCATION, listing.location.toString())
        DataSharing.addItemText(ITEM_DESCRIPTION, listing.description.toString())
        DataSharing.addItemText(ITEM_PRICE, listing.price.toString())
        listing.author?.let { it1 ->
            DataSharing.addSellerInfo(ITEM_SELLER_NAME, it1.fullName.toString())
        }

        DataSharing.commit()

        findNavController().navigate(R.id.detailsScreenFragment)
    }
}