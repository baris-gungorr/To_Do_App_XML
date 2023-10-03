package com.barisgungorr.viewmodel

import androidx.lifecycle.MutableLiveData
import androidx.lifecycle.ViewModel
import com.barisgungorr.data.entity.Notes
import com.barisgungorr.data.repo.NotesRepository
import kotlinx.coroutines.CoroutineScope
import kotlinx.coroutines.Dispatchers
import kotlinx.coroutines.launch

class MainViewModel : ViewModel() {

    var nrepo = NotesRepository()
    var notesList = MutableLiveData<List<Notes>>()

    init {
        notesAdd()
    }

    fun delete(note_title: String) {
        CoroutineScope(Dispatchers.Main).launch {
            nrepo.delete(note_title)
        }
    }

    fun notesAdd() {
        CoroutineScope(Dispatchers.Main).launch {
            notesList.value = nrepo.notesAdd()
        }
    }

    fun search(searchKeyword: String) {
        CoroutineScope(Dispatchers.Main).launch {
            notesList.value = nrepo.search(searchKeyword)
        }

    }
}