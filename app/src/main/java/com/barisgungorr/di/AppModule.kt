package com.barisgungorr.di

import com.barisgungorr.data.datasource.NotesDataSource
import com.barisgungorr.data.repo.NotesRepository
import dagger.Module
import dagger.Provides
import dagger.hilt.InstallIn
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
   fun provideNotesDataSource() : NotesDataSource {
       return NotesDataSource()
   }

}