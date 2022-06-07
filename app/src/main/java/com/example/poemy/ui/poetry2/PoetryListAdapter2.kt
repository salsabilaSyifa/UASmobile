package com.example.poemy.ui.poetry2

import android.view.LayoutInflater
import android.view.ViewGroup
import androidx.recyclerview.widget.DiffUtil
import androidx.recyclerview.widget.ListAdapter
import androidx.recyclerview.widget.RecyclerView
import com.example.poemy.databinding.ListViewItem3Binding
import com.example.poemy.network.Poetry2

class PoetryListAdapter2 (private val clickListener: Poetry2Listener) :
    ListAdapter<Poetry2, PoetryListAdapter2.Poetry2ViewHolder>(DiffCallback)
{
    class Poetry2ViewHolder(
        var binding: ListViewItem3Binding
    ) : RecyclerView.ViewHolder(binding.root){
        fun bind(clickListener: Poetry2Listener, poetry2: Poetry2){
            binding.poetry2 = poetry2
            binding.clickListener = clickListener
            binding.executePendingBindings()
        }
    }

    companion object DiffCallback : DiffUtil.ItemCallback<Poetry2>(){
        override fun areItemsTheSame(oldItem: Poetry2, newItem: Poetry2): Boolean {
            return oldItem.title == newItem.title
        }

        override fun areContentsTheSame(oldItem: Poetry2, newItem: Poetry2): Boolean {
            return oldItem.author == newItem.author && oldItem.linecount == newItem.linecount
        }

    }

    override fun onCreateViewHolder(parent: ViewGroup, viewType: Int) : PoetryListAdapter2.Poetry2ViewHolder {
        val layoutInflater = LayoutInflater.from(parent.context)
        return PoetryListAdapter2.Poetry2ViewHolder(
            ListViewItem3Binding.inflate(layoutInflater, parent, false)
        )
    }

    override fun onBindViewHolder(holder: Poetry2ViewHolder, position: Int){
        val poetry2 = getItem(position)
        holder.bind(clickListener, poetry2)
    }



}

class Poetry2Listener(val clickListener: (poetry2: Poetry2) -> Unit){
    fun onClick(poetry2: Poetry2) = clickListener(poetry2)
}