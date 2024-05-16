package com.example.pinterest.fragments

import android.os.Bundle
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import androidx.fragment.app.Fragment
import androidx.fragment.app.viewModels
import com.example.pinterest.adapter.HomeAdapter
import com.example.pinterest.databinding.FragmentHomeBinding
import com.example.pinterest.viewmodel.PinterestViewModel


class HomeFragment : Fragment() {

    private var _binding: FragmentHomeBinding? = null
    private val binding get() = _binding!!
    private val adapter: HomeAdapter by lazy { HomeAdapter() }

    // Initializing PinterestViewModel using viewModels delegate
    private val viewModel: PinterestViewModel by viewModels()


    override fun onCreateView(
        inflater: LayoutInflater, container: ViewGroup?,
        savedInstanceState: Bundle?
    ): View {
        _binding = FragmentHomeBinding.inflate(inflater, container, false)

        return binding.root
    }


    override fun onViewCreated(view: View, savedInstanceState: Bundle?) {
        super.onViewCreated(view, savedInstanceState)

        binding.HomeRes.adapter = adapter
        viewModel.pinsList.observe(viewLifecycleOwner) { pins ->
            pins?.let {
                adapter.submitList(it)
            }
        }

        // Fetch pins list
        viewModel.fetchPinsList(" ")
    }


}


