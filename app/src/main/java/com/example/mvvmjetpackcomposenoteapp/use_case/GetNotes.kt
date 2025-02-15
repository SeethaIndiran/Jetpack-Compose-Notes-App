package com.example.mvvmjetpackcomposenoteapp.use_case

import com.example.mvvmjetpackcomposenoteapp.model.Note
import com.example.mvvmjetpackcomposenoteapp.model.NoteRepository
import com.example.mvvmjetpackcomposenoteapp.util.OrderType
import kotlinx.coroutines.flow.Flow
import kotlinx.coroutines.flow.map

class GetNotes(private val repository: NoteRepository) {

    operator fun invoke(noteOrder: NoteOrder = NoteOrder.Date(OrderType.Descending)
    ): Flow<List<Note>> {
           return repository.getNotes().map { notes->
               when(noteOrder.orderType){
                   is OrderType.Ascending ->{

                when(noteOrder){
                   is NoteOrder.Title -> notes.sortedBy { it.title.lowercase() }
                   is NoteOrder.Date -> notes.sortedBy { it.timeStamp }
                   is NoteOrder.Color -> notes.sortedBy { it.color }
                }

                   }
                   is OrderType.Descending ->{
                       when(noteOrder){
                          is NoteOrder.Title -> notes.sortedByDescending { it.title.lowercase() }
                          is NoteOrder.Date -> notes.sortedByDescending { it.timeStamp }
                          is NoteOrder.Color -> notes.sortedByDescending { it.color }
                       }
                   }
               }
           }
    }
}