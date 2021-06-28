package com.mtg.colorconverter

import androidx.lifecycle.MutableLiveData
import androidx.lifecycle.ViewModel
import androidx.lifecycle.liveData
import com.mtg.colorconverter.network.repository.NetworkRepository
import kotlinx.coroutines.Dispatchers

class MainViewModel : ViewModel() {

    /* */
    val redInput: MutableLiveData<String> = MutableLiveData()
    val red: Int get() = if (redInput.value != null) redInput.value!!.toInt() else 0

    /* */
    val greenInput: MutableLiveData<String> = MutableLiveData()
    val green: Int get() = if (greenInput.value != null) greenInput.value!!.toInt() else 0

    /* */
    val blueInput: MutableLiveData<String> = MutableLiveData()
    val blue: Int get() = if (blueInput.value != null) blueInput.value!!.toInt() else 0

    /* */
    private val repository = NetworkRepository()

    /** */
    fun convertRgbToHex(): String {
        return String.format("#%02x%02x%02x", red, green, blue)
    }

    /** */
    fun getTimestamp() = liveData(Dispatchers.IO) {
        val timestamp = repository.getTimestamp()
        emit(timestamp)
    }
}