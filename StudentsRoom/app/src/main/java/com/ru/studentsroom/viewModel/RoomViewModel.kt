package com.ru.studentsroom.viewModel

import androidx.lifecycle.LiveData
import androidx.lifecycle.ViewModel
import androidx.lifecycle.asLiveData
import androidx.lifecycle.viewModelScope
import com.ru.studentsroom.room.*
import kotlinx.coroutines.launch
import kotlin.random.Random

class RoomViewModel(private val studentDao : StudentsDao,
                    private val subjectDao: SubjectsDao,
                    private val connectionDao: ConnectionDao) : ViewModel() {

    //Adding newStudent to Room
    fun addNewStudent(name: String,surname: String,otchestvo: String,vozrast:String,
                      university:String,course:String,fakultet:String,stipendita:String,gender:String) {

        //Adding new Student
        val newStudent = Student(name = name, surname = surname, thirdName = otchestvo,
            gender = gender, university = university.lowercase(),
        course = course.toInt(), fakultet = fakultet.lowercase(), stipendiya = stipendita.toInt(), age = vozrast.toInt())
        viewModelScope.launch {
            studentDao.insert(newStudent)
        }
    }


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

    //List of subjects
    var listOfSubject: LiveData<List<Subjects>> = subjectDao.getSubjects().asLiveData()

    //List of subjects via ID of student
    fun studentSubjects(studentId : Int) : LiveData<List<Subjects>> {
        return subjectDao.getSubjectWithId(studentId).asLiveData()
    }

    //List of students
    val listOfStudents : LiveData<List<Student>> = studentDao.getStudents().asLiveData()

    //Finding the last ID, via counting all items :)
    var findLastId : LiveData<Int> = studentDao.countId().asLiveData()
































    // ----------- NOT IMPORTANT --------------------------------------------//
    //----------- DATABASE WHEN STARTING APP --------------------------------//
    /// ----------- Never try to READ it :) -------------------------------- //

    fun filliing_students(){
        var counter = 1
        while (counter < 12) {
            //Adding new Student
            val newStudentM = Student(name =  "Ном", surname = "Насаб $counter", thirdName = "Кто-то",
                gender = "M", university = "IlmHona",
                course = 5, fakultet = "Android Developer".lowercase(), stipendiya = Random.nextInt(500), age = 22)

            viewModelScope.launch {
                studentDao.insert(newStudentM)
            }
            val amountOfSubjectsForM = Random.nextInt(4,12)
            for (subject in 1 .. amountOfSubjectsForM){
                viewModelScope.launch {
                    val newConnection = Connection(student_id = counter, subject_id = Random.nextInt(1,15))
                    connectionDao.insert(newConnection)
                }
            }
            counter++
            val newStudentJ = Student(name =  "Ном", surname = "Насаб $counter", thirdName = "Кто-то",
                gender = "J", university = "IlmHona",
                course = 5, fakultet = "Android Developer".lowercase(), stipendiya = Random.nextInt(500), age = 22)
            viewModelScope.launch {
                studentDao.insert(newStudentJ)
            }

            val amountOfSubjectsForJ = Random.nextInt(4,12)
            for (subject in 1 .. amountOfSubjectsForJ){
                viewModelScope.launch {
                    val newConnection = Connection(student_id = counter, subject_id = Random.nextInt(1,15))
                    connectionDao.insert(newConnection)
                }
            }
            counter++
        }
    }

    fun filling_subjects(){
        //Randomly adding some subjects
        addNewSubject("Soc gigiena")
        addNewSubject("Pediatriya",true)
        addNewSubject("Psixiatriya")
        addNewSubject("Khirurgiya")
        addNewSubject("Neonatologiya", true)
        addNewSubject("Kardiologiya", true)
        addNewSubject("NeuroPatology")
        addNewSubject("Математика")
        addNewSubject("Химия")
        addNewSubject("Физика",true)
        addNewSubject("Астрономия",true)
        addNewSubject("Информатика",true)
        addNewSubject("Питон")
        addNewSubject("Мат.анализ")
        addNewSubject("Android", true)
    }



    //------------------------------------------------------------------------//
    //------------------------------------------------------------------------//

}

