package com.barisgungorr.data.repo

import com.barisgungorr.data.datasource.NotesDataSource
import com.barisgungorr.data.entity.Notes

class NotesRepository {
    var nds = NotesDataSource()
  suspend  fun save(note_title: String, text_main:String)  = nds.save(note_title, text_main)

    suspend  fun update(note_title:String,text_main:String) = nds.update(note_title, text_main)

    suspend  fun delete(note_title: String) = nds.delete(note_title)

    suspend fun notesAdd() : List<Notes> = nds.notesAdd()

    suspend fun search(searchKeyword:String) : List<Notes> = nds.search(searchKeyword)


}
