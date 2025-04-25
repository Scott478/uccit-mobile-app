package com.trevor_nelson.uccitmobileapp.data

import androidx.room.Entity
import androidx.room.PrimaryKey

@Entity(tableName = "courses")
data class Course(
    @PrimaryKey(autoGenerate = true) val id: Int = 0,
    val code: String,
    val title: String,
    val credits: Int,
    val prerequisites: String,
    val description: String
)