package com.barisgungorr.ui.fragment

import android.os.Bundle
import android.util.Log
import androidx.fragment.app.Fragment
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import android.widget.Toast
import androidx.fragment.app.viewModels
import androidx.navigation.Navigation
import androidx.navigation.fragment.navArgs
import com.barisgungorr.todoapplication.R
import com.barisgungorr.todoapplication.databinding.FragmentDetailsBinding
import com.barisgungorr.todoapplication.databinding.FragmentMainBinding
import com.barisgungorr.utils.transition
import com.barisgungorr.viewmodel.DetailsViewModel
import com.barisgungorr.viewmodel.MainViewModel
import dagger.hilt.android.AndroidEntryPoint

@AndroidEntryPoint
class DetailsFragment : Fragment() {
    private lateinit var binding: FragmentDetailsBinding
    private lateinit var viewModel: DetailsViewModel
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

            update(comeNote.nots_id,note_title, text_main)

            Toast.makeText(requireContext(),"Güncelleme Başarılı", Toast.LENGTH_LONG).show()

            val delayMillis = 1000
            it.postDelayed({
                Navigation.transition(it, R.id.detailsToMain)
            }, delayMillis.toLong())
        }

        return view
    }
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        val tempViewModel :DetailsViewModel by viewModels()
        viewModel = tempViewModel
    }

    fun update(nots_id:Int,note_title:String,text_main:String) {
        viewModel.update(nots_id,note_title, text_main)

    }
}