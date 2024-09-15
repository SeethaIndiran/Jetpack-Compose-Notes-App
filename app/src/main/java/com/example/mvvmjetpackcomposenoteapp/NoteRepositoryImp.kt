package com.example.mvvmjetpackcomposenoteapp

import com.example.mvvmjetpackcomposenoteapp.model.Note
import com.example.mvvmjetpackcomposenoteapp.model.NoteDao
import com.example.mvvmjetpackcomposenoteapp.model.NoteRepository
import kotlinx.coroutines.flow.Flow

class NoteRepositoryImp(private  val noteDao: NoteDao):NoteRepository {
    override fun getNotes(): Flow<List<Note>> {
        return noteDao.getAllNotes()
    }

    override suspend fun getNoteById(id: Int): Note? {
        return noteDao.getNoteById(id)
    }

    override suspend fun insertNote(note: Note) {
       noteDao.insertNote(note)
    }

    override suspend fun deleteNote(note: Note) {
       noteDao.deleteNote(note)
    }
}