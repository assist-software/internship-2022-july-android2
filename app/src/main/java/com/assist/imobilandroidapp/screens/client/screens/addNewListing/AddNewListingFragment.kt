package com.assist.imobilandroidapp.screens.client.screens.addNewListing

import android.os.Bundle
import androidx.fragment.app.Fragment
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import android.widget.ArrayAdapter
import android.widget.AutoCompleteTextView
import android.widget.Spinner
import android.widget.TimePicker
import androidx.constraintlayout.widget.ConstraintLayout
import androidx.navigation.fragment.findNavController
import com.assist.imobilandroidapp.R
import com.assist.imobilandroidapp.databinding.FragmentAddNewListingBinding
import com.assist.imobilandroidapp.screens.averageUser.screens.normalScreen.Classes.Data.ChildDataFactory
import com.assist.imobilandroidapp.screens.averageUser.screens.normalScreen.Classes.DataSharing
import com.assist.imobilandroidapp.screens.averageUser.screens.normalScreen.Classes.Listing
import okio.Timeout
import java.sql.Time
import java.util.*

class AddNewListingFragment : Fragment() {

    private lateinit var binding : FragmentAddNewListingBinding

    override fun onCreateView(
        inflater: LayoutInflater, container: ViewGroup?,
        savedInstanceState: Bundle?
    ): View {
        // Inflate the layout for this fragment
        binding = FragmentAddNewListingBinding.inflate(inflater, container, false)

        requireActivity().findViewById<ConstraintLayout>(R.id.clMainScreenFiltersTextIcons).visibility = View.GONE

        ArrayAdapter.createFromResource(
            requireContext(),
            R.array.categoryes,
            android.R.layout.simple_spinner_item
        ).also { adapter ->
            // Specify the layout to use when the list of choices appears
            adapter.setDropDownViewResource(android.R.layout.simple_spinner_dropdown_item)
            // Apply the adapter to the spinner
            binding.newListingCategory.adapter = adapter
        }

        binding.apply {
            newListingPreviewButton.setOnClickListener {
                val location = arrayListOf(newListingLocation.editText?.text.toString())
                val author = DataSharing.getUser()
                val listing = Listing(
                    "1newL1",
                    newListingTitle.editText?.text.toString(),
                    newListingDescription.editText?.text.toString(),
                    newListingDescription.editText?.text.toString(),
                    location,
                    newListingPrice.editText?.text.toString().toDouble(),
                    null,
                    null,
                    newListingCategory.selectedItem.toString(),
                    author,
                    0,
                    null,
                    Calendar.getInstance().time.toString(),
                    null
                )
                ChildDataFactory.newListing = listing
                findNavController().navigate(R.id.previewNewListingFragment)
            }
        }

        return binding.root
    }

}