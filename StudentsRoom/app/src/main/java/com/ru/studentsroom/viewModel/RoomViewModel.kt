package com.ru.studentsroom.viewModel

import androidx.lifecycle.ViewModel
import androidx.lifecycle.viewModelScope
import com.ru.studentsroom.room.ConnectionDao
import com.ru.studentsroom.room.StudentsDao
import com.ru.studentsroom.room.Subjects
import com.ru.studentsroom.room.SubjectsDao
import kotlinx.coroutines.launch

class RoomViewModel(private val studentDao : StudentsDao,
                    private val subjectDao: SubjectsDao,
                    private val connectionDao: ConnectionDao) : ViewModel() {
    fun addNewSubject(subject: String,isExamined : Boolean = false){

        val newSubject = Subjects(subjectName = subject, isExamination = isExamined)
        viewModelScope.launch {
            subjectDao.insert(newSubject)
        }
    }
}

