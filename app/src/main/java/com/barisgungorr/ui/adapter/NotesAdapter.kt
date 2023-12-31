package com.barisgungorr.ui.adapter

import android.content.Context
import android.util.Log
import android.view.LayoutInflater
import android.view.ViewGroup
import androidx.navigation.Navigation
import androidx.recyclerview.widget.RecyclerView
import com.barisgungorr.data.entity.Notes
import com.barisgungorr.todoapplication.databinding.CardDesignBinding
import com.barisgungorr.ui.fragment.MainFragmentDirections
import com.barisgungorr.utils.transition
import com.barisgungorr.viewmodel.MainViewModel
import com.google.android.material.snackbar.Snackbar

class NotesAdapter(
    private var mContext: Context,
    private var notesList: List<Notes>,
    private var viewModel: MainViewModel
) :
    RecyclerView.Adapter<NotesAdapter.CardDesignHolder>() {
    inner class CardDesignHolder(var design: CardDesignBinding) :
        RecyclerView.ViewHolder(design.root)

    override fun onCreateViewHolder(parent: ViewGroup, viewType: Int): CardDesignHolder {
        val binding = CardDesignBinding.inflate(LayoutInflater.from(mContext), parent, false)
        return CardDesignHolder(binding)
    }

    override fun onBindViewHolder(holder: CardDesignHolder, position: Int) {
        val note = notesList[position]
        val d = holder.design
        d.textViewTitle.text = note.note_title
        d.textViewInfo.text = note.text_main

        d.imageViewDelete.setOnClickListener {
            Snackbar.make(
                it,
                "${note.note_title} Silmek istediğinden emin misin ? ",
                Snackbar.LENGTH_LONG
            )
                .setAction("EVET") {
                    delete(note.nots_id)
                }.show()
        }
        d.CardViewLine.setOnClickListener {
            val show = MainFragmentDirections.mainToDetails(note = note)
            Navigation.transition(it, show)
        }
    }

    override fun getItemCount(): Int {
        return notesList.size
    }

    private fun delete(nots_id: Int) {
        viewModel.delete(nots_id)
    }
}