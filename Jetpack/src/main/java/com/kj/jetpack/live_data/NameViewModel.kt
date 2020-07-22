package com.kj.jetpack.live_data

import androidx.lifecycle.MutableLiveData
import androidx.lifecycle.ViewModel

class NameViewModel : ViewModel() {

    // 用字符串创建一个LiveData
    val currentName: MutableLiveData<String> by lazy {
        MutableLiveData<String>()
    }

    // ViewModel的其余部分…
}
