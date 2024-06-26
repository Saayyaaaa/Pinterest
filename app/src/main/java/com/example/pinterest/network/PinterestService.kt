package com.example.pinterest.network

import com.example.pinterest.models.PinterestPins
import retrofit2.Response
import retrofit2.http.GET
import retrofit2.http.Headers
import retrofit2.http.Query

interface PinterestService {


    @GET("cats")
    @Headers("X-Api-Key: wLrnkZ+qy6LvNHDs/NGNBQ==kTKUtCjVQgsgdfQP")

    suspend fun getCatsByName(@Query("name") name: String): Response<List<PinterestPins>>

    @GET("cats")
    @Headers("X-Api-Key: wLrnkZ+qy6LvNHDs/NGNBQ==kTKUtCjVQgsgdfQP")

    suspend fun fetchDataList(@Query("name") name: String): Response<List<PinterestPins>>



}