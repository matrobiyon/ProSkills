package com.ru.studentsroom.DiffUtils

import androidx.recyclerview.widget.DiffUtil
import com.ru.studentsroom.room.Subjects

class SubjectsDetailedDiffUtil : DiffUtil.ItemCallback<Subjects>() {
    override fun areItemsTheSame(oldItem: Subjects, newItem: Subjects): Boolean =
        oldItem.id == newItem.id

    override fun areContentsTheSame(oldItem: Subjects, newItem: Subjects): Boolean =
        oldItem == newItem
}