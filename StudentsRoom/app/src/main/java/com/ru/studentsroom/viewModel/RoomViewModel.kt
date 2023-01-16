package com.ru.studentsroom.viewModel

import androidx.lifecycle.LiveData
import androidx.lifecycle.ViewModel
import androidx.lifecycle.asLiveData
import androidx.lifecycle.viewModelScope
import com.ru.studentsroom.room.*
import kotlinx.coroutines.launch

class RoomViewModel(private val studentDao : StudentsDao,
                    private val subjectDao: SubjectsDao,
                    private val connectionDao: ConnectionDao) : ViewModel() {

    //Adding newStudent to Room
    fun addNewStudent(name: String,surname: String,otchestvo: String,vozrast:String,
                      university:String,course:String,fakultet:String,stipendita:String,gender:String) {

        //Adding new Student
        val newStudent = Student(name = name, surname = surname, thirdName = otchestvo, gender = gender, university = university,
        course = course.toInt(), fakultet = fakultet, stipendiya = stipendita.toInt(), age = vozrast.toInt())
        viewModelScope.launch {
            studentDao.insert(newStudent)
        }
    }

    var findLastId : LiveData<Int> = studentDao.countId().asLiveData()

    fun addNewConnection(student_id : Int, subjects: List<Subjects>){
        viewModelScope.launch {
            for (subject in subjects) {
                val newConnection = Connection(student_id = student_id, subject_id = subject.id)
                connectionDao.insert(newConnection)
            }
        }
    }

    //Adding New Subjects to Room
    fun addNewSubject(subject: String,isExamined : Boolean = false){

        val newSubject = Subjects(subjectName = subject, isExamination = isExamined)
        viewModelScope.launch {
            subjectDao.insert(newSubject)
        }
    }
    var listOfSubject: LiveData<List<Subjects>> = subjectDao.getSubjects().asLiveData()
}

