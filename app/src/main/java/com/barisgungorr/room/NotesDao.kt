package com.barisgungorr.room

import androidx.room.Dao
import androidx.room.Delete
import androidx.room.Insert
import androidx.room.Query
import androidx.room.Update
import com.barisgungorr.data.entity.Notes

@Dao

interface NotesDao {
    @Query("SELECT * FROM nots")
    suspend fun notesDownload() : List<Notes>

    @Insert
    suspend fun save (note:Notes)

    @Update
    suspend fun update (note:Notes)

    @Delete
    suspend fun delete (note:Notes)



}