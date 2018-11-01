package com.sujin.mvvmsamplearchitecture.ui.posts

import android.arch.lifecycle.Observer
import android.arch.lifecycle.ViewModelProviders
import android.os.Bundle
import com.sujin.mvvmsamplearchitecture.R
import com.sujin.mvvmsamplearchitecture.base.BaseActivity
import com.sujin.mvvmsamplearchitecture.databinding.ActivityPostsBinding
import com.sujin.mvvmsamplearchitecture.utils.viewmodel.Status
import javax.inject.Inject

class PostsActivity : BaseActivity<ActivityPostsBinding>() {

    @Inject
    lateinit var postsViewModelFactory: PostsViewModelFactory

    private lateinit var postViewModel: PostsViewModel

    override fun layout(): Int = R.layout.activity_posts

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        postViewModel =
                ViewModelProviders.of(this, postsViewModelFactory).get(PostsViewModel::class.java)
        postViewModel.fetchPostsList()
        observePostsFetch()
    }

    private fun observePostsFetch() {
        postViewModel.postsResponse().observe(this, Observer { response ->
            when (response?.status) {
                Status.LOADING -> {
                }
                Status.COMPLETE -> {
                    val data = response.data
                }
                Status.ERROR -> {
                }
            }
        })
    }
}
