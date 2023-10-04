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

  suspend  fun update(note_title:String,text_main:String) {
      val updateNote = Notes(0,note_title, text_main)
      ndao.save(updateNote)

    }

  suspend  fun delete(note_title: String,text_main: String) {
      val deleteNote = Notes(0,note_title,text_main)
      ndao.delete(deleteNote)

    }

    suspend fun notesAdd() : List<Notes> = withContext(Dispatchers.IO) {

        return@withContext ndao.notesDownload()
    }

    suspend fun search(searchKeyword:String) : List<Notes> = withContext(Dispatchers.IO) {
        val nots = ArrayList<Notes>()

        val n1 = Notes(1,"Note Title","merhaba selam merhaba")
          val n2 = Notes(2,"Note Titleee","merhaba selam merhabaaaaaaa")

        nots.add(n1)
            nots.add(n2)

        return@withContext nots
    }

}