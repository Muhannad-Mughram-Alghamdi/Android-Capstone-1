package com.example.todell.Database.Models

import androidx.room.Entity
import androidx.room.PrimaryKey

@Entity
data class ListsModel(
    val listName : String,
    @PrimaryKey(autoGenerate = true) // the primary key
    val id : Int = 0
)
