package com.example.pinterest.network

import com.example.pinterest.models.PinterestPins
import retrofit2.Call
import retrofit2.http.GET
import retrofit2.http.Headers
import retrofit2.http.Query

interface PinterestService {

    @GET("cats")
    @Headers("X-Api-Key: wLrnkZ+qy6LvNHDs/NGNBQ==kTKUtCjVQgsgdfQP")



    fun getPinsById(): Call<PinterestPins>

    @GET("cats")
    @Headers("X-Api-Key: wLrnkZ+qy6LvNHDs/NGNBQ==kTKUtCjVQgsgdfQP")

    fun getCatsByName(@Query("name") name: String): Call<List<PinterestPins>>

}