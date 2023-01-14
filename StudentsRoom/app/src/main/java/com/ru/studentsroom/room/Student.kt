package com.ru.studentsroom.room

import androidx.room.Entity
import androidx.room.PrimaryKey

@Entity(tableName = "student")
data class Student(
    @PrimaryKey(autoGenerate = true)
    val id : Int = 0,
    var name : String,
    var surname : String,
    var thirdName : String,
    var gender : String,
    var university : String,
    var course : Int,
    var fakultet : String,
    var stipendiya : Int,
    val age : Int?,
)
