package com.example.mvvmjetpackcomposenoteapp

import com.example.mvvmjetpackcomposenoteapp.model.Note
import com.example.mvvmjetpackcomposenoteapp.use_case.NoteOrder
import com.example.mvvmjetpackcomposenoteapp.util.OrderType

data class NoteState (
    val notes: List<Note> = emptyList(),
     val noteOrder:NoteOrder = NoteOrder.Date(OrderType.Descending),
      val isOrderSectionVisible:Boolean = false
    )