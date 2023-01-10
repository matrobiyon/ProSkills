package Week1.StudentTask

// Class for ONE subject
class Subject(
    val subjectName: String,
    val isExamination : Boolean = false
)

//pick Subjects for one University
fun pickSubjects(nameOfUniversity: String): List<Subject>{
    val listOfSubjects = mutableListOf<Subject>()
    if (nameOfUniversity.uppercase() == "TGMU") {
        listOfSubjects.add(Subject("Soc gigiena"))
        listOfSubjects.add(Subject("Pediatriya"))
        listOfSubjects.add(Subject("Psixiatriya",true))
        listOfSubjects.add(Subject("Khirurgiya"))
        listOfSubjects.add(Subject("Neonatologiya",true))
        listOfSubjects.add(Subject("Kardiologiya",true))
        listOfSubjects.add(Subject("NeuroPatology"))
    }else if (nameOfUniversity.uppercase() == "MGU"){
        listOfSubjects.add(Subject("Математика"))
        listOfSubjects.add(Subject("Химия"))
        listOfSubjects.add(Subject("Физика",true))
        listOfSubjects.add(Subject("Мат.анализ"))
        listOfSubjects.add(Subject("Астрономия",true))
        listOfSubjects.add(Subject("Информатика",true))
        listOfSubjects.add(Subject("Питон"))
    }
    return listOfSubjects
}
