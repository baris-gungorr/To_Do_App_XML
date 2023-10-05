package com.barisgungorr.data.datasource

import android.util.Log
import com.barisgungorr.data.entity.Notes
import com.barisgungorr.room.NotesDao
import kotlinx.coroutines.Dispatchers
import kotlinx.coroutines.withContext

class NotesDataSource (var ndao: NotesDao) {
   suspend fun save(note_title: String, text_main:String) {
        val newNote = Notes(0,note_title, text_main)
        ndao.save(newNote)
    }

  suspend  fun update(nots_id:Int,note_title:String,text_main:String) {
      val updateNote = Notes(nots_id, note_title, text_main)
      ndao.update(updateNote)

    }

  suspend  fun delete(nots_id:Int) {
      val deleteNote = Notes(nots_id,"","")
      ndao.delete(deleteNote)

    }

    suspend fun notesAdd() : List<Notes> = withContext(Dispatchers.IO) {

        return@withContext ndao.notesDownload()
    }

    suspend fun search(searchKeyword:String) : List<Notes> = withContext(Dispatchers.IO) {

        return@withContext ndao.search(searchKeyword)
    }

}