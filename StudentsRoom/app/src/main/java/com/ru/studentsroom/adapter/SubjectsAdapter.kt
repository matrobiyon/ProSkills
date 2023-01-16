package com.ru.studentsroom.adapter

import android.util.Log
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import androidx.recyclerview.widget.ListAdapter
import androidx.recyclerview.widget.RecyclerView.ViewHolder
import com.ru.studentsroom.DiffUtils.SubjectDiffUtils
import com.ru.studentsroom.R
import com.ru.studentsroom.databinding.SubjectItemBinding
import com.ru.studentsroom.room.Subjects

class SubjectsAdapter : ListAdapter<Subjects, SubjectsAdapter.SubjectViewHolder>(SubjectDiffUtils()) {

    var onClicked : ((Subjects,Boolean) -> (Unit))? = null

    inner class SubjectViewHolder(itemView: View) : ViewHolder(itemView){
        private val binding = SubjectItemBinding.bind(itemView)

        fun bind(subjects: Subjects){
            binding.subjectName.text = subjects.subjectName
            binding.checkbox.setOnClickListener {
                val stateCheckbox: Boolean = binding.checkbox.isChecked
                Log.d("MyERROR", "$stateCheckbox stataCheckbox")
                onClicked?.invoke(subjects, stateCheckbox)
            }
        }
    }
    override fun onCreateViewHolder(parent: ViewGroup, viewType: Int): SubjectViewHolder {
        return SubjectViewHolder(LayoutInflater.from(parent.context).inflate(R.layout.subject_item,parent,false))
    }

    override fun onBindViewHolder(holder: SubjectViewHolder, position: Int) {
        holder.bind(getItem(position))
    }
}