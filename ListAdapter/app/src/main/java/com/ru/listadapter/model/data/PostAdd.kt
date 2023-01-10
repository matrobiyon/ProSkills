package com.ru.listadapter.model.data

import com.ru.listadapter.R

data class PostAdd(
    val id : Int,
    val user : User,
    val imageAdd: Int = R.drawable.welcome,
    var likes : Boolean = false
)
