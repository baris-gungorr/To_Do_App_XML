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
import androidx.navigation.Navigation
import androidx.recyclerview.widget.LinearLayoutManager
import androidx.recyclerview.widget.StaggeredGridLayoutManager
import com.barisgungorr.data.entity.Notes
import com.barisgungorr.todoapplication.R
import com.barisgungorr.todoapplication.databinding.FragmentMainBinding
import com.barisgungorr.ui.adapter.NotesAdapter


class MainFragment : Fragment() {
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

        val notesList = ArrayList<Notes> ()
            val n1 = Notes("Baslik 1", "bugün hava çok kapalı bugün hava çok kapalı bugün hava çok kapalı ")
        val n2 = Notes("Baslik 2", "bugün hava çok kapalı bugün hava çok kapalı bugün hava çok kapalı ")
            val n3 = Notes("Baslik 3", "bugün hava çok kapalı bugün hava çok kapalı bugün hava çok kapalı ")
        val n4 = Notes("Baslik 4", "Lorem Ipsum, dizgi ve baskı endüstrisinde kullanılan mıgır metinlerdir. Lorem Ipsum, adı bilinmeyen bir matbaacının bir hurufat numune kitabı oluşturmak üzere bir yazı galerisini alarak karıştırdığı 1500'lerden beri endüstri standardı sahte metinler olarak kullanılmıştır. Beşyüz yıl boyunca varlığını sürdürmekle kalmamış, aynı zamanda pek değişmeden elektronik dizgiye de sıçramıştır. 1960'larda Lorem Ipsum pasajları da içeren Letraset yapraklarının yayınlanması ile ve yakın zamanda Aldus PageMaker gibi Lorem Ipsum sürümleri içeren masaüstü yayıncılık yazılımları ile popüler olmuştur.")

        notesList.add(n1)
            notesList.add(n2)
        notesList.add(n3)
            notesList.add(n4)

        val notesAdapter = NotesAdapter(requireContext(),notesList)
        binding.rv.adapter = notesAdapter


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

    fun search(searchWord: String) {
        Log.e("Kişi Ara",searchWord)
    }

    override fun onResume() {
        super.onResume()
        Log.e("Kişi Anasayfa","Dönüldü")
    }
}