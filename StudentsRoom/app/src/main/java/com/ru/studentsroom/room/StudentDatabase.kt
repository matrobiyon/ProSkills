package com.ru.studentsroom.room

import android.content.Context
import androidx.room.Database
import androidx.room.Room
import androidx.room.RoomDatabase

@Database(entities = [Student::class,Subjects::class,Connection::class], version = 1, exportSchema = false)
abstract class StudentDatabase : RoomDatabase() {

    abstract fun ConnectionDao() : ConnectionDao

    abstract fun StudentsDao() : StudentsDao

    abstract fun SubjectsDao() : SubjectsDao

    companion object {
        @Volatile
        private var INSTANCE : StudentDatabase? = null

        fun getData(context: Context) : StudentDatabase{
            return INSTANCE ?: synchronized(this){
                val instance = Room.databaseBuilder(
                    context.applicationContext,
                    StudentDatabase::class.java,
                    "student_database"
                ).fallbackToDestructiveMigration()
                    .build()

                INSTANCE = instance

                return instance
            }
        }
    }
}