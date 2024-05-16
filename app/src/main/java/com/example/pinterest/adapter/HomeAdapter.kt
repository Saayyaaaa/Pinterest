package com.example.pinterest.adapter

import android.view.LayoutInflater
import android.view.ViewGroup
import androidx.recyclerview.widget.ListAdapter
import androidx.recyclerview.widget.RecyclerView
import com.bumptech.glide.Glide
import com.example.pinterest.databinding.FragmentHomeItemsBinding
import com.example.pinterest.models.PinterestPins


class HomeAdapter(private val onImageClick: (String, String) -> Unit) :
    ListAdapter<PinterestPins, HomeAdapter.ViewHolder>(PinterestDiffUtil()) {


    override fun onCreateViewHolder(parent: ViewGroup, viewType: Int): ViewHolder {
        return ViewHolder(
            FragmentHomeItemsBinding.inflate(LayoutInflater.from(parent.context), parent, false)
        )
    }

    override fun onBindViewHolder(holder: ViewHolder, position: Int) {
        holder.bind(getItem(position))
    }


    inner class ViewHolder(
        private val binding: FragmentHomeItemsBinding
    ) : RecyclerView.ViewHolder(binding.root) {


        private val context = binding.root.context

        fun bind(homePin: PinterestPins) {

            binding.pinTxtHome.text = homePin.name

            Glide.with(context)
                .load(homePin.imageLink)
                .into(binding.pinImgHome)

            binding.pinImgHome.setOnClickListener {
                homePin.imageLink?.let { imageUrl ->
                    homePin.name?.let { imageName ->
                        onImageClick(imageUrl, imageName)
                    }
                }
            }
        }

    }
}