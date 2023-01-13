package com.ru.listadapter.view.adapter

import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import android.widget.FrameLayout
import android.widget.ImageView
import android.widget.TextView
import androidx.recyclerview.widget.ListAdapter
import androidx.recyclerview.widget.RecyclerView
import com.ru.listadapter.R
import com.ru.listadapter.model.data.Story

class StoryAdapter : ListAdapter<Story,StoryAdapter.StoryViewHolder>(StoryDiffUtils()) {

    var onStoryClicked : ((Int) -> (Unit))? = null

    override fun onCreateViewHolder(parent: ViewGroup, viewType: Int): StoryViewHolder {
        return StoryViewHolder(LayoutInflater.from(parent.context).inflate(R.layout.stories_item,parent,false))
    }

    override fun onBindViewHolder(holder: StoryViewHolder, position: Int) {
        holder.bind(getItem(position))
    }

    inner class StoryViewHolder (view : View) : RecyclerView.ViewHolder(view){
        var storyPhoto = view.findViewById<ImageView>(R.id.storyPhoto)
        var storyText = view.findViewById<TextView>(R.id.storyText)
        val storyBackground = view.findViewById<FrameLayout>(R.id.frameLayout)


        fun bind(currentStory: Story) {
            storyPhoto.setImageResource(currentStory.avatar)
            storyText.text = currentStory.name

            if (currentStory.seen)
                storyBackground.setBackgroundResource(R.drawable.stories_background_checked)
            else storyBackground.setBackgroundResource(R.drawable.stories_background_unchecked)

            storyPhoto.setOnClickListener {
                onStoryClicked?.invoke(adapterPosition)
            }
        }
    }
}