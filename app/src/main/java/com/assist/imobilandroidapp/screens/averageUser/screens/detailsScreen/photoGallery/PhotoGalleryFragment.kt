package com.assist.imobilandroidapp.screens.averageUser.screens.detailsScreen.photoGallery

import android.os.Bundle
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import android.widget.ImageView
import android.widget.LinearLayout
import androidx.fragment.app.Fragment
import androidx.recyclerview.widget.LinearLayoutManager
import com.assist.imobilandroidapp.R
import com.assist.imobilandroidapp.databinding.FragmentPhotoGalleryBinding
import com.assist.imobilandroidapp.screens.averageUser.screens.normalScreen.Classes.Adapters.ChildPhotoGalleryAdapter

class PhotoGalleryFragment : Fragment() {

    private lateinit var binding: FragmentPhotoGalleryBinding
    private lateinit var exitToolbarImage : ImageView
    private lateinit var shareToolbarImage : ImageView

    override fun onCreateView(
        inflater: LayoutInflater, container: ViewGroup?,
        savedInstanceState: Bundle?
    ): View {
        // Inflate the layout for this fragment
        binding = FragmentPhotoGalleryBinding.inflate(inflater, container , false)

        initRecycler()

        return binding.root
    }

    private fun initRecycler() {
        exitToolbarImage = requireActivity().findViewById(R.id.user_imageView)
        shareToolbarImage = requireActivity().findViewById(R.id.search_imageView)

        exitToolbarImage.setImageResource(R.drawable.ic_exit)
        shareToolbarImage.setImageResource(R.drawable.ic_share)

        binding.photoGalleryRecyclerView.apply {
            layoutManager = LinearLayoutManager(context,LinearLayout.VERTICAL,false)
            adapter = ChildPhotoGalleryAdapter()
        }
    }

    override fun onDestroyView() {
        super.onDestroyView()
        exitToolbarImage.setImageResource(R.drawable.ic_user)
        shareToolbarImage.setImageResource(R.drawable.ic_search)
    }
}