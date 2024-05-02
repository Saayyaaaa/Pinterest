package com.example.pinterest.network


import com.example.pinterest.models.PinterestApiResponse
import com.example.pinterest.models.PinterestPins
import retrofit2.Call
import retrofit2.http.GET
import retrofit2.http.Headers

interface PinterestService {

    @GET("cats?name=a")
    @Headers("X-Api-Key: wLrnkZ+qy6LvNHDs/NGNBQ==kTKUtCjVQgsgdfQP")




    fun getPinsById(): Call<PinterestApiResponse>

    suspend fun getPinsById(): PinterestPins


}