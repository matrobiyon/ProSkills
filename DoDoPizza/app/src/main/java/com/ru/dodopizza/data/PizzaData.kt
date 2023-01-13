package com.ru.dodopizza.data

data class PizzaData (
    val image : Int,
    val name : String,
    val about : String? = null,
    val price : Int,
    val category : String,
    val main : Boolean = false
        ) {
    fun formatPrice(): String {
        return "$price TJS"
    }
}