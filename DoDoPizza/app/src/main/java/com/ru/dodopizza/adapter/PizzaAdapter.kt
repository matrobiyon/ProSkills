package com.ru.dodopizza.adapter

import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import androidx.recyclerview.widget.ListAdapter
import androidx.recyclerview.widget.RecyclerView
import com.ru.dodopizza.R
import com.ru.dodopizza.data.GetPizzaList
import com.ru.dodopizza.data.PizzaData
import com.ru.dodopizza.databinding.PizzaItemBinding

class PizzaAdapter : ListAdapter<PizzaData,PizzaAdapter.PizzaViewHolder>(PizzaDiffUtls()) {

    var list = GetPizzaList().getList()

    inner class PizzaViewHolder(itemView: View) : RecyclerView.ViewHolder(itemView) {
        private var binding = PizzaItemBinding.bind(itemView)

        fun bind(pizzaData: PizzaData){
            binding.pizzaImage.setImageResource(pizzaData.image)
            binding.pizzaName.text = pizzaData.name
            binding.pizzaAbout.text = pizzaData.about
            binding.piccaPrice.text = pizzaData.formatPrice()
        }
    }

    override fun onCreateViewHolder(parent: ViewGroup, viewType: Int): PizzaViewHolder {
        return PizzaViewHolder(LayoutInflater.from(parent.context).inflate(R.layout.pizza_item,parent,false))
    }

    override fun onBindViewHolder(holder: PizzaViewHolder, position: Int) {
        holder.bind(getItem(position))
    }
}