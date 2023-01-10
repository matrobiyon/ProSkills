package Week1.Aniamls

fun main(){
    //Instance of Dog
    val dog = Dog()

    //Instance of Cat
    val cat = Cat()

    //Instance of Horse
    val horse = Horse()

    // List of Animals
    var listOfAnimal = listOf<Animal>(
        dog,
        cat,
        horse)

    //Instance of Vetereniar
    var vetereniar = Vetereniar()

    //Order for veterinar
    for (item in listOfAnimal){
        vetereniar.treatAnimal(item)
        println()
    }

}

open class Animal {
    open var food: String = ""
    open var location: String = ""
    open var noise: String = ""

    fun sleep(){
        println("This animal is $location")
    }

    fun eat(){
        println("This animal eats $food")
    }

    open fun makeNoise(){
        println("$noise")
    }
}

class Dog : Animal() {
    override var food: String = "Meat"
    override var location: String = "Sleeping"

    //Just Dog's property
    fun barks() {
        println("The dog Barks!!!")
    }

    override fun makeNoise() {
        println("BArk Bark!!!")
    }

}
class Cat : Animal(){
    override var food: String = "mouse"
    override var noise: String = "Meow-moew!!"
    override var location: String = "not-sleeping"


    override fun makeNoise() {
        println("Meow-moew!!!")
    }

    //Just Cat property
    fun meow(){
        println("The dog Meows!!")
    }
}
class Horse : Animal(){
    override var food: String = "nothing"
    override var noise: String = "Don't know!!"
    override var location: String = "sleeping"


    override fun makeNoise() {
        println("No noise!!!")
    }

    //Just Horse property
    fun runs(){
        println("Horses run fast!!")
    }
}

class Vetereniar{
    fun treatAnimal(animal: Animal){
        println(animal.location)
        println(animal.food)
    }
}