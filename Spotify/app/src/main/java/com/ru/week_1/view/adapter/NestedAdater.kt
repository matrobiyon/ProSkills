package com.ru.week_1.view.adapter

import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import android.widget.TextView
import androidx.recyclerview.widget.RecyclerView
import com.ru.week_1.R
import com.ru.week_1.model.MusicData

class NestedAdapter (
            var list: List<MusicData>,

        ) : RecyclerView.Adapter<NestedAdapter.NestedViewHolder>() {


    inner class NestedViewHolder(view: View) : RecyclerView.ViewHolder(view){
        var title = view.findViewById<TextView>(R.id.parent_item_tv)
        var music_item_rv = view.findViewById<RecyclerView>(R.id.child_rv)

        fun setTitle(){
            title.text = "Композитор"
        }
        fun setRV(){
            music_item_rv.adapter = MusicAdapter(list)
        }
    }

    override fun onCreateViewHolder(parent: ViewGroup, viewType: Int): NestedViewHolder {
        var view = LayoutInflater.from(parent.context).inflate(R.layout.nested_item, parent, false)
        return NestedViewHolder(view)
    }

    override fun onBindViewHolder(holder: NestedViewHolder, position: Int) {
        holder.setTitle()
        holder.setRV()
    }

    override fun getItemCount(): Int = 5
}