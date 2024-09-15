package com.example.mvvmjetpackcomposenoteapp.use_case

import com.example.mvvmjetpackcomposenoteapp.model.Note
import com.example.mvvmjetpackcomposenoteapp.model.NoteRepository

class GetNote(private val repository: NoteRepository) {

    suspend operator fun invoke(id:Int): Note?{
        return repository.getNoteById(id)
    }
}