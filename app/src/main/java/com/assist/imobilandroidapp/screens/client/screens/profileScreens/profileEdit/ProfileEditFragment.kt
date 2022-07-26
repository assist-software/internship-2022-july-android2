package com.assist.imobilandroidapp.screens.client.screens.profileScreens.profileEdit

import android.os.Bundle
import android.text.Editable
import androidx.fragment.app.Fragment
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import android.widget.Toast
import androidx.appcompat.app.AppCompatActivity
import androidx.navigation.fragment.findNavController
import com.assist.imobilandroidapp.R
import com.assist.imobilandroidapp.databinding.FragmentClientProfileBinding
import com.assist.imobilandroidapp.databinding.FragmentProfileEditBinding
import com.assist.imobilandroidapp.screens.api.`interface`.ApiInterface
import com.assist.imobilandroidapp.screens.api.calsses.RetrofitInstance
import com.assist.imobilandroidapp.screens.averageUser.screens.normalScreen.Classes.Author
import com.assist.imobilandroidapp.screens.averageUser.screens.normalScreen.Classes.AuthorChange
import com.assist.imobilandroidapp.screens.averageUser.screens.normalScreen.Classes.DataSharing
import com.assist.imobilandroidapp.screens.averageUser.screens.normalScreen.Classes.SHARED_KEY
import kotlinx.android.synthetic.main.fragment_profile_edit.view.*
import retrofit2.Call
import retrofit2.Callback
import retrofit2.Response

class ProfileEditFragment : Fragment() {

    private lateinit var binding: FragmentProfileEditBinding

    override fun onCreateView(
        inflater: LayoutInflater, container: ViewGroup?,
        savedInstanceState: Bundle?
    ): View {
        // Inflate the layout for this fragment
        binding = FragmentProfileEditBinding.inflate(inflater, container, false)

        val author = DataSharing.getUser()

        val retrofitInstance = RetrofitInstance.getRetrofitInstance().create(ApiInterface::class.java)

        DataSharing.init(requireContext().getSharedPreferences(SHARED_KEY,AppCompatActivity.MODE_PRIVATE))

        binding.apply {

            tVClientFullNameValue.text = author?.fullName
            tVClientGender.text = author?.gender.toString()
            tVClientDateOfBirth.text = author?.dateOfBirth
            tVClientEmailAddress.text = author?.email
            tVClientPhoneNumber.text = author?.phone
            tVClientAddress.text = author?.address

            tvFullNameEdit.setOnClickListener {
                when(tvFullNameEdit.text){
                    getString(R.string.edit) -> {
                        tvFullNameEdit.text = getString(R.string.cancel)
                        clientFullEditInput.root.visibility = View.VISIBLE
                        clientFullEditInput.tILClientFirstInput.editText?.setText(tVClientFullNameValue.text)
                        clientFullEditInput.tVFirstInput.text = tvFullName.text
                        clientFullEditInput.mBSaveChanges.setOnClickListener {
                            val newFullName = clientFullEditInput.tILClientFirstInput.editText?.text.toString()
                            retrofitInstance.changeUserName(author?.id!!,newFullName).enqueue(object : Callback<Author>{
                                override fun onResponse(
                                    call: Call<Author>,
                                    response: Response<Author>
                                ) {
                                    if ( response.isSuccessful){
                                        Toast.makeText(context, "Field updated", Toast.LENGTH_SHORT).show()
                                        val authorChange = response.body()
                                        DataSharing.saveUser(authorChange!!)
                                        DataSharing.commit()
                                    }
                                }

                                override fun onFailure(call: Call<Author>, t: Throwable) {
                                    Toast.makeText(context, "Failed to update", Toast.LENGTH_SHORT).show()
                            }

                            })
                        }
                    }
                    else -> {
                        tvFullNameEdit.text = getString(R.string.edit)
                        clientFullEditInput.root.visibility = View.GONE
                    }
                }
            }
            profileHeader.llIconOptionTitle.setOnClickListener {
                findNavController().navigate(R.id.action_profileEditFragment_to_clientProfileFragment)
            }

            tVEmailAddressEdit.setOnClickListener {
                when(tVEmailAddressEdit.text){
                    getString(R.string.edit) -> {
                        tVEmailAddressEdit.text = getString(R.string.cancel)
                        clientEmailEditInput.root.visibility = View.VISIBLE
                        clientEmailEditInput.tILClientFirstInput.editText?.setText(tVClientEmailAddress.text)
                        clientEmailEditInput.tVFirstInput.text = tvFullName.text
                        clientEmailEditInput.mBSaveChanges.setOnClickListener {
                            val newEmailAddress = clientEmailEditInput.tILClientFirstInput.editText?.text.toString()
                            retrofitInstance.changeEmail(author?.id!!,newEmailAddress).enqueue(object : Callback<Author>{
                                override fun onResponse(
                                    call: Call<Author>,
                                    response: Response<Author>
                                ) {
                                    if ( response.isSuccessful){
                                        Toast.makeText(context, "Field updated", Toast.LENGTH_SHORT).show()
                                        val authorChange = response.body()
                                        DataSharing.saveUser(authorChange!!)
                                        DataSharing.commit()
                                    }
                                }

                                override fun onFailure(call: Call<Author>, t: Throwable) {
                                    Toast.makeText(context, "Failed to update", Toast.LENGTH_SHORT).show()
                                }
                            })
                        }
                    }
                    else -> {
                        tVEmailAddressEdit.text = getString(R.string.edit)
                        clientEmailEditInput.root.visibility = View.GONE
                    }
                }
            }
        }

        return binding.root
    }
}