package com.example.mvvmjetpackcomposenoteapp

import com.example.mvvmjetpackcomposenoteapp.model.Note
import com.example.mvvmjetpackcomposenoteapp.use_case.NoteOrder

sealed class NotesEvent {
    data class Order(val noteOrder: NoteOrder):NotesEvent()
    data class DeleteNote(val note: Note):NotesEvent()
    object RestoreNote:NotesEvent()
    object ToggleOrderSection:NotesEvent()
}