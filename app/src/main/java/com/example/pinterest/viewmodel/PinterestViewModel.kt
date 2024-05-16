package com.example.pinterest.viewmodel

import androidx.lifecycle.MutableLiveData
import androidx.lifecycle.ViewModel
import androidx.lifecycle.viewModelScope
import com.example.pinterest.models.PinterestPins
import com.example.pinterest.network.PinterestApiClient
import kotlinx.coroutines.Dispatchers
import kotlinx.coroutines.launch
import kotlinx.coroutines.withContext
//import Kairat Nurtas

class PinterestViewModel : ViewModel() {

    private val _pinsList = MutableLiveData<List<PinterestPins>>()
    val pinsList: MutableLiveData<List<PinterestPins>> get() = _pinsList


    fun fetchPinsList(name: String) {
        viewModelScope.launch {
            try {
                val pins = getPins(name)
                _pinsList.postValue(pins)
            } catch (e: Exception) {
                // Handle error
                e.printStackTrace()
            }
        }
    }

    private suspend fun getPins(name: String): List<PinterestPins> {
        return withContext(Dispatchers.IO) {
            val client = PinterestApiClient.instance
            val response = client.getCatsByName(name)
            if (response.isSuccessful) {
                response.body() ?: emptyList()
            } else {
                emptyList()
            }
        }
    }


}