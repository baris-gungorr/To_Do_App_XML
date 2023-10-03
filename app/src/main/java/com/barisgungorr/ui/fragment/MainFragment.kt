package com.barisgungorr.ui.fragment

import android.os.Bundle
import android.util.Log
import androidx.fragment.app.Fragment
import android.view.LayoutInflater
import android.view.MotionEvent
import android.view.View
import android.view.ViewGroup
import android.widget.SearchView.OnQueryTextListener
import androidx.navigation.Navigation
import com.barisgungorr.data.entity.Notes
import com.barisgungorr.todoapplication.R
import com.barisgungorr.todoapplication.databinding.FragmentMainBinding


class MainFragment : Fragment() {
    private lateinit var binding: FragmentMainBinding

    override fun onCreateView(
        inflater: LayoutInflater, container: ViewGroup?,
        savedInstanceState: Bundle?
    ): View? {
        // Inflate the layout for this fragment
        binding = FragmentMainBinding.inflate(inflater, container, false)
        val view = binding.root


        binding.fab.setOnClickListener {
            Navigation.findNavController(it).navigate(R.id.mainToSave)
        }


        binding.buttonDetails.setOnClickListener {
            val note = Notes("baslik","notes")

            val go = MainFragmentDirections.mainToDetails(note = note)

            Navigation.findNavController(it).navigate(go)
        }

        binding.searchView.setOnQueryTextListener(object :OnQueryTextListener{

            override fun onQueryTextSubmit(query: String): Boolean {
               search(query)
                return false
            }
            override fun onQueryTextChange(newText: String): Boolean {
                search(newText)
                return true
            }
        })

        binding.searchView.setOnTouchListener { _, event ->
            if (event.action == MotionEvent.ACTION_DOWN) {
                // SearchView'e dokunulduğunda, metin düzenlemesi başlatılır
                binding.searchView.isIconified = false
            }
            false
        }




        return view
    }

    fun search(searchWord: String) {
        Log.e("Kişi Ara",searchWord)
    }
}