package com.ru.dodopizza.adapter

import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import androidx.core.content.ContextCompat
import androidx.recyclerview.widget.ListAdapter
import androidx.recyclerview.widget.RecyclerView.ViewHolder
import com.ru.dodopizza.R
import com.ru.dodopizza.data.CategoryData
import com.ru.dodopizza.databinding.CategoryItemBinding

class CategoryAdapter() :
    ListAdapter<CategoryData, CategoryAdapter.CategoryViewHolder>(CategoryDiffUtils()) {

    var onClickedSelectedItem : ((Int) -> (Unit))? = null

    var onFilter: ((String) -> (Unit))? = null

    //1 METHOD FOR changing selected Item
//    private var currentClicked = 0
    //When clicked on certain item
//    fun onButtonClicked(pos: Int) {
//        currentList[currentClicked].isChecked = false
//        notifyItemChanged(currentClicked)
//        currentList[pos].isChecked = true
//        notifyItemChanged(pos)
//        currentClicked = pos
//    }

    //ViewHolder
    inner class CategoryViewHolder(itemView: View) : ViewHolder(itemView) {
        private val binding = CategoryItemBinding.bind(itemView)

        //Binding the data and setting background and text color
        fun bind(categoryData: CategoryData) {
            binding.categoryText.text = categoryData.category
            if (categoryData.isChecked) {
                binding.categoryText.setBackgroundResource(R.drawable.custom_shape_cheked)
                binding.categoryText.setTextColor(ContextCompat.getColor(binding.root.context,R.color.orange_dark))
            } else {
                binding.categoryText.setBackgroundResource(R.drawable.custom_shape_uncheked)
                binding.categoryText.setTextColor(ContextCompat.getColor(binding.root.context,R.color.grey_dark))
            }

            //OnClick Listener for certain Item
            binding.categoryText.setOnClickListener {
                // 2 method but not that good Amimation
                onClickedSelectedItem?.invoke(adapterPosition)

                onFilter?.invoke(categoryData.category)

//                 onButtonClicked(adapterPosition)

            }
        }
    }

    override fun onCreateViewHolder(parent: ViewGroup, viewType: Int): CategoryViewHolder {
        return CategoryViewHolder(
            LayoutInflater.from(parent.context).inflate(R.layout.category_item, parent, false)
        )
    }

    override fun onBindViewHolder(holder: CategoryViewHolder, position: Int) {
        holder.bind(getItem(position))
    }
}