package com.example.pinterest.viewmodel

import androidx.lifecycle.LiveData
import androidx.lifecycle.MutableLiveData
import androidx.lifecycle.ViewModel
import androidx.lifecycle.viewModelScope
import com.example.pinterest.models.PinterestPins
import com.example.pinterest.network.PinterestApiClient
import kotlinx.coroutines.Dispatchers
import kotlinx.coroutines.launch
import kotlinx.coroutines.withContext

class PinterestViewModel : ViewModel() {

    private val _pinsList = MutableLiveData<PinterestPins>()
    val pinsList: LiveData<PinterestPins> get() = _pinsList


    fun fetchPinsList() {
        viewModelScope.launch {
            try {
                val pins = getPins()
                _pinsList.value = pins
            } catch (e: Exception) {
                // Handle error
            }
        }
    }

    private suspend fun getPins(): PinterestPins {
        return withContext(Dispatchers.IO) {
            val client = PinterestApiClient.instance
            client.getPinsById()
        }
    }


}