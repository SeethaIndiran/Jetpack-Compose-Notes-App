package com.example.mvvmjetpackcomposenoteapp.use_case

import com.example.mvvmjetpackcomposenoteapp.model.Note
import com.example.mvvmjetpackcomposenoteapp.model.NoteRepository

class DeleteNote(private  val repository: NoteRepository) {

    suspend operator fun invoke(note: Note){
        repository.deleteNote(note)
    }
}