package com.example.poemy

import android.view.View
import android.widget.ImageView
import androidx.databinding.BindingAdapter
import androidx.recyclerview.widget.RecyclerView
import com.example.poemy.network.Poetry
import com.example.poemy.ui.poetry.PoetryApiStatus
import com.example.poemy.ui.poetry.PoetryListAdapter

@BindingAdapter("listData")
fun bindRecyclerView(recyclerView: RecyclerView, data: List<Poetry>?){
    val adapter = recyclerView.adapter as PoetryListAdapter
    adapter.submitList(data)
}

@BindingAdapter("apiStatus")
fun bindStatus(statusImageView: ImageView, status: PoetryApiStatus?) {
    when(status) {
        PoetryApiStatus.LOADING -> {
            statusImageView.visibility = View.VISIBLE
            statusImageView.setImageResource(R.drawable.loading_animation)
        }
        PoetryApiStatus.DONE -> {
            statusImageView.visibility = View.GONE
        }
        PoetryApiStatus.ERROR -> {
            statusImageView.visibility = View.VISIBLE
            statusImageView.setImageResource(R.drawable.ic_connection_error)
        }
    }
}