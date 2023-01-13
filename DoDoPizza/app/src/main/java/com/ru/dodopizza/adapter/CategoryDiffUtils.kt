package com.ru.dodopizza.adapter

import androidx.recyclerview.widget.DiffUtil
import com.ru.dodopizza.data.CategoryData

// Оказываеться если не менять лист ПОЛНОСТЬЮ submitList не будет работать :(
class CategoryDiffUtils : DiffUtil.ItemCallback<CategoryData>() {
    override fun areItemsTheSame(oldItem: CategoryData, newItem: CategoryData): Boolean {
        return oldItem == newItem
    }

    override fun areContentsTheSame(oldItem: CategoryData, newItem: CategoryData): Boolean {
        return oldItem.isChecked == newItem.isChecked
    }
}