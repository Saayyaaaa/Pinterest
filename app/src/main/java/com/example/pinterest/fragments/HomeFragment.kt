package com.example.pinterest.fragments

import android.os.Bundle
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import androidx.fragment.app.Fragment
import androidx.lifecycle.lifecycleScope
import com.example.pinterest.adapter.HomeAdapter
import com.example.pinterest.databinding.FragmentHomeBinding
import com.example.pinterest.models.PinterestPins
import com.example.pinterest.network.PinterestApiClient
import com.example.pinterest.network.PinterestService
import kotlinx.coroutines.Dispatchers
import kotlinx.coroutines.launch

class HomeFragment : Fragment() {



    private var _binding: FragmentHomeBinding? = null
    private val binding get() = _binding!!

    private val adapter: HomeAdapter by lazy {
        HomeAdapter()
    }

    private val pinterestService: PinterestService by lazy {
        PinterestApiClient.instance
    }

    override fun onCreateView(
        inflater: LayoutInflater, container: ViewGroup?,
        savedInstanceState: Bundle?
    ): View {
        _binding = FragmentHomeBinding.inflate(inflater, container, false)
        return binding.root
    }

    override fun onViewCreated(view: View, savedInstanceState: Bundle?) {
        super.onViewCreated(view, savedInstanceState)
        setupUI()
    }

    private fun setupUI() {
        binding.HomeRes.adapter = adapter
    }
}