package com.example.pinterest.adapter

import android.view.ViewGroup
import androidx.recyclerview.widget.ListAdapter
import androidx.recyclerview.widget.RecyclerView
import com.bumptech.glide.Glide
import com.example.pinterest.databinding.FragmentSearchItemsBinding
import com.example.pinterest.models.PinterestPins


class HomeAdapter :
    ListAdapter<PinterestPins, HomeAdapter.ViewHolder>(PinterestDiffUtil()) {


    override fun onCreateViewHolder(parent: ViewGroup, viewType: Int): HomeAdapter.ViewHolder {
        TODO("Not yet implemented")
    }

    override fun onBindViewHolder(holder: HomeAdapter.ViewHolder, position: Int) {
        TODO("Not yet implemented")
    }


    inner class ViewHolder(private val binding: FragmentSearchItemsBinding) :
        RecyclerView.ViewHolder(binding.root) {

        private val context = binding.root.context

        fun bind(search: PinterestPins) {
            with(binding) {
                searchTitle.text = search.name
                Glide.with(context)
                    .load(search.imageLink)
                    .into(itemImage)
            }
        }

    }
}