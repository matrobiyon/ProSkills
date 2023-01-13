package com.ru.listadapter.view.adapter

import androidx.recyclerview.widget.DiffUtil
import com.ru.listadapter.model.data.Story

class StoryDiffUtils : DiffUtil.ItemCallback<Story>() {
    override fun areItemsTheSame(oldItem: Story, newItem: Story): Boolean {
        return oldItem == newItem
    }

    override fun areContentsTheSame(oldItem: Story, newItem: Story): Boolean {
        return oldItem == newItem
    }
}