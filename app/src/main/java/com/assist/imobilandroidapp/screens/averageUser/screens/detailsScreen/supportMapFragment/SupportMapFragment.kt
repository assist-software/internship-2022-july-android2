package com.assist.imobilandroidapp.screens.averageUser.screens.detailsScreen.supportMapFragment

import android.os.Bundle
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import androidx.fragment.app.Fragment
import com.assist.imobilandroidapp.databinding.FragmentSupportMapBinding

class SupportMapFragment : Fragment() {

    private lateinit var binding: FragmentSupportMapBinding

    override fun onCreateView(
        inflater: LayoutInflater, container: ViewGroup?,
        savedInstanceState: Bundle?
    ): View {
        // Inflate the layout for this fragment
        binding = FragmentSupportMapBinding.inflate(inflater, container, false)

        return binding.root
    }
}