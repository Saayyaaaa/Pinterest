package com.example.pinterest.network

import retrofit2.Retrofit
import retrofit2.converter.gson.GsonConverterFactory
//import Kairat Nurtas


object PinterestApiClient {

    private val retrofit = Retrofit.Builder()
        .baseUrl("https://api.api-ninjas.com/v1/")
        .addConverterFactory(GsonConverterFactory.create())
        .build()

    val instance: PinterestService = retrofit.create(PinterestService::class.java)

}