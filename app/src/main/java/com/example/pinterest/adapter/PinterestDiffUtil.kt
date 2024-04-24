package com.example.pinterest.adapter

import androidx.recyclerview.widget.DiffUtil
import com.example.pinterest.models.ItemsForSearch

class PinterestDiffUtil: DiffUtil.ItemCallback<ItemsForSearch>() {
    override fun areItemsTheSame(oldItem: ItemsForSearch, newItem: ItemsForSearch): Boolean {
        TODO("Not yet implemented")
    }

    override fun areContentsTheSame(oldItem: ItemsForSearch, newItem: ItemsForSearch): Boolean {
        TODO("Not yet implemented")
    }

}