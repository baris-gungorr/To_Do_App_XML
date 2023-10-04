package com.barisgungorr.ui.fragment

import android.os.Bundle
import android.util.Log
import androidx.fragment.app.Fragment
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import androidx.fragment.app.viewModels
import com.barisgungorr.todoapplication.R
import com.barisgungorr.todoapplication.databinding.FragmentDetailsBinding
import com.barisgungorr.todoapplication.databinding.FragmentSaveBinding
import com.barisgungorr.viewmodel.DetailsViewModel
import com.barisgungorr.viewmodel.MainViewModel
import com.barisgungorr.viewmodel.SaveViewModel
import dagger.hilt.android.AndroidEntryPoint

@AndroidEntryPoint
class SaveFragment : Fragment() {
    private lateinit var binding: FragmentSaveBinding
    private lateinit var viewModel: SaveViewModel
    override fun onCreateView(
        inflater: LayoutInflater, container: ViewGroup?,
        savedInstanceState: Bundle?
    ): View? {
        // Inflate the layout for this fragment
        binding = FragmentSaveBinding.inflate(inflater, container, false)
        val view = binding.root

        binding.fabSave.setOnClickListener {
            val note_title = binding.textTitle.text.toString()
                val text_main = binding.textMain.text.toString()

            save(note_title, text_main)
        }

        return view

    }
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        val tempViewModel : SaveViewModel by viewModels()
        viewModel = tempViewModel
    }

    fun save(note_title: String, text_main:String) {
        viewModel.save(note_title, text_main)
    }

}