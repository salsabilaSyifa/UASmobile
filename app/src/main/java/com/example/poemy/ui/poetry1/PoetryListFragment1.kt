package com.example.poemy.ui.poetry1

import android.os.Bundle
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import androidx.appcompat.app.AppCompatActivity
import androidx.fragment.app.Fragment
import androidx.fragment.app.activityViewModels
import androidx.navigation.fragment.findNavController
import androidx.recyclerview.widget.LinearLayoutManager
import com.example.poemy.R
import com.example.poemy.databinding.FragmentPoetry1ListBinding
import com.example.poemy.databinding.FragmentPoetryListBinding
import com.example.poemy.network.Poetry1
import com.example.poemy.ui.poetry.PoetryListAdapter
import com.example.poemy.ui.poetry.PoetryListener
import com.example.poemy.ui.poetry.PoetryViewModel
import com.google.android.material.divider.MaterialDividerItemDecoration

class PoetryListFragment1  : Fragment(){
    private val viewModel: PoetryViewModel1 by activityViewModels()

    override fun onCreateView(
        inflater: LayoutInflater,
        container: ViewGroup?,
        savedInstanceState: Bundle?
    ): View? {
        val binding = FragmentPoetry1ListBinding.inflate(inflater)
        viewModel.getPoetry1List()
        binding.lifecycleOwner = this
        binding.viewModel1= viewModel
        binding.recyclerView1.adapter = PoetryListAdapter1(Poetry1Listener { poetry1 ->
            viewModel.onPoetry1Clicked(poetry1)
            findNavController()
                .navigate(R.id.action_poetryListFragment1_to_poetryDetailFragment1)
        })

        (activity as AppCompatActivity).supportActionBar?.title = "Poemy"

        binding.recyclerView1.addItemDecoration(MaterialDividerItemDecoration(requireContext(), LinearLayoutManager.VERTICAL))


        return binding.root
    }
}