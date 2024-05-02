package com.example.pinterest.network

import com.example.pinterest.models.ItemsForSearch
import retrofit2.http.GET
import retrofit2.http.Headers

interface PinterestService {

    @GET("cats?name=a")
    @Headers("X-Api-Key: wLrnkZ+qy6LvNHDs/NGNBQ==kTKUtCjVQgsgdfQP")



    suspend fun fetchCelebrityList(): ItemsForSearch

}