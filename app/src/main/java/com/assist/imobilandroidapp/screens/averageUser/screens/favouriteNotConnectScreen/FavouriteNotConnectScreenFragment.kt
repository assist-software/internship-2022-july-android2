package com.assist.imobilandroidapp.screens.averageUser.screens.favouriteNotConnectScreen

import android.content.Intent
import android.os.Bundle
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import android.widget.TextView
import androidx.fragment.app.Fragment
import androidx.navigation.fragment.findNavController
import com.assist.imobilandroidapp.R
import com.assist.imobilandroidapp.databinding.FragmentFavouriteNotConnectScreenBinding
import com.assist.imobilandroidapp.screens.login.Login

class FavouriteNotConnectScreenFragment : Fragment() {

    private lateinit var binding: FragmentFavouriteNotConnectScreenBinding

    override fun onCreateView(
        inflater: LayoutInflater, container: ViewGroup?,
        savedInstanceState: Bundle?
    ): View {
        // Inflate the layout for this fragment
        binding = FragmentFavouriteNotConnectScreenBinding.inflate(inflater, container, false)

        setText()

        binding.notConnectLoginMaterialButton.setOnClickListener {
            notConnectLoginButtonClick()
        }

        binding.notConnectHomeMaterialButton.setOnClickListener {
            notConnectHomeButtonClick()
        }

        return binding.root
    }

    private fun notConnectHomeButtonClick() {
        findNavController().navigate(R.id.normalScreenFragment)
    }

    private fun notConnectLoginButtonClick() {
        startActivity(Intent(context,Login::class.java))
    }

    private fun setText(){
        requireActivity().findViewById<TextView>(R.id.input_textView).text = getString(R.string.favourites)
    }
}