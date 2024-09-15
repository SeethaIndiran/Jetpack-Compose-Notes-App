package com.example.mvvmjetpackcomposenoteapp.use_case

import com.example.mvvmjetpackcomposenoteapp.model.InvalidNoteException
import com.example.mvvmjetpackcomposenoteapp.model.Note
import com.example.mvvmjetpackcomposenoteapp.model.NoteRepository

class AddNote(private val repository: NoteRepository) {
    @Throws(InvalidNoteException::class)
    suspend operator fun invoke(note: Note){
        if(note.title.isBlank()){
         throw InvalidNoteException("the title of note cannot be blank")
        }
        if(note.content.isBlank()){
            throw InvalidNoteException("the content of note cannot be blank")
        }


        repository.insertNote(note)
    }
}