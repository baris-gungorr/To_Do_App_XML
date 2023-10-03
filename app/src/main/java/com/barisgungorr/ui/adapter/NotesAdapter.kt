package com.barisgungorr.ui.adapter

import android.content.Context
import android.view.LayoutInflater
import android.view.ViewGroup
import androidx.recyclerview.widget.RecyclerView
import com.barisgungorr.data.entity.Notes
import com.barisgungorr.todoapplication.databinding.CardDesignBinding

class NotesAdapter (var mContext : Context, var notesList : List<Notes>) :
    RecyclerView.Adapter<NotesAdapter.CardDesignHolder>() {
    inner class CardDesignHolder(var design: CardDesignBinding) : RecyclerView.ViewHolder(design.root)

    override fun onCreateViewHolder(parent: ViewGroup, viewType: Int): CardDesignHolder {
     val  binding = CardDesignBinding.inflate(LayoutInflater.from(mContext),parent,false)
        return CardDesignHolder(binding)
    }
    override fun onBindViewHolder(holder: CardDesignHolder, position: Int) {
        val note = notesList[position]
        val d = holder.design
        d.textViewTitle.text = note.note_title
        d.textViewInfo.text = note.text_main
    }

    override fun getItemCount(): Int {
      return  notesList.size
    }

}