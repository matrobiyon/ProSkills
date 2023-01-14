package com.ru.studentsroom.room

import androidx.room.*

@Dao
interface ConnectionDao {
    @Insert(onConflict = OnConflictStrategy.IGNORE)
    suspend fun insert(connection : Connection)
    @Update
    suspend fun update(connection: Connection)
    @Delete
    suspend fun delete(connection: Connection)
}