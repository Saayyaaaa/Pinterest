package com.example.pinterest.models

import com.google.gson.annotations.SerializedName

data class PinterestPins(
    val name: String? = null,
    @SerializedName("image_link") val imageLink: String? = null,
    val length: String? = null,
    val origin: String? = null


)
