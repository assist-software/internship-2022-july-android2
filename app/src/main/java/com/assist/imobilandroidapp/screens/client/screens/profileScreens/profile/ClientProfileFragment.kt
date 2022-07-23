package com.assist.imobilandroidapp.screens.client.screens.profileScreens.profile

import android.os.Bundle
import androidx.fragment.app.Fragment
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import androidx.navigation.fragment.findNavController
import com.assist.imobilandroidapp.R
import com.assist.imobilandroidapp.databinding.FragmentClientProfileBinding

class ClientProfileFragment : Fragment() {

    private lateinit var binding: FragmentClientProfileBinding

    override fun onCreateView(
        inflater: LayoutInflater, container: ViewGroup?,
        savedInstanceState: Bundle?
    ): View {
        // Inflate the layout for this fragment
        binding = FragmentClientProfileBinding.inflate(inflater, container, false)

        binding.lLProfileOption.setOnClickListener {
            findNavController().navigate(R.id.profileEditFragment)
        }

        return binding.root
    }

}