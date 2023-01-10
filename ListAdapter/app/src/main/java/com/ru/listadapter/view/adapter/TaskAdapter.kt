import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import android.widget.ImageView
import android.widget.TextView
import androidx.recyclerview.widget.ListAdapter
import androidx.recyclerview.widget.RecyclerView
import com.ru.listadapter.R
import com.ru.listadapter.model.DiffUtilNew
import com.ru.listadapter.model.data.PostAdd

class TaskAdapter() : ListAdapter<PostAdd, TaskAdapter.ListViewHolder>(DiffUtilNew()) {

    fun getNewList(postId: Int): List<PostAdd> {
        val newList = currentList
        newList[postId - 1].likes = currentList[postId - 1].likes != true
        return newList
    }

    inner class ListViewHolder(view: View) : RecyclerView.ViewHolder(view) {

        var userName = view.findViewById<TextView>(R.id.postUserName)
        var avatar = view.findViewById<ImageView>(R.id.usersPostAvatar)
        var post = view.findViewById<ImageView>(R.id.postImage)
        var likes = view.findViewById<ImageView>(R.id.likeItem)

        fun setData(postData: PostAdd) {
            userName.text = postData.user.name
            avatar.setImageResource(postData.user.avatar)
            post.setImageResource(postData.imageAdd)

            if (postData.likes)
                likes.setImageResource(R.drawable.ic_liked_true)
            else
                likes.setImageResource(R.drawable.ic_like)

            likes.setOnClickListener {
                val newList = getNewList(postData.id)
                submitList(newList)
                if (postData.likes)
                    likes.setImageResource(R.drawable.ic_liked_true)
                else
                    likes.setImageResource(R.drawable.ic_like)
            }
            post.setOnClickListener {
                val newList = getNewList(postData.id)
                submitList(newList)
                if (postData.likes)
                    likes.setImageResource(R.drawable.ic_liked_true)
                else
                    likes.setImageResource(R.drawable.ic_like)
            }
        }
    }

    override fun onCreateViewHolder(parent: ViewGroup, viewType: Int): ListViewHolder {
        return ListViewHolder(
            LayoutInflater.from(parent.context).inflate(R.layout.post_item, parent, false)
        )
    }

    override fun onBindViewHolder(holder: ListViewHolder, position: Int) {
        holder.setData(getItem(position))
    }
}