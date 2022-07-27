package com.assist.imobilandroidapp.screens.client.screens.profileScreens.loginAndSecurity

import android.os.Bundle
import androidx.fragment.app.Fragment
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import androidx.navigation.fragment.findNavController
import com.assist.imobilandroidapp.R
import com.assist.imobilandroidapp.databinding.FragmentLoginAndSecurityBinding

class LoginAndSecurityFragment : Fragment() {

    private lateinit var binding: FragmentLoginAndSecurityBinding

    override fun onCreateView(
        inflater: LayoutInflater, container: ViewGroup?,
        savedInstanceState: Bundle?
    ): View {
        // Inflate the layout for this fragment
        binding = FragmentLoginAndSecurityBinding.inflate(inflater, container, false)

        binding.apply {
            profileHeader.tVOptionTitle.text = getString(R.string.login_security)
            profileHeader.llIconOptionTitle.setOnClickListener {
                findNavController().navigate(R.id.action_loginAndSecurityFragment_to_clientProfileFragment)
            }
        }

        return binding.root
    }
}