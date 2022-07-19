package com.assist.imobilandroidapp.screens.averageUser.screens.favouriteScreen

import android.os.Bundle
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import android.widget.LinearLayout
import android.widget.TextView
import androidx.fragment.app.Fragment
import androidx.recyclerview.widget.LinearLayoutManager
import com.assist.imobilandroidapp.R
import com.assist.imobilandroidapp.databinding.FragmentFavouriteScreenBinding
import com.assist.imobilandroidapp.screens.averageUser.screens.normalScreen.Classes.Adapters.FavouriteChildAdapter
import com.assist.imobilandroidapp.screens.averageUser.screens.normalScreen.Classes.ChildModel
import com.assist.imobilandroidapp.screens.averageUser.screens.normalScreen.Classes.Data.ChildDataFactory
import com.assist.imobilandroidapp.screens.averageUser.screens.normalScreen.Classes.Interfaces.FavouriteInterface

class FavouriteScreenFragment : Fragment(), FavouriteInterface {

    private lateinit var binding: FragmentFavouriteScreenBinding
    private lateinit var favourites: TextView

    override fun onCreateView(
        inflater: LayoutInflater, container: ViewGroup?,
        savedInstanceState: Bundle?
    ): View {
        // Inflate the layout for this fragment
        binding = FragmentFavouriteScreenBinding.inflate(inflater, container, false)

        initFragment()

        return binding.root
    }

    private fun initFragment(){
        binding.messageFavouriteEmptyListTextView.visibility = if(ChildDataFactory.getFavouriteChildrens().isEmpty()){
            View.VISIBLE
        } else {
            View.GONE
        }
        initRecycler()
    }

    private fun initRecycler(){
        binding.favouritesItemsRecyclerView.apply {
            layoutManager = LinearLayoutManager(context,LinearLayout.VERTICAL,false)
            adapter = FavouriteChildAdapter(ChildDataFactory.getFavouriteChildrens(), this@FavouriteScreenFragment)
        }
        setText()
    }

    private fun setText(){
        favourites = requireActivity().findViewById(R.id.input_textView)
        favourites.text = getString(R.string.favourites)
        favourites.visibility = View.VISIBLE
    }

    override fun isListEmpty() {
        initFragment()
    }

    override fun removeItemFromFavourite(childModel: ChildModel) {
        ChildDataFactory.removeChildrenFromFavourite(childModel)
    }

    override fun onDestroyView() {
        super.onDestroyView()
        favourites.text = getString(R.string.what_are_you_interested_in)
    }
}