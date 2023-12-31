package com.barisgungorr.ui.fragment

import android.graphics.Color
import android.graphics.PorterDuff
import android.os.Bundle
import android.util.Log
import androidx.fragment.app.Fragment
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import android.widget.Toast
import androidx.core.content.ContextCompat
import androidx.fragment.app.viewModels
import androidx.navigation.Navigation
import com.barisgungorr.todoapplication.R
import com.barisgungorr.todoapplication.databinding.FragmentDetailsBinding
import com.barisgungorr.todoapplication.databinding.FragmentSaveBinding
import com.barisgungorr.utils.transition
import com.barisgungorr.viewmodel.DetailsViewModel
import com.barisgungorr.viewmodel.MainViewModel
import com.barisgungorr.viewmodel.SaveViewModel
import com.google.android.material.floatingactionbutton.FloatingActionButton
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
            Toast.makeText(requireContext(), "Kayıt Başarılı", Toast.LENGTH_LONG).show()

            val delayMillis = 1000
            it.postDelayed({
                Navigation.transition(it, R.id.saveToMain)
            }, delayMillis.toLong())
        }

        val fab = view.findViewById<FloatingActionButton>(R.id.fabSave)
        val drawable = ContextCompat.getDrawable(requireContext(), R.drawable.save_icon)
        drawable?.setColorFilter(Color.WHITE, PorterDuff.Mode.SRC_IN)
        fab.setImageDrawable(drawable)

        return view

    }

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        val tempViewModel: SaveViewModel by viewModels()
        viewModel = tempViewModel
    }

    private fun save(note_title: String, text_main: String) {
        viewModel.save(note_title, text_main)
    }

}