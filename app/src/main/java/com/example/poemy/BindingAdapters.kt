package com.example.poemy

import android.view.View
import android.widget.ImageView
import androidx.databinding.BindingAdapter
import androidx.recyclerview.widget.RecyclerView
import com.example.poemy.network.Poetry
import com.example.poemy.network.Poetry1
import com.example.poemy.network.Poetry2
import com.example.poemy.ui.poetry.PoetryApiStatus
import com.example.poemy.ui.poetry.PoetryListAdapter
import com.example.poemy.ui.poetry1.Poetry1ApiStatus
import com.example.poemy.ui.poetry1.PoetryListAdapter1
import com.example.poemy.ui.poetry2.Poetry2ApiStatus
import com.example.poemy.ui.poetry2.PoetryListAdapter2

@BindingAdapter("listData")
fun bindRecyclerView(recyclerView: RecyclerView, data: List<Poetry>?){
    val adapter = recyclerView.adapter as PoetryListAdapter
    adapter.submitList(data)
}

@BindingAdapter("listDatas")
fun bindRecyclerView1(recyclerView: RecyclerView, data: List<Poetry1>?){
    val adapter = recyclerView.adapter as PoetryListAdapter1
    adapter.submitList(data)
}

@BindingAdapter("listData2")
fun bindRecyclerView2(recyclerView: RecyclerView, data: List<Poetry2>?){
    val adapter = recyclerView.adapter as PoetryListAdapter2
    adapter.submitList(data)

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

@BindingAdapter("apiStatus")
fun bindStatus(statusImageView: ImageView, status: Poetry1ApiStatus?) {
    when(status) {
        Poetry1ApiStatus.LOADING -> {
            statusImageView.visibility = View.VISIBLE
            statusImageView.setImageResource(R.drawable.loading_animation)
        }
        Poetry1ApiStatus.DONE -> {
            statusImageView.visibility = View.GONE
        }
        Poetry1ApiStatus.ERROR -> {
            statusImageView.visibility = View.VISIBLE
            statusImageView.setImageResource(R.drawable.ic_connection_error)
        }
    }
}

@BindingAdapter("apiStatus2")
fun bindStatus2(statusImageView: ImageView, status: Poetry2ApiStatus?) {
    when(status) {
        Poetry2ApiStatus.LOADING -> {
            statusImageView.visibility = View.VISIBLE
            statusImageView.setImageResource(R.drawable.loading_animation)
        }
        Poetry2ApiStatus.DONE -> {
            statusImageView.visibility = View.GONE
        }
        Poetry2ApiStatus.ERROR -> {
            statusImageView.visibility = View.VISIBLE
            statusImageView.setImageResource(R.drawable.ic_connection_error)
        }
    }
}
