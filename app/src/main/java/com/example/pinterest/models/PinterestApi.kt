package com.example.pinterest.models

data class PinterestApi(
    val name: String,
    val length: String,
    val intelligence: String

) {
    companion object {
        fun toPins(pinterestApi: PinterestApi) = PinterestPins(
            name = pinterestApi.name,
            imageLink = null,
            length = null,
            origin = null
        )
    }
}