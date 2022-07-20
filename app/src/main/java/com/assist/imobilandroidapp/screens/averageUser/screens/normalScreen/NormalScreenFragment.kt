package com.assist.imobilandroidapp.screens.averageUser.screens.normalScreen

import android.os.Bundle
import androidx.fragment.app.Fragment
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import android.widget.LinearLayout
import android.widget.TextView
import androidx.navigation.fragment.findNavController
import androidx.recyclerview.widget.LinearLayoutManager
import com.assist.imobilandroidapp.R
import com.assist.imobilandroidapp.databinding.FragmentNormalScreenBinding
import com.assist.imobilandroidapp.screens.averageUser.screens.normalScreen.Classes.Adapters.ParentAdapter
import com.assist.imobilandroidapp.screens.averageUser.screens.normalScreen.Classes.ChildModel
import com.assist.imobilandroidapp.screens.averageUser.screens.normalScreen.Classes.Data.ChildDataFactory
import com.assist.imobilandroidapp.screens.averageUser.screens.normalScreen.Classes.Data.ParentDataFactory
import com.assist.imobilandroidapp.screens.averageUser.screens.normalScreen.Classes.Interfaces.ListingInterface

class NormalScreenFragment : Fragment() , ListingInterface {

    private lateinit var binding: FragmentNormalScreenBinding

    override fun onCreateView(
        inflater: LayoutInflater, container: ViewGroup?,
        savedInstanceState: Bundle?
    ): View {
        // Inflate the layout for this fragment
        binding = FragmentNormalScreenBinding.inflate(inflater, container, false)

        initRecycler()

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

        setVisibility()
    }

    private fun setVisibility() {
        requireActivity().findViewById<TextView>(R.id.input_textView).visibility = View.VISIBLE
        requireActivity().findViewById<TextView>(R.id.input_textView).text = getString(R.string.what_are_you_interested_in)
        requireActivity().findViewById<LinearLayout>(R.id.icons_view_linearLayout).visibility = View.GONE
        requireActivity().findViewById<LinearLayout>(R.id.filters_linearLayout).visibility = View.GONE
        requireActivity().findViewById<LinearLayout>(R.id.order_filters_linearLayout).visibility = View.GONE
    }

    override fun onCategoryClicked(category: String, categoryList: List<ChildModel>) {
        ChildDataFactory.category = category
        ChildDataFactory.addCategoryChildrens(categoryList)
        findNavController().navigate(R.id.categoryListScreenFragment)
    }

    override fun onItemClicked(childModel: ChildModel) {
        ChildDataFactory.addFavouriteChildren(childModel)
    }
}