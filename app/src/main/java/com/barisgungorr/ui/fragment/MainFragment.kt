package com.barisgungorr.ui.fragment

import android.annotation.SuppressLint
import android.os.Bundle
import android.util.Log
import androidx.fragment.app.Fragment
import android.view.LayoutInflater
import android.view.MotionEvent
import android.view.View
import android.view.ViewGroup
import android.widget.SearchView.OnQueryTextListener
import androidx.fragment.app.viewModels
import androidx.navigation.Navigation
import androidx.recyclerview.widget.LinearLayoutManager
import androidx.recyclerview.widget.StaggeredGridLayoutManager
import com.barisgungorr.data.entity.Notes
import com.barisgungorr.todoapplication.R
import com.barisgungorr.todoapplication.databinding.FragmentMainBinding
import com.barisgungorr.ui.adapter.NotesAdapter
import com.barisgungorr.viewmodel.MainViewModel


class MainFragment : Fragment() {
    private lateinit var viewModel: MainViewModel
    private lateinit var binding: FragmentMainBinding

    @SuppressLint("ClickableViewAccessibility")
    override fun onCreateView(
        inflater: LayoutInflater, container: ViewGroup?,
        savedInstanceState: Bundle?
    ): View? {
        // Inflate the layout for this fragment
        binding = FragmentMainBinding.inflate(inflater, container, false)
        val view = binding.root

         binding.rv.layoutManager = LinearLayoutManager(requireContext())

      //binding.rv.layoutManager = StaggeredGridLayoutManager(2,StaggeredGridLayoutManager.VERTICAL)
        //binding.rv.layoutManager = StaggeredGridLayoutManager(2,StaggeredGridLayoutManager.HORIZONTAL)

        viewModel.notesList.observe(viewLifecycleOwner) {
            val notesAdapter = NotesAdapter(requireContext(),it,viewModel)
            binding.rv.adapter = notesAdapter
        }

        binding.fab.setOnClickListener {
            Navigation.findNavController(it).navigate(R.id.mainToSave)
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

                binding.searchView.isIconified = false
            }
            false
        }

        return view
    }
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        val tempViewModel :MainViewModel by viewModels()
        viewModel = tempViewModel
    }

    fun search(searchKeyword: String) {
        viewModel.search(searchKeyword)
    }

    override fun onResume() {
        super.onResume()
       viewModel.notesAdd()
    }
}