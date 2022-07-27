package com.assist.imobilandroidapp.screens.client.screens.profileScreens.notifications

import android.app.Dialog
import android.os.Bundle
import androidx.fragment.app.Fragment
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import android.view.Window
import androidx.navigation.fragment.findNavController
import com.assist.imobilandroidapp.R
import com.assist.imobilandroidapp.databinding.FragmentNotificationsBinding
import kotlinx.android.synthetic.main.custom_dialog_notifications.*

class NotificationsFragment : Fragment() {

    private lateinit var binding : FragmentNotificationsBinding

    override fun onCreateView(
        inflater: LayoutInflater, container: ViewGroup?,
        savedInstanceState: Bundle?
    ): View {
        // Inflate the layout for this fragment
        binding = FragmentNotificationsBinding.inflate(inflater, container, false)

        binding.apply {
            profileHeader.tVOptionTitle.text = getString(R.string.notifications)
            profileHeader.iVBack.setOnClickListener {
                findNavController().navigate(R.id.action_notificationsFragment_to_clientProfileFragment)
            }

            tVNewsEdit.setOnClickListener {
                val dialog = Dialog(requireContext())
                dialog.apply {
                    requestWindowFeature(Window.FEATURE_NO_TITLE)
                    setCancelable(true)
                    setContentView(R.layout.custom_dialog_notifications)
                    iVDialogExit.setOnClickListener {
                        this.dismiss()
                    }
                    show()
                }
            }

            tvDiscountEdit.setOnClickListener {
                val dialog = Dialog(requireContext())
                dialog.apply {
                    requestWindowFeature(Window.FEATURE_NO_TITLE)
                    setCancelable(true)
                    setContentView(R.layout.custom_dialog_notifications)
                    tVDialogTitle.text = getString(R.string.discounts_promotions)
                    tVDialogDescription.text = getString(R.string.discount_description)
                    iVDialogExit.setOnClickListener {
                        this.dismiss()
                    }
                    show()
                }
            }
        }

        return binding.root
    }
}