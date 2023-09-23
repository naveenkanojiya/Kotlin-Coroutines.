package com.example.coroutines

import android.util.Log
import androidx.lifecycle.ViewModel
import androidx.lifecycle.viewModelScope
import kotlinx.coroutines.delay
import kotlinx.coroutines.launch

private val TAG: String = "KOTLINFUN"

class MainViewModel :ViewModel(){

    init {
        viewModelScope.launch {
            while (true){
                delay(500)
                Log.d(TAG,"Hello From Naveen Android")
            }
        }
    }

    override fun onCleared() {
        super.onCleared()
        Log.d(TAG,"View Model Destroy")
    }
}