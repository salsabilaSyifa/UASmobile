package com.example.poemy.ui.poetry

import android.view.LayoutInflater
import android.view.ViewGroup
import androidx.recyclerview.widget.DiffUtil
import androidx.recyclerview.widget.ListAdapter
import androidx.recyclerview.widget.RecyclerView
import com.example.poemy.databinding.ListViewItemBinding
import com.example.poemy.network.Poetry

class PoetryListAdapter(private val clickListener: PoetryListener) :
    ListAdapter<Poetry, PoetryListAdapter.PoetryViewHolder>(DiffCallback)
{
    class PoetryViewHolder(
        var binding: ListViewItemBinding
    ) : RecyclerView.ViewHolder(binding.root){
        fun bind(clickListener: PoetryListener, poetry: Poetry){
            binding.poetry = poetry
            binding.clickListener = clickListener
            binding.executePendingBindings()
        }
    }

    companion object DiffCallback : DiffUtil.ItemCallback<Poetry>(){
        override fun areItemsTheSame(oldItem: Poetry, newItem: Poetry): Boolean {
            return oldItem.title == newItem.title
        }

        override fun areContentsTheSame(oldItem: Poetry, newItem: Poetry): Boolean {
            return oldItem.author == newItem.author && oldItem.linecount == newItem.linecount
        }

    }

    override fun onCreateViewHolder(parent: ViewGroup, viewType: Int) : PoetryViewHolder {
        val layoutInflater = LayoutInflater.from(parent.context)
        return PoetryViewHolder(
            ListViewItemBinding.inflate(layoutInflater, parent, false)
        )
    }

    override fun onBindViewHolder(holder: PoetryViewHolder, position: Int){
        val poetry = getItem(position)
        holder.bind(clickListener, poetry)
    }



}

class PoetryListener(val clickListener: (poetry: Poetry ) -> Unit){
    fun onClick(poetry: Poetry) = clickListener(poetry)
}