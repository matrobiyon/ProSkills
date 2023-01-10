package com.ru.listadapter.view.adapter

import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import android.widget.ImageView
import android.widget.TextView
import androidx.recyclerview.widget.RecyclerView
import com.ru.listadapter.R
import com.ru.listadapter.model.data.PostAdd
import com.ru.listadapter.model.loadData.ListOfAddedImages


class PostAdapterRV : RecyclerView.Adapter<PostAdapterRV.PostViewHolder>() {

    var list = ListOfAddedImages

    fun updateLikes(postId : Int){
        if (list[postId-1].likes == true)
            list[postId - 1].likes = false
        else list[postId-1].likes = true
        notifyItemChanged(postId-1)
    }

    override fun onCreateViewHolder(parent: ViewGroup, viewType: Int): PostViewHolder {
       return PostViewHolder(LayoutInflater.from(parent.context).inflate(R.layout.post_item,parent,false))
    }

    override fun onBindViewHolder(holder: PostViewHolder, position: Int) {
        val currentPost = list[position]
        holder.setData(currentPost)
    }

    override fun getItemCount(): Int = list.size

    inner class PostViewHolder (view : View) : RecyclerView.ViewHolder(view){
        var userName = view.findViewById<TextView>(R.id.postUserName)
        var avatar = view.findViewById<ImageView>(R.id.usersPostAvatar)
        var post = view.findViewById<ImageView>(R.id.postImage)
        var likes = view.findViewById<ImageView>(R.id.likeItem)

        fun setData(postData : PostAdd){
            userName.text = postData.user.name
            avatar.setImageResource(postData.user.avatar)
            post.setImageResource(postData.imageAdd)
            if (postData.likes == true)
                likes.setImageResource(R.drawable.ic_liked_true)
            else
                likes.setImageResource(R.drawable.ic_like)
            likes.setOnClickListener {
                updateLikes(postData.id)
            }
            post.setOnClickListener {
                updateLikes(postData.id)
            }
        }
    }
}