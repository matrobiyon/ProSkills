package com.ru.listadapter.view.adapter

import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import android.widget.ImageView
import android.widget.TextView
import androidx.recyclerview.widget.RecyclerView
import com.ru.listadapter.R
import com.ru.listadapter.model.loadData.listOfUsers

class StoryAdapter : RecyclerView.Adapter<StoryAdapter.StoryViewHolder>() {

    var list = listOfUsers

    override fun onCreateViewHolder(parent: ViewGroup, viewType: Int): StoryViewHolder {
        return StoryViewHolder(LayoutInflater.from(parent.context).inflate(R.layout.stories_item,parent,false))
    }

    override fun onBindViewHolder(holder: StoryViewHolder, position: Int) {
        val currentUser = list[position]

        holder.setPhoto(currentUser.avatar)
        holder.setText(currentUser.name)
    }

    override fun getItemCount(): Int = list.size

    inner class StoryViewHolder (view : View) : RecyclerView.ViewHolder(view){
        var storyPhoto = view.findViewById<ImageView>(R.id.storyPhoto)
        var storyText = view.findViewById<TextView>(R.id.storyText)

        fun setPhoto(image : Int){
            storyPhoto.setImageResource(image)

        }
        fun setText(userName : String){
            storyText.text = userName
        }
    }
}