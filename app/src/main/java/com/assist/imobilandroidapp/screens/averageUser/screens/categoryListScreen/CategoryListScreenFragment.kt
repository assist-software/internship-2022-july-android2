package com.assist.imobilandroidapp.screens.averageUser.screens.categoryListScreen

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
import com.assist.imobilandroidapp.screens.averageUser.screens.normalScreen.Classes.Adapters.CategoryParentAdapter
import com.assist.imobilandroidapp.screens.averageUser.screens.normalScreen.Classes.ChildModel
import com.assist.imobilandroidapp.screens.averageUser.screens.normalScreen.Classes.Data.ChildDataFactory
import com.google.android.material.tabs.TabLayout

class CategoryListScreenFragment : Fragment(){

    private lateinit var binding: FragmentCategoryListScreenBinding
    private lateinit var searchView: androidx.appcompat.widget.SearchView
    private var categoryChildrens = ChildDataFactory.getCategoryChildrens() as MutableList<ChildModel>

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
            findViewById<TextView>(R.id.input_textView).visibility = View.VISIBLE
            findViewById<TextView>(R.id.input_textView).text = ChildDataFactory.category
            findViewById<LinearLayout>(R.id.icons_view_linearLayout).visibility = View.VISIBLE
            ImageViewCompat.setImageTintList(this.findViewById(R.id.ic_list_view),ColorStateList.valueOf(requireContext().getColor(R.color.grayscale_700)))
            findViewById<LinearLayout>(R.id.filters_linearLayout).visibility = View.VISIBLE
            findViewById<LinearLayout>(R.id.order_filters_linearLayout).visibility = View.VISIBLE
            findViewById<ViewPager>(R.id.client_viewPager).visibility = View.GONE
            findViewById<FragmentContainerView>(R.id.mainScreenFragmentContainerView).visibility = View.VISIBLE
            findViewById<TabLayout>(R.id.client_tabLatyout).visibility = View.GONE
        }
    }

    private fun initRecycler(){
        binding.parentCategorySelectedRecyclerView.apply {
            layoutManager = LinearLayoutManager(context,LinearLayout.VERTICAL,false)
            adapter = CategoryParentAdapter(ChildDataFactory.getCategoryChildrens())
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
                categoryChildrens = ChildDataFactory.getCategoryChildrens() as MutableList<ChildModel>
                for ( item in categoryChildrens ) {
                    if (item.title.contains(p0.toString())){
                        ChildDataFactory.addSearchChild(item)
                    }
                }
                binding.parentCategorySelectedRecyclerView.adapter = CategoryParentAdapter(ChildDataFactory.getSearchChildrens())
                return true
            }
        })
    }

    override fun onDestroyView() {
        super.onDestroyView()
        findNavController().navigate(R.id.action_categoryListScreenFragment_to_normalScreenFragment)
    }
}