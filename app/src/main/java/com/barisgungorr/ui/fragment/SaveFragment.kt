package com.barisgungorr.ui.fragment

import android.os.Bundle
import androidx.fragment.app.Fragment
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import com.barisgungorr.todoapplication.R
import com.barisgungorr.todoapplication.databinding.FragmentSaveBinding


class SaveFragment : Fragment() {
    private lateinit var binding: FragmentSaveBinding
    override fun onCreateView(
        inflater: LayoutInflater, container: ViewGroup?,
        savedInstanceState: Bundle?
    ): View? {
        // Inflate the layout for this fragment
        return inflater.inflate(R.layout.fragment_save, container, false)
        binding.root
    }

}