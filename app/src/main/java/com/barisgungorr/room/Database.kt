package com.barisgungorr.room

import androidx.room.Database
import androidx.room.RoomDatabase
import com.barisgungorr.data.entity.Notes

@Database(entities = [Notes::class], version = 1)
    abstract class Database : RoomDatabase() {
    abstract fun getNotesDao() : NotesDao


}