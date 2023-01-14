package com.ru.studentsroom.viewModel

import androidx.lifecycle.ViewModel
import androidx.lifecycle.ViewModelProvider
import com.ru.studentsroom.room.ConnectionDao
import com.ru.studentsroom.room.StudentsDao
import com.ru.studentsroom.room.SubjectsDao

class RoomViewModelFactory(private val studentDao : StudentsDao,
                           private val subjectDao: SubjectsDao,
                           private val connectionDao: ConnectionDao
) : ViewModelProvider.Factory {
    override fun <T : ViewModel> create(modelClass: Class<T>): T {
        if (modelClass.isAssignableFrom(RoomViewModel::class.java)){
            @Suppress("UNCHECKED_CAST")
            return RoomViewModel(studentDao, subjectDao,connectionDao) as T
        }
        throw IllegalArgumentException("Unknown ViewModel Class")
    }
}