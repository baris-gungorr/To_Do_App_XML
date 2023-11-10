package com.barisgungorr.data.repo

import com.barisgungorr.data.datasource.NotesDataSource
import com.barisgungorr.data.entity.Notes

class NotesRepository(private var nDs : NotesDataSource) {

    suspend  fun save(note_title: String, text_main:String)  = nDs.save(note_title, text_main)

    suspend  fun update(nots_id:Int,note_title:String,text_main:String) = nDs.update(nots_id, note_title, text_main)

    suspend  fun delete(nots_id: Int) = nDs.delete(nots_id )

    suspend fun notesAdd() : List<Notes> = nDs.notesAdd()

    suspend fun search(searchKeyword:String) : List<Notes> = nDs.search(searchKeyword)


}
