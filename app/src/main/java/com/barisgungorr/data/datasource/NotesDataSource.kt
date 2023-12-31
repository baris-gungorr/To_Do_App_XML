package com.barisgungorr.data.datasource

import android.util.Log
import com.barisgungorr.data.entity.Notes
import com.barisgungorr.room.NotesDao
import kotlinx.coroutines.Dispatchers
import kotlinx.coroutines.withContext

class NotesDataSource (private var nDao: NotesDao) {
   suspend fun save(note_title: String, text_main:String) {
        val newNote = Notes(0,note_title, text_main)
        nDao.save(newNote)
    }


  suspend  fun update(nots_id:Int,note_title:String,text_main:String) {
      val updateNote = Notes(nots_id, note_title, text_main)
      nDao.update(updateNote)

    }

  suspend  fun delete(nots_id:Int) {
      val deleteNote = Notes(nots_id,"","")
      nDao.delete(deleteNote)

    }

    suspend fun notesAdd() : List<Notes> = withContext(Dispatchers.IO) {

        return@withContext nDao.notesDownload()
    }

    suspend fun search(searchKeyword:String) : List<Notes> = withContext(Dispatchers.IO) {

        return@withContext nDao.search(searchKeyword)
    }

}