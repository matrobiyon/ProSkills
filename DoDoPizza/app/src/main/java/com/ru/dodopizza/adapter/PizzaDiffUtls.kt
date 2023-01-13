package com.ru.dodopizza.adapter

import androidx.recyclerview.widget.DiffUtil
import com.ru.dodopizza.data.PizzaData

class PizzaDiffUtls : DiffUtil.ItemCallback<PizzaData>() {
    override fun areItemsTheSame(oldItem: PizzaData, newItem: PizzaData): Boolean {
        return oldItem == newItem
    }

    override fun areContentsTheSame(oldItem: PizzaData, newItem: PizzaData): Boolean {
        return oldItem == newItem
    }
}