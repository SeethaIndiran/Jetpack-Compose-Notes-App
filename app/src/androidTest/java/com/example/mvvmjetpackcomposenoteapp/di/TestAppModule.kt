package com.example.mvvmjetpackcomposenoteapp.di

import android.app.Application
import androidx.room.Room
import com.example.mvvmjetpackcomposenoteapp.NoteRepositoryImp
import com.example.mvvmjetpackcomposenoteapp.model.NoteDatabase
import com.example.mvvmjetpackcomposenoteapp.model.NoteRepository
import com.example.mvvmjetpackcomposenoteapp.use_case.*
import dagger.Module
import dagger.Provides
import dagger.hilt.InstallIn
import dagger.hilt.components.SingletonComponent
import javax.inject.Singleton

@Module
@InstallIn(SingletonComponent::class)
object TestAppModule {
    @Provides
    @Singleton
    fun provideDatabase(app:Application):NoteDatabase{
        return Room.inMemoryDatabaseBuilder(app,NoteDatabase::class.java).build()
    }

    @Provides
    @Singleton
    fun provideNoteRepository(db:NoteDatabase):NoteRepository{
        return NoteRepositoryImp(db.noteDao)
    }

    @Provides
    @Singleton
    fun provideNoteUseCases(repository: NoteRepository):NoteUseCases{
        return NoteUseCases(getNotes = GetNotes(repository),
                          deleteNotes = DeleteNote(repository),
                             addNote = AddNote(repository),
                                 getNote = GetNote(repository))

    }
}