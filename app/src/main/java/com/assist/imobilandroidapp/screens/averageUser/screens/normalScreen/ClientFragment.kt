package com.assist.imobilandroidapp.screens.averageUser.screens.normalScreen

import android.content.Context
import android.os.Bundle
import android.util.Log
import androidx.fragment.app.Fragment
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import android.widget.ImageView
import android.widget.LinearLayout
import android.widget.TextView
import androidx.constraintlayout.widget.ConstraintLayout
import androidx.navigation.fragment.findNavController
import androidx.recyclerview.widget.LinearLayoutManager
import androidx.viewpager.widget.ViewPager
import com.assist.imobilandroidapp.R
import com.assist.imobilandroidapp.databinding.FragmentClientBinding
import com.assist.imobilandroidapp.databinding.FragmentNormalScreenBinding
import com.assist.imobilandroidapp.screens.api.`interface`.ApiInterface
import com.assist.imobilandroidapp.screens.api.calsses.RetrofitInstance
import com.assist.imobilandroidapp.screens.averageUser.screens.normalScreen.Classes.*
import com.assist.imobilandroidapp.screens.averageUser.screens.normalScreen.Classes.Adapters.ParentAdapter
import com.assist.imobilandroidapp.screens.averageUser.screens.normalScreen.Classes.Data.ChildDataFactory
import com.assist.imobilandroidapp.screens.averageUser.screens.normalScreen.Classes.Interfaces.ListingInterface
import com.bumptech.glide.Glide
import retrofit2.Call
import retrofit2.Callback
import retrofit2.Response

class ClientFragment : Fragment() , ListingInterface {

    private lateinit var binding: FragmentClientBinding


    override fun onCreateView(
        inflater: LayoutInflater, container: ViewGroup?,
        savedInstanceState: Bundle?
    ): View {
        // Inflate the layout for this fragment
        binding = FragmentClientBinding.inflate(inflater,container,false)

        initFragment()
        initRecycler()

        return binding.root
    }

    private fun initRecycler() {

        val retrofitInstance =
            RetrofitInstance.getRetrofitInstance().create(ApiInterface::class.java)

        val parents = mutableListOf<ParentModel>()

        retrofitInstance.getListing().enqueue(object : Callback<List<Listing>> {
            override fun onResponse(call: Call<List<Listing>>, response: Response<List<Listing>>) {
                if (response.isSuccessful) {
                    val listings = response.body()!! as MutableList
                    listings.forEach { listing ->
                        parents.firstOrNull {
                            it.category == listing.category
                        }?.children?.add(listing) ?: run {
                            parents.add(ParentModel(listing.category!!, mutableListOf(listing)))
                        }
                    }
                }

                binding.rVClientScreen.apply {
                    layoutManager = LinearLayoutManager(
                        context,
                        LinearLayout.VERTICAL, false
                    )
                    adapter = ParentAdapter(parents, this@ClientFragment)
                    adapter?.notifyDataSetChanged()
                }

            }

            override fun onFailure(call: Call<List<Listing>>, t: Throwable) {
                Log.e("ERRORLSITING", t.message.toString())
            }
        })
    }

    override fun onCategoryClicked(category: String, categoryList: List<Listing>) {
        ChildDataFactory.category = category
        ChildDataFactory.addCategoryChildrens(categoryList)
        findNavController().navigate(R.id.categoryListScreenFragment)
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
        requireActivity().apply {
            findViewById<ViewPager>(R.id.client_viewPager).visibility = View.GONE
        }
    }

    private fun initFragment() {
        requireActivity().apply {
            findViewById<ConstraintLayout>(R.id.clMainScreenFiltersTextIcons).visibility =
                View.VISIBLE
            findViewById<TextView>(R.id.client_input_textView).text = getString(R.string.login_message) + DataSharing.getUser()?.fullName
        }
    }
}