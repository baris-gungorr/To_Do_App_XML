package com.barisgungorr.viewmodel

import androidx.lifecycle.MutableLiveData
import androidx.lifecycle.ViewModel
import com.barisgungorr.data.entity.Notes
import com.barisgungorr.data.repo.NotesRepository
import dagger.hilt.android.lifecycle.HiltViewModel
import kotlinx.coroutines.CoroutineScope
import kotlinx.coroutines.Dispatchers
import kotlinx.coroutines.launch
import javax.inject.Inject

@HiltViewModel
class MainViewModel@Inject constructor(private var nRepo:NotesRepository) : ViewModel() {

    var notesList = MutableLiveData<List<Notes>>()

    init {
        notesAdd()
    }
    fun delete(nots_id:Int) {
        CoroutineScope(Dispatchers.Main).launch {
            nRepo.delete(nots_id)
            notesAdd()
        }
    }
    fun notesAdd() {
        CoroutineScope(Dispatchers.Main).launch {
            notesList.value = nRepo.notesAdd()
        }
    }

    fun search(searchKeyword: String) {
        CoroutineScope(Dispatchers.Main).launch {
            notesList.value = nRepo.search(searchKeyword)
        }
    }
}