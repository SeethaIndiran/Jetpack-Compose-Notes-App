package com.example.mvvmjetpackcomposenoteapp

data class NoteTextFieldState (
    val text:String = "",
    val hint:String = "",
    val isHintVisible:Boolean = true
        )