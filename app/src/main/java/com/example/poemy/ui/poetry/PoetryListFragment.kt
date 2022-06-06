package com.example.poemy.ui.poetry

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
import com.example.poemy.databinding.FragmentPoetryListBinding
import com.google.android.material.divider.MaterialDividerItemDecoration

class PoetryListFragment : Fragment(){
    private val viewModel: PoetryViewModel by activityViewModels()

    override fun onCreateView(
        inflater: LayoutInflater,
        container: ViewGroup?,
        savedInstanceState: Bundle?
    ): View? {
        val binding = FragmentPoetryListBinding.inflate(inflater)
        viewModel.getPoetryList()
        binding.lifecycleOwner = this
        binding.viewModel = viewModel
        binding.recyclerView.adapter = PoetryListAdapter(PoetryListener { poetry ->
            viewModel.onPoetryClicked(poetry)
            findNavController()
                .navigate(R.id.action_poetryListFragment_to_poetryDetailFragment)
        })

        (activity as AppCompatActivity).supportActionBar?.title = "Poemy"

        binding.recyclerView.addItemDecoration(MaterialDividerItemDecoration(requireContext(), LinearLayoutManager.VERTICAL))


        return binding.root
    }
}