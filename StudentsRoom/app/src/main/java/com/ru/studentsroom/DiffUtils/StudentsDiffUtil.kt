package com.ru.studentsroom.DiffUtils

import androidx.recyclerview.widget.DiffUtil
import com.ru.studentsroom.room.Student

class StudentsDiffUtil : DiffUtil.ItemCallback<Student>() {
    override fun areItemsTheSame(oldItem: Student, newItem: Student): Boolean =
        oldItem.id == newItem.id

    override fun areContentsTheSame(oldItem: Student, newItem: Student): Boolean =
        oldItem == newItem
}