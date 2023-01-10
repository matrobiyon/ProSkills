package Week1.StudentTask

//Tasks which the App should do
class TaskForStudents(val spisok: List<Student>) {

    //Count Students of Faculty
    fun countStudentsOfFaculty(faculty : String){
        var counterTGMUorMGU = 0
        spisok.forEach{
            if (it.university == faculty.uppercase()) counterTGMUorMGU++
        }
        println(counterTGMUorMGU)
    }

    //Count Boys and Girls
    fun countBoyAndGirls(sex : Char){
        var counterBoyOrGirls = 0
        spisok.forEach{
            if (it.sex == sex) counterBoyOrGirls++
        }
        if (sex == 'F') println("Девушки: $counterBoyOrGirls") else if (sex == 'M') println(
            "Парни: $counterBoyOrGirls")
    }

    // Filters the students with stipendiya less than 400
    // Writes his(her) name in MapOf
    // && counts how many examination subjects does he(she) have
    fun filterWithStipendiya(){
        var nameAndExaminationCount = mutableMapOf<String,Int>()
        spisok.forEach {student ->
            if (student.stipendiya < 400)
                nameAndExaminationCount[student.name] = isExaminationCounter(student.listOfSubjects)
        }
        nameAndExaminationCount.forEach{
            println("Name ${it.key}\tExaminations: ${it.value}")
        }

    }
}
//Finds how many subjects are examination for One Student
fun isExaminationCounter(list: List<Subject>) : Int{
    var examinationCounter = 0
    list.forEach {
        if (it.isExamination == true) examinationCounter++
    }
    return examinationCounter
}