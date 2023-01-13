package com.ru.multityperv.data

import com.ru.multityperv.R
import com.ru.multityperv.models.Post
import com.ru.multityperv.models.PostWithImages
import com.ru.multityperv.models.PostWithText

class ListForRV {

    var randomText = "Lorem Ipsum is simply dummy text of the printing and typesetting industry. Lorem Ipsum has been the industry's standard dummy text ever since the 1500s, when an unknown printer took a galley of type and scrambled it to make a type specimen book. It has survived not only five centuries, but also the leap into electronic typesetting, remaining essentially unchanged. It was popularised in the 1960s with the release of Letraset sheets containing Lorem Ipsum passages, and more recently with desktop publishing software like Aldus PageMaker including versions of Lorem Ipsum."

    fun getList() : MutableList<Post> {
        val list : MutableList<Post> = mutableListOf()
        repeat(2){
            list.add(PostWithImages(R.drawable.avatarka,"drakeet",R.drawable.random_image))
        }
        repeat(3){
            list.add(PostWithText(R.drawable.avatarka,"drakeet",randomText))
        }
        repeat(2){
            list.add(PostWithImages(R.drawable.avatarka,"drakeet",R.drawable.random_image))
        }
        repeat(3){
            list.add(PostWithText(R.drawable.avatarka,"drakeet",randomText))
        }
        return list
    }
}