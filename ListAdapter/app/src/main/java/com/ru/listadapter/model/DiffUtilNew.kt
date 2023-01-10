package com.ru.listadapter.model

import androidx.recyclerview.widget.DiffUtil
import com.ru.listadapter.model.data.PostAdd


class DiffUtilNew : DiffUtil.ItemCallback<PostAdd>() {
    override fun areItemsTheSame(oldItem: PostAdd, newItem: PostAdd): Boolean = oldItem.id == newItem.id

    override fun areContentsTheSame(oldItem: PostAdd, newItem: PostAdd): Boolean = oldItem == newItem
}
