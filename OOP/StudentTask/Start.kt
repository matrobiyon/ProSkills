package Week1.StudentTask

fun main(){

    // List of Subjects that should be passed in Student Class for TGMU
    var listOfSubjectsForTGMU = pickSubjects("tgmu")

    // List of Subjects that should be passed in Student Class for MGU
    var listOfSubjectsForMGU = pickSubjects("mgu")

    //Instance of Student Class
    var student1 = Student("Qosim", "Matrobiyon","Saodatsho",
        'M',"TGMU", 5,"Mech-mat",listOfSubjectsForTGMU,230)
    var student2 = Student("Name2", "Surname2","thirdName2",
        'M',"MGU", 1,"Mech-mat",listOfSubjectsForMGU,230)
    var student3 = Student("Name3", "Surname3","thirdName3",
        'F',"TGMU", 2,"Tibbi",listOfSubjectsForTGMU,800,)
    var student4 = Student("Name4", "Surname4","thirdName4",
        'M',"MGU", 3,"Mech-mat",listOfSubjectsForMGU,600)
    var student5 = Student("Name5", "Surname5","thirdName5",
        'F',"TGMU", 5,"Mech-mat",listOfSubjectsForTGMU,500)

    // List of above Instance
    val listOfStudents = listOf<Student>(student1,student2,student3,student4,student5)

    // Instance of TaskForStudents
    var taskInstance = TaskForStudents(listOfStudents)

    //Prints the full name
    student1.fullName()
    println()

    //Sends randomly message
    student2.talk()
    println()

    //Information about student
    student3.aboutMe()
    println()

    //Count Students of Faculty
    taskInstance.countStudentsOfFaculty("tgmu")
    taskInstance.countStudentsOfFaculty("MGU")
    println()

    //Count Boys of Girls
    taskInstance.countBoyAndGirls('M')
    taskInstance.countBoyAndGirls('F')
    println()

    //Filter stipendiya
    taskInstance.filterWithStipendiya()


}

