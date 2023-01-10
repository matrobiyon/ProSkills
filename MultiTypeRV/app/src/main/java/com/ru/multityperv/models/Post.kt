package com.ru.multityperv.models

sealed class Post

data class PostWithImages(val avatarak : Int, val name : String, val image : Int) : Post()
data class PostWithText (val avatarak : Int, val name : String, val text : String) : Post()

