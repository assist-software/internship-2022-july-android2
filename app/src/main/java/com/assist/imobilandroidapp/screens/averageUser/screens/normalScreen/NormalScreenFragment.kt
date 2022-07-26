package com.assist.imobilandroidapp.screens.averageUser.screens.normalScreen

import android.content.Context
import android.os.Bundle
import android.util.Log
import androidx.fragment.app.Fragment
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import android.widget.LinearLayout
import androidx.constraintlayout.widget.ConstraintLayout
import androidx.navigation.fragment.findNavController
import androidx.recyclerview.widget.LinearLayoutManager
import androidx.viewpager.widget.ViewPager
import com.assist.imobilandroidapp.R
import com.assist.imobilandroidapp.databinding.FragmentNormalScreenBinding
import com.assist.imobilandroidapp.screens.api.`interface`.ApiInterface
import com.assist.imobilandroidapp.screens.api.calsses.BASE_URL
import com.assist.imobilandroidapp.screens.api.calsses.RetrofitInstance
import com.assist.imobilandroidapp.screens.averageUser.screens.normalScreen.Classes.*
import com.assist.imobilandroidapp.screens.averageUser.screens.normalScreen.Classes.Adapters.ParentAdapter
import com.assist.imobilandroidapp.screens.averageUser.screens.normalScreen.Classes.Data.ChildDataFactory
import com.assist.imobilandroidapp.screens.averageUser.screens.normalScreen.Classes.Interfaces.ListingInterface
import kotlinx.android.synthetic.main.fragment_normal_screen.*
import retrofit2.*

//class NormalScreenFragment : Fragment(), ListingInterface {
//
//    private lateinit var binding: FragmentNormalScreenBinding
//
//    override fun onCreateView(
//        inflater: LayoutInflater, container: ViewGroup?,
//        savedInstanceState: Bundle?
//    ): View {
//        // Inflate the layout for this fragment
//        binding = FragmentNormalScreenBinding.inflate(inflater, container, false)
//
////        initFragment()
////        initRecycler()
//
//        return binding.root
//    }
//
////    private fun initRecycler() {
////
////        val retrofitInstance =
////            RetrofitInstance.getRetrofitInstance().create(ApiInterface::class.java)
////
////        val parents = mutableListOf<ParentModel>()
////
////
////        retrofitInstance.getListing().enqueue(object : Callback<List<Listing>> {
////            override fun onResponse(call: Call<List<Listing>>, response: Response<List<Listing>>) {
////                if (response.isSuccessful) {
////                    val listings = response.body()!! as MutableList
////                    listings.forEach { listing ->
////                        parents.firstOrNull {
////                            it.category == listing.category
////                        }?.children?.add(listing) ?: run {
////                            parents.add(ParentModel(listing.category!!, mutableListOf(listing)))
////                        }
////                    }
////                }
////            }
////
////            override fun onFailure(call: Call<List<Listing>>, t: Throwable) {
////                Log.e("ERRORLSITING",t.message.toString())
////            }
////        })
////
////        val parentCopy = mutableListOf<ParentModel>()
////
////        parents.forEach{ parent ->
////            while ( parents.size != 5 ) {
////                parentCopy.add(parent)
////            }
////        }
////
////        binding.normalScreenRecycleView.apply {
////            layoutManager = LinearLayoutManager(
////                context,
////                LinearLayout.VERTICAL, false
////            )
////            adapter = ParentAdapter(parentCopy, this@NormalScreenFragment)
////            adapter?.notifyDataSetChanged()
////        }
////    }
//
////    override fun onCategoryClicked(category: String, categoryList: List<Listing>) {
////        ChildDataFactory.category = category
////        ChildDataFactory.addCategoryChildrens(categoryList)
////        findNavController().navigate(R.id.categoryListScreenFragment)
////    }
////
////    override fun onItemClicked(listing: Listing) {
////        ChildDataFactory.addFavouriteChildren(listing)
////    }
////
////    override fun onChildItemCLick(listing: Listing) {
////        DataSharing.init(requireContext().getSharedPreferences(SHARED_KEY, Context.MODE_PRIVATE))
////
////        DataSharing.addItemText(ITEM_TITLE, listing.title.toString())
////        DataSharing.addItemText(ITEM_LOCATION, listing.location.toString())
////        DataSharing.addItemText(ITEM_DESCRIPTION, listing.description.toString())
////        DataSharing.addItemText(ITEM_PRICE, listing.price.toString())
////        listing.author?.let { it1 ->
////            DataSharing.addSellerImage(ITEM_SELLER_IMAGE, it1.photo?.toInt()!!)
////            DataSharing.addSellerInfo(ITEM_SELLER_NAME, it1.fullName.toString())
////            DataSharing.addSellerInfo(ITEM_SELLER_JOINED, "")
////            DataSharing.addSellerInfo(ITEM_SELLER_RESPONSE_RATE, "")
////            DataSharing.addSellerInfo(ITEM_SELLER_RESPONSE_TIME, "")
////        }
////
////        DataSharing.commit()
////
////        findNavController().navigate(R.id.action_normalScreenFragment_to_detailsScreenFragment)
////        requireActivity().apply {
////            findViewById<ViewPager>(R.id.client_viewPager).visibility = View.GONE
////        }
////    }
////
////    private fun initFragment() {
////        requireActivity().apply {
////            findViewById<ConstraintLayout>(R.id.clMainScreenFiltersTextIcons).visibility =
////                View.VISIBLE
////        }
////    }
//}