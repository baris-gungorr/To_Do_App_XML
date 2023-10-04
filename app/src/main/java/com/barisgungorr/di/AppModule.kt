package com.barisgungorr.di

import android.content.Context
import androidx.room.Room
import com.barisgungorr.data.datasource.NotesDataSource
import com.barisgungorr.data.repo.NotesRepository
import com.barisgungorr.room.Database
import com.barisgungorr.room.NotesDao
import dagger.Module
import dagger.Provides
import dagger.hilt.InstallIn
import dagger.hilt.android.qualifiers.ApplicationContext
import dagger.hilt.components.SingletonComponent
import javax.inject.Singleton

@Module
@InstallIn(SingletonComponent::class)

class AppModule {
    @Provides
    @Singleton
    fun provideNotesRepository(nds: NotesDataSource) : NotesRepository {
        return NotesRepository(nds)
    }
@Provides
@Singleton
   fun provideNotesDataSource(ndao:NotesDao) : NotesDataSource {
       return NotesDataSource(ndao)
   }
    @Provides
    @Singleton
    fun provideNotesDao(@ApplicationContext context:Context) : NotesDao {
        val db = Room.databaseBuilder(context,Database::class.java,"nots.sqlite")
            .createFromAsset("nots.sqlite").build()

        return db.getNotesDao()
    }
}