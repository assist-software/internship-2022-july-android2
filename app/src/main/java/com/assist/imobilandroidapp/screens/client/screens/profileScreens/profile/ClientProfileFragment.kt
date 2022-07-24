package com.assist.imobilandroidapp.screens.client.screens.profileScreens.profile

import android.os.Bundle
import androidx.fragment.app.Fragment
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import android.widget.LinearLayout
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

        binding.apply {
            lLProfileOption.setOnClickListener {
                findNavController().navigate(R.id.action_clientProfileFragment_to_profileEditFragment)
            }

            lLLoginSecurityOption.setOnClickListener {
                findNavController().navigate(R.id.action_clientProfileFragment_to_loginAndSecurityFragment)
            }

        }
        return binding.root
    }
}