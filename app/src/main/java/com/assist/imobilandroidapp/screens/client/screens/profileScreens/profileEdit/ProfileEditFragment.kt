package com.assist.imobilandroidapp.screens.client.screens.profileScreens.profileEdit

import android.os.Bundle
import androidx.fragment.app.Fragment
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import com.assist.imobilandroidapp.R
import com.assist.imobilandroidapp.databinding.FragmentClientProfileBinding
import com.assist.imobilandroidapp.databinding.FragmentProfileEditBinding

class ProfileEditFragment : Fragment() {

    private lateinit var binding: FragmentProfileEditBinding

    override fun onCreateView(
        inflater: LayoutInflater, container: ViewGroup?,
        savedInstanceState: Bundle?
    ): View {
        // Inflate the layout for this fragment
        binding = FragmentProfileEditBinding.inflate(inflater, container, false)

        return binding.root
    }

}