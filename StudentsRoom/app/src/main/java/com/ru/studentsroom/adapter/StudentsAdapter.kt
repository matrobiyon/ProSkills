package com.ru.studentsroom.adapter

import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import androidx.recyclerview.widget.ListAdapter
import androidx.recyclerview.widget.RecyclerView.ViewHolder
import com.ru.studentsroom.DiffUtils.StudentsDiffUtil
import com.ru.studentsroom.R
import com.ru.studentsroom.databinding.StudentItemBinding
import com.ru.studentsroom.room.Student

class StudentsAdapter : ListAdapter<Student, StudentsAdapter.StudentViewHolder>(StudentsDiffUtil()) {

    var onPodrobneeClicked : ((Student) -> (Unit))? = null

    inner class StudentViewHolder(itemView: View) : ViewHolder(itemView) {
        private val binding = StudentItemBinding.bind(itemView)

        fun bind(student: Student){
            binding.studentCourse.text = student.course.toString()
            binding.studentUniversity.text = student.university
            binding.studentName.text = "${student.name} ${student.surname} "
            binding.information.setOnClickListener {
                onPodrobneeClicked?.invoke(student)
            }
        }
    }

    override fun onCreateViewHolder(parent: ViewGroup, viewType: Int): StudentViewHolder {
        return StudentViewHolder(LayoutInflater.from(parent.context).inflate(R.layout.student_item,parent,false))
    }

    override fun onBindViewHolder(holder: StudentViewHolder, position: Int) {
        holder.bind(getItem(position))
    }

}