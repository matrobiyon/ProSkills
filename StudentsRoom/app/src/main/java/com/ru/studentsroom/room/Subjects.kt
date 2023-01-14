package com.ru.studentsroom.room

import androidx.room.Entity
import androidx.room.PrimaryKey

@Entity(tableName = "subjects")
data class Subjects(
    @PrimaryKey(autoGenerate = true)
    val id : Int = 0,
    val subjectName: String,
    val isExamination : Boolean = false
)
