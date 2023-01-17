package com.ru.studentsroom.room

import androidx.room.*
import kotlinx.coroutines.flow.Flow


@Dao
interface SubjectsDao {
    @Insert(onConflict = OnConflictStrategy.IGNORE)
    suspend fun insert(subjects: Subjects)
    @Update
    suspend fun update(subjects: Subjects)
    @Delete
    suspend fun delete(subjects: Subjects)

    @Query("SELECT * FROM subjects ORDER BY id")
    fun getSubjects() : Flow<List<Subjects>>

    //Drop unused columns loved it, good feature :)
    @RewriteQueriesToDropUnusedColumns
    @Query("SELECT * FROM subjects INNER JOIN connection WHERE connection.student_id = :student_id AND " +
            "connection.subject_id = subjects.id ")
    fun getSubjectWithId(student_id: Int) : Flow<List<Subjects>>
}