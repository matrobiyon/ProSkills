package Week1.StudentTask

import java.lang.RuntimeException

class Student(
    var name : String, var surname : String, var thirdName : String,
    var sex : Char,
    var university : String,
    var course : Int,
    var fakultet : String,
    var listOfSubjects : List<Subject>,
    var stipendiya : Int
){
    var vozrast : Int = 0 //Being initialized in secondary constructor

    //Print the Full name of Student
    fun fullName(){
        println("Name : $name")
        println("Surname : $surname")
        println("Third name : $thirdName")

    }

    //Random message
    fun talk() {
        pickRandomMessage()
    }

    //Full information about Student
    fun aboutMe() {
        println("Name: $name,Surname: $surname, Third name: $thirdName. Pol: $sex")
        println("Возраст: $vozrast лет")
        println("Учиться в: $university университете на $course - курсе в $fakultet- ом факултете")
        println("Предметы которые он(а) учить в универе:")
        listOfSubjects.forEach{
            println("\t${it.subjectName}")
        }
        println("Стипендия: $stipendiya")
    }

    //Secondary Costructor
    constructor(name : String,
                surname: String,
                thirdName: String,
                sex: Char,
                university: String,
                course: Int,
                fakultet: String,
                listOfSubjects: List<Subject>,
                stipendiya: Int,
                vozrast : Int
    ) : this(name,surname,thirdName,sex,university,course,fakultet, listOfSubjects,stipendiya) {
        if (vozrast < 0)
            throw RuntimeException("Vozrast is smaller than 0")
        this.vozrast = vozrast
    }
}
//Picks Random message and pass it to talk() method
fun pickRandomMessage() {
    var message1 = "Если Я соглашусь с тобой, мы оба будем неправы!"
    var message2 = "Ты всё еще в Илмхона?"
    var message3 = "А ты знаешь что Душанбе это столица Тджк?"
    var message4 = "У тебя сколько пальцев?"
    var message5 = "Как себя чувствуешь?"
    var message6 = "Чай с сахаром или без?"
    var message7 = "Ролтон или Суши?"
    var message8 = "Бачаако чистона биевен..."

    // Makes all of above messages to List, and picks One Randomly
    var randomMessage = mutableListOf<String>(message1,
        message2,message3,message4,message5,message6,message7,message8).random()
    println(randomMessage)
}
