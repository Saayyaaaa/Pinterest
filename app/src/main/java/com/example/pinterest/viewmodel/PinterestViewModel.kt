package com.example.pinterest.viewmodel

import androidx.lifecycle.LiveData
import androidx.lifecycle.MutableLiveData
import androidx.lifecycle.ViewModel
import com.example.pinterest.models.PinterestApi
import com.example.pinterest.models.PinterestApiResponse
import com.example.pinterest.models.PinterestPins
import com.example.pinterest.network.PinterestApiClient
import retrofit2.Call
import retrofit2.Callback
import retrofit2.Response

class PinterestViewModel : ViewModel() {

    private val _pinsList = MutableLiveData<ArrayList<PinterestPins>>(arrayListOf())
    val pinsList: LiveData<ArrayList<PinterestPins>> get() = _pinsList


    fun fetchPinsList() {
        val client = PinterestApiClient.instance
        val response = client.getPinsById()

    response.enqueue(object : Callback<PinterestApiResponse>{
        override fun onResponse(
            call: Call<PinterestApiResponse>,
            response: Response<PinterestApiResponse>
        ) {

            response.body()?.let { it ->
                _pinsList.value = ArrayList(it.results.map {
                    PinterestApi.toPins(it)
                })
            }

        }

        override fun onFailure(call: Call<PinterestApiResponse>, t: Throwable) {

        }

    })

    }



}