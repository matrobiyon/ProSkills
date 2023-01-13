package com.ru.listadapter.model.data

import com.ru.listadapter.R

data class Story(
    val name : String,
    val avatar : Int = R.drawable.welcome,
    val seen : Boolean = false
)
