package com.barisgungorr.ui.fragment

import android.os.Bundle
import android.util.Log
import androidx.fragment.app.Fragment
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import androidx.navigation.fragment.navArgs
import com.barisgungorr.todoapplication.R
import com.barisgungorr.todoapplication.databinding.FragmentDetailsBinding
import com.barisgungorr.todoapplication.databinding.FragmentMainBinding


class DetailsFragment : Fragment() {
    private lateinit var binding: FragmentDetailsBinding
    override fun onCreateView(
        inflater: LayoutInflater, container: ViewGroup?,
        savedInstanceState: Bundle?
    ): View? {
        // Inflate the layout for this fragment
        binding = FragmentDetailsBinding.inflate(inflater, container, false)
        val view = binding.root

        val bundle: DetailsFragmentArgs by navArgs()

        val comeNote = bundle.note

        binding.textTitle.setText(comeNote.note_title)
            binding.textMain.setText(comeNote.text_main)

        binding.fabUpdate.setOnClickListener {
            val note_title = binding.textTitle.text.toString()
                val text_main = binding.textMain.text.toString()

            update(comeNote.note_title,text_main)

        }



        return view

    }

    fun update(note_title:String,text_main:String) {
        Log.e("Kişi Güncelle", "$note_title - $text_main")

    }

}