package com.example.poemy.ui.poetry

import android.os.Bundle
import android.view.LayoutInflater
import android.view.MenuItem
import android.view.View
import android.view.ViewGroup
import androidx.appcompat.app.AppCompatActivity
import androidx.fragment.app.Fragment
import androidx.fragment.app.activityViewModels
import androidx.navigation.fragment.findNavController
import com.example.poemy.R
import com.example.poemy.databinding.FragmentPoetryDetailBinding

class PoetryDetailFragment : Fragment() {
    private val viewModel: PoetryViewModel by activityViewModels()

    override fun onCreateView(
        inflater: LayoutInflater,
        container: ViewGroup?,
        savedInstanceState: Bundle?
    ): View? {
        val binding = FragmentPoetryDetailBinding.inflate(inflater)
        binding.lifecycleOwner = this
        binding.viewModel = viewModel

        (activity as AppCompatActivity).supportActionBar?.title = viewModel.poem.value?.title
        return binding.root
    }

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setHasOptionsMenu(true)

    }

    override fun onOptionsItemSelected(item: MenuItem): Boolean {
        when(item.itemId){
            android.R.id.home -> findNavController().navigate(R.id.action_poetryDetailFragment_to_poetryListFragment)
        }
        return true
    }
}