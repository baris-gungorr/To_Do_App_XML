package com.barisgungorr.viewmodel

import android.util.Log
import androidx.lifecycle.ViewModel
import com.barisgungorr.data.repo.NotesRepository
import kotlinx.coroutines.CoroutineScope
import kotlinx.coroutines.Dispatchers
import kotlinx.coroutines.launch

class SaveViewModel: ViewModel() {
    var nrepo = NotesRepository()
     fun save(note_title: String, text_main:String) {
        CoroutineScope(Dispatchers.Main).launch {
            nrepo.save(note_title, text_main)
        }
    }
}