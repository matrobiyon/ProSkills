package com.ru.multityperv.adapter

import android.view.LayoutInflater
import android.view.ViewGroup
import androidx.recyclerview.widget.RecyclerView
import com.ru.multityperv.data.ListForRV
import com.ru.multityperv.databinding.PostWithImageBinding
import com.ru.multityperv.databinding.PostWithTextBinding
import com.ru.multityperv.models.Post
import com.ru.multityperv.models.PostWithImages
import com.ru.multityperv.models.PostWithText

class MultiTypeRV : RecyclerView.Adapter<RecyclerView.ViewHolder>() {

    var list = ListForRV().getList()

    inner class ViewHolderText(var textBinding : PostWithTextBinding) : RecyclerView.ViewHolder(textBinding.root) {

        fun bind(current: PostWithText){
            textBinding.avatarka.setImageResource(current.avatarak)
            textBinding.userName.text = current.name
            textBinding.postedText.text = current.text
        }
    }

    inner class ViewHolderImage(var imageBinding : PostWithImageBinding) : RecyclerView.ViewHolder(imageBinding.root){

        fun bind(current: PostWithImages) {
            imageBinding.avatarka.setImageResource(current.avatarak)
            imageBinding.userName.text = current.name
            imageBinding.postedImage.setImageResource(current.image)
        }

    }

    override fun getItemViewType(position: Int): Int {
        return when (list[position]){
            is PostWithImages -> return POSTWITHIMAGE
            else -> return POSTWITHTEXT
        }
    }

    override fun onCreateViewHolder(parent: ViewGroup, viewType: Int): RecyclerView.ViewHolder {
        val view = LayoutInflater.from(parent.context)
        when (viewType){
            POSTWITHIMAGE -> return ViewHolderImage(PostWithImageBinding.inflate(LayoutInflater.from(parent.context)))
        }
        return ViewHolderText(PostWithTextBinding.inflate(LayoutInflater.from(parent.context)))
    }

    override fun onBindViewHolder(holder: RecyclerView.ViewHolder, position: Int) {
        val current = list[position]
        when (holder){
            is ViewHolderImage -> holder.bind(current as PostWithImages)
            is ViewHolderText -> holder.bind(current as PostWithText)
        }
    }


    override fun getItemCount(): Int = list.size

    companion object {
        val POSTWITHIMAGE = 0
        val POSTWITHTEXT = 1
    }


}
