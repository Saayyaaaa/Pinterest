package com.example.pinterest.fragments

import android.os.Bundle
import android.text.Editable
import android.text.TextWatcher
import androidx.fragment.app.Fragment
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import com.example.pinterest.adapter.SearchAdapter
import com.example.pinterest.databinding.FragmentSearchBinding
import com.example.pinterest.models.PinterestPins
import com.example.pinterest.network.PinterestApiClient
import retrofit2.Call
import retrofit2.Callback
import retrofit2.Response



class SearchFragment : Fragment() {

    private var _binding: FragmentSearchBinding? = null
    private val binding get() = _binding!!

    private val adapter: SearchAdapter by lazy {
        SearchAdapter()
    }

    private val pinterestService = PinterestApiClient.instance


    override fun onCreateView(
        inflater: LayoutInflater, container: ViewGroup?,
        savedInstanceState: Bundle?
    ): View {
        _binding = FragmentSearchBinding.inflate(inflater, container, false)
        return binding.root
    }

    override fun onViewCreated(view: View, savedInstanceState: Bundle?) {
        super.onViewCreated(view, savedInstanceState)
        setupUI()
        setupSearch()
    }

    private fun setupUI() {
        binding.SearchRes.adapter = adapter
    }


    private fun setupSearch() {
        binding.search.addTextChangedListener(object : TextWatcher {
            override fun beforeTextChanged(s: CharSequence?, start: Int, count: Int, after: Int) {}

            override fun onTextChanged(s: CharSequence?, start: Int, before: Int, count: Int) {
                searchForItems(s.toString())
            }

            override fun afterTextChanged(s: Editable?) {}
        })
    }

    private fun searchForItems(query: String) {
        pinterestService.getCatsByName(query).enqueue(object : Callback<List<PinterestPins>> {
            override fun onResponse(
                call: Call<List<PinterestPins>>,
                response: Response<List<PinterestPins>>
            ) {
                if (response.isSuccessful) {
                    val pins = response.body()
                    pins?.let {
                        adapter.submitList(it)
                    }

                } else {
                    TODO()
                }

            }

            override fun onFailure(call: Call<List<PinterestPins>>, t: Throwable) {
                TODO("Not yet implemented")
            }

        })
    }


}