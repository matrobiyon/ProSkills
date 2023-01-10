package Week1.StackTask

fun main(){
    // Instance if Stack
    var stack = Stack()

    //Adding to Stack
    stack.push("Hello")
    stack.push(3)
    stack.push('V')
    stack.push(true)

    //Count the elements
    println(stack.count())

    //See if it is Empty
    println(stack.isEmpty())

    //Deletes the last object
    stack.pop()

    //Shows the last object
    stack.top()
}