package com.assist.imobilandroidapp.screens.client.screens.profileScreens.profile

import android.content.Intent
import android.os.Bundle
import android.util.Log
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import androidx.appcompat.app.AppCompatActivity
import androidx.fragment.app.Fragment
import androidx.navigation.fragment.findNavController
import com.assist.imobilandroidapp.R
import com.assist.imobilandroidapp.databinding.FragmentClientProfileBinding
import com.assist.imobilandroidapp.screens.averageUser.screens.normalScreen.Classes.DataSharing
import com.assist.imobilandroidapp.screens.averageUser.screens.normalScreen.Classes.SHARED_KEY
import com.assist.imobilandroidapp.screens.login.Login

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

            lLNotificationsOption.setOnClickListener {
                findNavController().navigate(R.id.action_clientProfileFragment_to_notificationsFragment)
            }

            mBClientProfileLogout.setOnClickListener {
                DataSharing.init(requireContext().getSharedPreferences(SHARED_KEY,AppCompatActivity.MODE_PRIVATE))
                DataSharing.clear()
                DataSharing.commit()
                Log.e("USERRR",DataSharing.getUser().toString())
                startActivity(Intent(requireContext(),Login::class.java))
                requireActivity().finish()
            }
        }
        return binding.root
    }
}