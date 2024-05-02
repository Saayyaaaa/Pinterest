package com.example.pinterest.models

data class PinterestApiResponse(
    val page: Int,
    val results: List<PinterestApi>
)
