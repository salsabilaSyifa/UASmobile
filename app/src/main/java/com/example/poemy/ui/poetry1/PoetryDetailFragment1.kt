package com.example.poemy.ui.poetry1

import android.os.Bundle
import android.view.LayoutInflater
import android.view.MenuItem
import android.view.View
import android.view.ViewGroup
import androidx.appcompat.app.AppCompatActivity
import androidx.fragment.app.Fragment
import androidx.fragment.app.activityViewModels
import androidx.navigation.Navigation.findNavController
import androidx.navigation.fragment.findNavController
import com.example.poemy.R
import com.example.poemy.databinding.FragmentPoetry1DetailBinding
import com.example.poemy.ui.poetry.PoetryViewModel

class PoetryDetailFragment1 : Fragment() {
    private val viewModel1: PoetryViewModel1 by activityViewModels()

    override fun onCreateView(
        inflater: LayoutInflater,
        container: ViewGroup?,
        savedInstanceState: Bundle?
    ): View? {
        val binding1 = FragmentPoetry1DetailBinding.inflate(inflater)
        binding1.lifecycleOwner = this
        binding1.viewModel = viewModel1

        (activity as AppCompatActivity).supportActionBar?.title = viewModel1.poem1.value?.title1
        return binding1.root
    }

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setHasOptionsMenu(true)

    }

    override fun onOptionsItemSelected(item: MenuItem): Boolean {
        when(item.itemId){
            android.R.id.home -> findNavController().navigate(R.id.action_poetryListFragment1_to_poetryDetailFragment1)
        }
        return true
    }
}