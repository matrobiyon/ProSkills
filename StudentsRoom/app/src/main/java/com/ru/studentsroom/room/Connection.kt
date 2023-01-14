package com.ru.studentsroom.room

import androidx.room.Entity
import androidx.room.ForeignKey
import androidx.room.Index
import androidx.room.PrimaryKey

@Entity(tableName = "connection",
    foreignKeys = [ForeignKey(entity = Student::class,parentColumns = ["id"],childColumns = ["student_id"],onDelete = ForeignKey.CASCADE),
        ForeignKey(entity = Student::class,parentColumns = ["id"],childColumns = ["subject_id"],onDelete = ForeignKey.CASCADE),],
        indices = [Index(value = ["student_id","subject_id"], unique = true)]
)
data class Connection(
    @PrimaryKey(autoGenerate = true)
    val id : Int = 0,
    val student_id : Int,
    val subject_id : Int,
)