package com.barisgungorr.ui.fragment

import android.os.Bundle
import android.util.Log
import androidx.fragment.app.Fragment
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import com.barisgungorr.todoapplication.R
import com.barisgungorr.todoapplication.databinding.FragmentDetailsBinding
import com.barisgungorr.todoapplication.databinding.FragmentSaveBinding


class SaveFragment : Fragment() {
    private lateinit var binding: FragmentSaveBinding
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

    fun save(note_title: String, text_main:String) {
        Log.e("Note kaydet","$note_title - $text_main")
    }

}