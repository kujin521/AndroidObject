package com.kj.jetpack.live_data.liveData_2

import androidx.lifecycle.LiveData
import androidx.lifecycle.MutableLiveData
import androidx.lifecycle.ViewModel

class MainViewModel(countReserved:Int): ViewModel() {

    private val _counter=MutableLiveData<Int>()

    val counter: LiveData<Int>
        get() = _counter


    init {
        _counter.value=countReserved
    }

    fun plusOne(){
        val count=_counter.value?:0
        _counter.value=count+1
    }

    fun clear(){
        _counter.value=0
    }
}