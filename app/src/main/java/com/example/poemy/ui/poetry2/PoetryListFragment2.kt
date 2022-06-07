package com.example.poemy.ui.poetry2

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
import com.example.poemy.databinding.FragmentPoetry2ListBinding
import com.google.android.material.divider.MaterialDividerItemDecoration

class PoetryListFragment2 : Fragment(){
    private val viewModel: PoetryViewModel2 by activityViewModels()

    override fun onCreateView(
        inflater: LayoutInflater,
        container: ViewGroup?,
        savedInstanceState: Bundle?
    ): View? {
        val binding = FragmentPoetry2ListBinding.inflate(inflater)
        viewModel.getPoetry2List()
        binding.lifecycleOwner = this
        binding.viewModel = viewModel
        binding.recyclerView.adapter = PoetryListAdapter2(Poetry2Listener { poetry2 ->
            viewModel.onPoetryClicked(poetry2)
            findNavController()
                .navigate(R.id.action_poetryListFragment2_to_poetryDetailFragment2)
        })

        (activity as AppCompatActivity).supportActionBar?.title = "Poemy"

        binding.recyclerView.addItemDecoration(MaterialDividerItemDecoration(requireContext(), LinearLayoutManager.VERTICAL))


        return binding.root
    }
}