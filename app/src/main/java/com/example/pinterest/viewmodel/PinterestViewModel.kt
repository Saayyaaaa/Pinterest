package com.example.pinterest.viewmodel

import androidx.lifecycle.LiveData
import androidx.lifecycle.MutableLiveData
import androidx.lifecycle.ViewModel
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

    response.enqueue(object : Callback<PinterestPins>{
        override fun onResponse(
            call: Call<PinterestPins>,
            response: Response<PinterestPins>
        ) {

            response.body()?.let {
                _pinsList.value = arrayListOf()
            }

        }

        override fun onFailure(call: Call<PinterestPins>, t: Throwable) {

        }

    })

    }



}