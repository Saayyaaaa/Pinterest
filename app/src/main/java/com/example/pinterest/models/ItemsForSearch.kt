package com.example.pinterest.models

import android.health.connect.datatypes.units.Length
import com.google.gson.annotations.SerializedName

data class ItemsForSearch(
    val name: String? = null,
    @SerializedName("image_link") val imageLink: String? = null,
    val length: String? = null,
    val origin: String? = null


)
