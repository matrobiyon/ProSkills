package Week1.MyString

fun main(){
    // Instance of MyString
    var stringInstance = MyString("Qosim")

    //Reverse
    println(stringInstance.reverse())

    //Uppercase
    println(stringInstance.asUppercase())

    //Lowercase
    println(stringInstance.asLowercase())

    //Replace
println(stringInstance.myReplace("o", "ooooo"))
}

class MyString() {
    var string: String = ""

    constructor(_string: String) : this() {
        this.string = _string
    }

    //Print method
    fun printMyString() {
        println(string)
    }

    //Counts number of Characters in List
    fun count(): Int {
        var countItem = 0
        for (item in string)
            countItem++
        return countItem
    }

    // Reverse the string
    fun reverse(): String {
        var countItems = count() - 1
        var newReversedList = ""
        for (item in string) {
            newReversedList += string[countItems]
            countItems--
        }
        return newReversedList
    }

    //Replace method
    fun replace(subString: String, newSubString: String) {
        var newReplacedList = ""
        var index = 0
        while (index < string.count() - 1) {
            var temp = substring(index, subString.length)
            if (temp == subString) {
                newReplacedList += temp
                index += temp.length
            } else {
                index++
            }
        }
    }

    //SubString
    fun substring(start: Int = 0, end: Int): String {
        var subString = ""
        for (item in start until end) {
            subString += string[item]
        }
        return subString
    }

    //Uppercase String
    fun asUppercase(): String {
        var newUpperString = ""
        for (item in string) {
            if (item.code in 97..122)
                newUpperString += (item.code - 32).toChar()
            else newUpperString += item
        }
        return newUpperString
    }

    //Lowercase String
    fun asLowercase(): String {
        var newUpperString = ""
        for (item in string) {
            if (item.code in 65..90)
                newUpperString += (item.code + 32).toChar()
            else newUpperString += item
        }
        return newUpperString
    }

    fun myReplace(changeThis: String, toThis: String): String {
        var index = 0
        var newChangedString = ""
        while (index < string.length) {
            val checkThisString = substring(index, index+changeThis.length)
            if (changeThis == checkThisString) {
                newChangedString += toThis
                index += changeThis.length
            } else {
                newChangedString += string[index]
                index++
            }
        }
        return newChangedString
    }
}