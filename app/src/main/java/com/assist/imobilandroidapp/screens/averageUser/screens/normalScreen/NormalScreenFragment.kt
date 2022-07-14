package com.assist.imobilandroidapp.screens.averageUser.screens.normalScreen

import android.os.Bundle
import androidx.fragment.app.Fragment
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import android.widget.LinearLayout
import androidx.recyclerview.widget.LinearLayoutManager
import androidx.recyclerview.widget.RecyclerView
import com.assist.imobilandroidapp.R
import com.assist.imobilandroidapp.databinding.FragmentNormalScreenBinding
import com.assist.imobilandroidapp.screens.averageUser.screens.normalScreen.Classes.Adapters.ParentAdapter
import com.assist.imobilandroidapp.screens.averageUser.screens.normalScreen.Classes.ParentDataFactory
import kotlinx.android.synthetic.main.fragment_normal_screen.*

class NormalScreenFragment : Fragment() {

    private lateinit var binding: FragmentNormalScreenBinding

    override fun onCreateView(
        inflater: LayoutInflater, container: ViewGroup?,
        savedInstanceState: Bundle?
    ): View {
        // Inflate the layout for this fragment
        binding = FragmentNormalScreenBinding.inflate(inflater, container, false)

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

}