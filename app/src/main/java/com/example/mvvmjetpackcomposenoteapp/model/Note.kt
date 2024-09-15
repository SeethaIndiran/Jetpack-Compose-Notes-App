package com.example.mvvmjetpackcomposenoteapp.model

import android.hardware.lights.LightState
import androidx.room.Entity
import androidx.room.PrimaryKey
import com.example.mvvmjetpackcomposenoteapp.NoteTextFieldState
import com.example.mvvmjetpackcomposenoteapp.ui.theme.*
import java.lang.Exception

@Entity
data class Note(
    val title:String,
    val content:String,
    val timeStamp:Long,
    val color: Int,
    @PrimaryKey val id:Int? = null
){

companion object {
    val noteColors = listOf(RedPink, RedOrange, BabyBlue, Violet, LightGreen)
}

}
class InvalidNoteException(message:String):Exception(message)