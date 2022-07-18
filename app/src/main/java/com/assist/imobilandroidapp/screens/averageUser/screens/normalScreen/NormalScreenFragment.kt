package com.assist.imobilandroidapp.screens.averageUser.screens.normalScreen

import android.os.Bundle
import androidx.fragment.app.Fragment
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import android.widget.LinearLayout
import android.widget.TextView
import androidx.recyclerview.widget.LinearLayoutManager
import com.assist.imobilandroidapp.R
import com.assist.imobilandroidapp.databinding.FragmentNormalScreenBinding
import com.assist.imobilandroidapp.screens.averageUser.screens.normalScreen.Classes.Adapters.ParentAdapter
import com.assist.imobilandroidapp.screens.averageUser.screens.normalScreen.Classes.Data.ParentDataFactory

class NormalScreenFragment : Fragment() {

    private lateinit var binding: FragmentNormalScreenBinding
    private lateinit var whatAreYouInterested : TextView

    override fun onCreateView(
        inflater: LayoutInflater, container: ViewGroup?,
        savedInstanceState: Bundle?
    ): View {
        // Inflate the layout for this fragment
        binding = FragmentNormalScreenBinding.inflate(inflater, container, false)

        whatAreYouInterested = requireActivity().findViewById(R.id.what_are_you_interested_textView)
        whatAreYouInterested.visibility = View.VISIBLE

        initRecycler()

        return binding.root
    }

    private fun initRecycler(){
        binding.normalScreenRecycleView.apply {
            layoutManager = LinearLayoutManager(context,
                LinearLayout.VERTICAL, false)
            adapter = ParentAdapter(
                ParentDataFactory
                .getParents(10))
        }
    }

    override fun onDestroyView() {
        super.onDestroyView()
        whatAreYouInterested.visibility = View.GONE
    }
}