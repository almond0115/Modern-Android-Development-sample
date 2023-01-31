package com.example.applyviewmodel

import androidx.lifecycle.LiveData
import androidx.lifecycle.MutableLiveData

class MyRepositoryImpl(counter: Int) : MyRepository {
    // 이 부분은 실제로 room or retrofit 받아 오게 됨
    private val liveCounter = MutableLiveData<Int>(counter)

    override fun getCounter(): LiveData<Int> {
        return liveCounter
    }

    override fun increaseCounter() {
        liveCounter.value = liveCounter.value?.plus(1)
    }
}