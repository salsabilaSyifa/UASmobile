package com.example.poemy.ui.poetry1

import android.view.LayoutInflater
import android.view.ViewGroup
import androidx.recyclerview.widget.DiffUtil
import androidx.recyclerview.widget.ListAdapter
import androidx.recyclerview.widget.RecyclerView
import com.example.poemy.databinding.ListViewItem2Binding
import com.example.poemy.network.Poetry1

class PoetryListAdapter1(private val clickListener: Poetry1Listener) :
    ListAdapter<Poetry1, PoetryListAdapter1.Poetry1ViewHolder>(DiffCallback)
{
    class Poetry1ViewHolder(
        var binding: ListViewItem2Binding
    ) : RecyclerView.ViewHolder(binding.root){
        fun bind(clickListener: Poetry1Listener, poetry1: Poetry1){
            binding.poetry1 = poetry1
            binding.clickListener = clickListener
            binding.executePendingBindings()
        }
    }

    companion object DiffCallback : DiffUtil.ItemCallback<Poetry1>(){
        override fun areItemsTheSame(oldItem: Poetry1, newItem: Poetry1): Boolean {
            return oldItem.title == newItem.title
        }

        override fun areContentsTheSame(oldItem: Poetry1, newItem: Poetry1): Boolean {
            return oldItem.author == newItem.author && oldItem.linecount == newItem.linecount
        }

    }

    override fun onCreateViewHolder(parent: ViewGroup, viewType: Int) : Poetry1ViewHolder {
        val layoutInflater = LayoutInflater.from(parent.context)
        return Poetry1ViewHolder(
            ListViewItem2Binding.inflate(layoutInflater, parent, false)
        )
    }

    override fun onBindViewHolder(holder: Poetry1ViewHolder, position: Int){
        val poetry1 = getItem(position)
        holder.bind(clickListener, poetry1)
    }

}

class Poetry1Listener(val clickListener: (poetry1: Poetry1) -> Unit){
    fun onClick(poetry1: Poetry1) = clickListener(poetry1)
}