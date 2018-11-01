package com.sujin.mvvmsamplearchitecture.ui.posts

import android.databinding.ViewDataBinding
import com.sujin.mvvmsamplearchitecture.R
import com.sujin.mvvmsamplearchitecture.base.BaseAdapter
import com.sujin.mvvmsamplearchitecture.base.BaseViewHolder
import com.sujin.mvvmsamplearchitecture.data.local.entity.PostsDiskModel
import com.sujin.mvvmsamplearchitecture.databinding.ItemPostsBinding

class PostAdapter(
    private val data: List<PostsDiskModel>,
    private val listener: (PostsDiskModel, Int) -> Unit
) : BaseAdapter<PostsDiskModel, PostAdapter.PostsViewHolder, ItemPostsBinding>() {

    override fun getItemCount(): Int = data.size

    override fun getLayoutResource(viewType: Int): Int = R.layout.item_posts

    override fun getViewHolder(binding: ViewDataBinding, viewType: Int): PostsViewHolder =
        PostsViewHolder(binding as ItemPostsBinding)

    override fun onBindCustomViewHolder(holder: PostsViewHolder, position: Int) {
        val item = data[position]
        holder.bind(item)
        holder.itemView.setOnClickListener {
            listener(item, position)
        }
    }

    inner class PostsViewHolder(private val viewBinding: ViewDataBinding) :
        BaseViewHolder(viewBinding)
}