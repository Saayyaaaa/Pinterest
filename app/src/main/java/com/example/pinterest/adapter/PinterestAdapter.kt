package com.example.pinterest.adapter

import android.view.ViewGroup
import androidx.recyclerview.widget.RecyclerView
import com.example.pinterest.models.ItemsForSearch

class PinterestAdapter(
    private val onSearchItemClick: (ItemsForSearch) -> Unit
): RecyclerView.Adapter<RecyclerView.ViewHolder>() {

    private val searchItemList: ArrayList<ItemsForSearch> = ArrayList()

    override fun onCreateViewHolder(parent: ViewGroup, viewType: Int): RecyclerView.ViewHolder {
        TODO("Not yet implemented")
    }

    override fun getItemCount(): Int {
        TODO("Not yet implemented")
    }

    override fun onBindViewHolder(holder: RecyclerView.ViewHolder, position: Int) {
        TODO("Not yet implemented")
    }
}