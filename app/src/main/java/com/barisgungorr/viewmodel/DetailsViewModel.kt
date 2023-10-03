package com.barisgungorr.viewmodel

import android.util.Log
import androidx.lifecycle.ViewModel
import com.barisgungorr.data.repo.NotesRepository
import kotlinx.coroutines.CoroutineScope
import kotlinx.coroutines.Dispatchers
import kotlinx.coroutines.launch

class DetailsViewModel: ViewModel() {
    var nrepo = NotesRepository()
     fun update(note_title:String,text_main:String) {
        CoroutineScope(Dispatchers.Main).launch {
            nrepo.update(note_title, text_main)
        }

    }

}