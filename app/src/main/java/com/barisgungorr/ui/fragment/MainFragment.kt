package com.barisgungorr.ui.fragment

import android.os.Bundle
import androidx.fragment.app.Fragment
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import androidx.navigation.Navigation
import com.barisgungorr.todoapplication.R
import com.barisgungorr.todoapplication.databinding.FragmentMainBinding


class MainFragment : Fragment() {
    private lateinit var binding: FragmentMainBinding

    override fun onCreateView(
        inflater: LayoutInflater, container: ViewGroup?,
        savedInstanceState: Bundle?
    ): View? {
        // Inflate the layout for this fragment
        return inflater.inflate(R.layout.fragment_main, container, false)

        binding.fab.setOnClickListener {
            Navigation.findNavController(it).navigate(R.id.mainToSave)
        }

        binding.buttonDetails.setOnClickListener {
            Navigation.findNavController(it).navigate(R.id.mainToDetails)
        }

        binding.root
    }

}