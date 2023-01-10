package Week1.StackTask

class Stack(){
    var list = mutableListOf<Any>()

    //Returns true if the list is Empty
    fun isEmpty() : Boolean{
        if (count() <= 0) return true
        return false
    }

    //Addes new object to Stack
    fun push(element : Any){
        list.add(element)
    }

    //Counts number of elements in Stack
    fun count() : Int{
        var countElemetsInStack = 0
        list.forEach {
            countElemetsInStack++
        }
        return countElemetsInStack
    }

    //Deletes the last object of Stack
    fun pop(){
        list.removeAt(count()-1)
    }

    //Shows the last object of Stack
    fun top(){
        println(list[count()-1])
    }
}