package com.ru.studentsroom.room

import androidx.room.*

@Dao
interface StudentsDao {
    @Insert(onConflict = OnConflictStrategy.IGNORE)
    suspend fun insert(student: Student)
    @Update
    suspend fun update(student: Student)
    @Delete
    suspend fun delete(student: Student)
    @Query("SELECT * FROM student WHERE id = :id")
    fun getStudent(id : Int)

    @Query("SELECT COUNT(id) FROM student WHERE fakultet = :fakultet")
    fun getStudentsWithFakultet(fakultet : String)

    @Query("SELECT COUNT(id) FROM student WHERE gender = :gender")
    fun countGender(gender: String)

    @Query("SELECT * FROM student WHERE stipendiya < : stipendiya")
    fun stipendiyaLessThan(stipendiya : Int)


}