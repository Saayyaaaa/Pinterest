package com.example.pinterest.adapter

import android.view.LayoutInflater
import android.view.ViewGroup
import androidx.recyclerview.widget.ListAdapter
import androidx.recyclerview.widget.RecyclerView
import com.bumptech.glide.Glide
import com.example.pinterest.databinding.FragmentSearchItemsBinding
import com.example.pinterest.models.PinterestPins

class SearchAdapter (private val onImageClick: (String, String) -> Unit) :
    ListAdapter<PinterestPins, SearchAdapter.ViewHolder>(PinterestDiffUtil()) {

    override fun onCreateViewHolder(parent: ViewGroup, viewType: Int): ViewHolder {
        return ViewHolder(
            FragmentSearchItemsBinding.inflate(LayoutInflater.from(parent.context), parent, false)
        )
    }

    override fun onBindViewHolder(holder: ViewHolder, position: Int) {
        holder.bind(getItem(position))
    }


    inner class ViewHolder(private val binding: FragmentSearchItemsBinding) :
        RecyclerView.ViewHolder(binding.root) {

        private val context = binding.root.context

        fun bind(search: PinterestPins) {
            with(binding) {
                binding.imageTitle.text = search.name

                Glide.with(context)
                    .load(search.imageLink)
                    .into(itemImage)

                binding.itemImage.setOnClickListener {
                    search.imageLink?.let { imageUrl ->
                        search.name?.let { imageTitle ->
                            onImageClick(imageUrl, imageTitle)
                        }
                    }
                }
            }
        }

    }
}