package com.example.aiapi

import android.app.Application
import android.util.Log
import androidx.lifecycle.AndroidViewModel
import androidx.lifecycle.LiveData
import androidx.lifecycle.MutableLiveData

class SharedViewModel (application: Application):AndroidViewModel(application){
    private val _foodData = MutableLiveData<Pair<String, String>>()
    val foodData: LiveData<Pair<String, String>> get() = _foodData

    fun setFoodData(image: String, name: String) {
        Log.d("datav", "${image} ")
        Log.d("SharedViewModel", "setFoodData called with image: $image and name: $name")
        _foodData.value = Pair(image, name)
    }
}