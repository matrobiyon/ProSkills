package Week1.Book

fun main(){
    //Objects of Book class
    var b1 = Book(2012,"Ktota1","Fantastika",true,false,9)
    var b2 = Book(2042,"Ktota2","Ujastik",true,true,4)
    var b3 = Book(2065,"Ktota3","Kamediya",false,false,19)
    var b4 = Book(2004,"Ktota4","romantika",true,false,18)
    var b5 = Book(2000,"Ktota5","Fantastika",true,true,29)

    //List of class Books
    var list = listOf<Book>(b1,b2,b3,b4,b5)

    //Reference to Week1.Book.Task Class
    var taskReference = Task(list)

    //Methods from Week1.Book.Task class
    taskReference.skolkoKnig(2030)
    taskReference.findAvtor("Fantastika")
    println(taskReference.findIfPereplyotSoft())
    taskReference.anotherFilter()

}

class Task(var spisok: List<Book>){
    fun skolkoKnig(year: Int){
        var count = 0
        for (i in spisok){
            if (i.godVipuska > year)
                count++
        }
        println(count)
    }
    fun findAvtor(janr:String){
        var spisokAvtorov = mutableListOf<String>()
        for (i in spisok){
            if (i.janr == janr)
                spisokAvtorov.add(i.avtor)
        }
        println(spisokAvtorov)
    }
    fun findIfPereplyotSoft(): Boolean{
        for (i in spisok){
            if (i.pereplyot)
                return true
        }
        return false
    }


//    fun filter(perevod: Int, let: Int) {
//        var spisokPerevodov = mutableListOf<Book>()
//        var spisokFiltrov = mutableMapOf<Book,Int>()
//
//        for (i in spisok) {
//            if (i.perevod && i.ogranichenie > let) {
//                spisokPerevodov.add(i)
//            }
//        }

    fun anotherFilter() {
        println(
            spisok.filter { book ->
                book.perevod && book.ogranichenie > 6
            }
        )
    }
}

class Book(var godVipuska: Int,
           var avtor: String,
           var janr: String,
           var pereplyot: Boolean,
           var perevod: Boolean,
           var ogranichenie: Int){

}