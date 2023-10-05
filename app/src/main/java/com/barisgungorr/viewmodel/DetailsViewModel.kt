package com.barisgungorr.viewmodel

import android.util.Log
import androidx.lifecycle.ViewModel
import com.barisgungorr.data.repo.NotesRepository
import dagger.hilt.android.lifecycle.HiltViewModel
import kotlinx.coroutines.CoroutineScope
import kotlinx.coroutines.Dispatchers
import kotlinx.coroutines.launch
import javax.inject.Inject

@HiltViewModel
class DetailsViewModel @Inject constructor(var nrepo:NotesRepository) : ViewModel() {

     fun update(nots_id: Int, note_title: String, text_main: String) {
        CoroutineScope(Dispatchers.Main).launch {
            nrepo.update(nots_id,note_title, text_main)
        }
    }
}