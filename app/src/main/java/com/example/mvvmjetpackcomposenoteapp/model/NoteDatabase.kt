package com.example.mvvmjetpackcomposenoteapp.model

import androidx.room.Database
import androidx.room.RoomDatabase
@Database(
    entities = [Note::class],
    version = 1
)
abstract class NoteDatabase:RoomDatabase() {

    abstract val noteDao:NoteDao

    companion object{
        const val DATABASE_NAME  = "notes_db"
    }
}