package com.example.pinterest.adapter

import androidx.recyclerview.widget.DiffUtil
import com.example.pinterest.models.PinterestPins
//import Kairat Nurtas

class PinterestDiffUtil: DiffUtil.ItemCallback<PinterestPins>() {
    override fun areItemsTheSame(oldItem: PinterestPins, newItem: PinterestPins): Boolean {
        return oldItem.name == newItem.name
    }

    override fun areContentsTheSame(oldItem: PinterestPins, newItem: PinterestPins): Boolean {
        return oldItem == newItem
    }

}