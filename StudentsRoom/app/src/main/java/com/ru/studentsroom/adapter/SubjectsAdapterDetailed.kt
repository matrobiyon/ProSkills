package com.ru.studentsroom.adapter

import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import androidx.recyclerview.widget.ListAdapter
import androidx.recyclerview.widget.RecyclerView.ViewHolder
import com.ru.studentsroom.DiffUtils.SubjectsDetailedDiffUtil
import com.ru.studentsroom.R
import com.ru.studentsroom.databinding.SubjectItemDetailedBinding
import com.ru.studentsroom.room.Subjects

class SubjectsAdapterDetailed : ListAdapter<Subjects,SubjectsAdapterDetailed.SubjectsDetailedViewHolder>(SubjectsDetailedDiffUtil()) {

    inner class SubjectsDetailedViewHolder(itemView: View) : ViewHolder(itemView){
        private val binding = SubjectItemDetailedBinding.bind(itemView)
        fun bind(subjects: Subjects){
            binding.subjectName.text = subjects.subjectName
            binding.checkBox.isChecked = subjects.isExamination
        }
    }

    override fun onCreateViewHolder(parent: ViewGroup, viewType: Int): SubjectsDetailedViewHolder {
        return SubjectsDetailedViewHolder(LayoutInflater.from(parent.context).inflate(R.layout.subject_item_detailed,parent,false))
    }

    override fun onBindViewHolder(holder: SubjectsDetailedViewHolder, position: Int) {
        holder.bind(getItem(position))
    }
}