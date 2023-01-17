package com.ru.studentsroom.room

import androidx.room.*
import kotlinx.coroutines.flow.Flow


@Dao
interface StudentsDao {
    @Insert(onConflict = OnConflictStrategy.IGNORE)
    suspend fun insert(student: Student)
    @Update
    suspend fun update(student: Student)
    @Delete
    suspend fun delete(student: Student)
    @Query("SELECT * FROM student WHERE id = :id")
    fun getStudent(id : Int) : Flow<Student>

    @Query("SELECT * FROM student")
    fun getStudents() : Flow<List<Student>>

    @Query("SELECT COUNT(id) FROM student")
    fun countId() : Flow<Int>
}