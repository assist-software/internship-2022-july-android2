package com.assist.imobilandroidapp.screens.client.screens.profileScreens.profileEdit

import android.os.Bundle
import android.text.Editable
import androidx.fragment.app.Fragment
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import androidx.navigation.fragment.findNavController
import com.assist.imobilandroidapp.R
import com.assist.imobilandroidapp.databinding.FragmentClientProfileBinding
import com.assist.imobilandroidapp.databinding.FragmentProfileEditBinding
import kotlinx.android.synthetic.main.fragment_profile_edit.view.*

class ProfileEditFragment : Fragment() {

    private lateinit var binding: FragmentProfileEditBinding

    override fun onCreateView(
        inflater: LayoutInflater, container: ViewGroup?,
        savedInstanceState: Bundle?
    ): View {
        // Inflate the layout for this fragment
        binding = FragmentProfileEditBinding.inflate(inflater, container, false)

        binding.apply {
            tvFullNameEdit.setOnClickListener {
                when(tvFullNameEdit.text){
                    getString(R.string.edit) -> {
                        tvFullNameEdit.text = getString(R.string.cancel)
                        lClientEditInputs.root.visibility = View.VISIBLE
                        lClientEditInputs.tILClientFirstInput.editText?.setText(tvFullName.text)
                        lClientEditInputs.tILClientSecondInput.editText?.setText(tvFullName.text)
                    }
                    else -> {
                        tvFullNameEdit.text = getString(R.string.edit)
                        lClientEditInputs.root.visibility = View.GONE
                    }
                }
            }
            profileHeader.llIconOptionTitle.setOnClickListener {
                findNavController().navigate(R.id.action_profileEditFragment_to_clientProfileFragment)
            }
        }

        return binding.root
    }

}