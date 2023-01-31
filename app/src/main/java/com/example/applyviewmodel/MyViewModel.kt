package com.example.applyviewmodel

import androidx.lifecycle.LiveData
import androidx.lifecycle.MutableLiveData
import androidx.lifecycle.SAVED_STATE_REGISTRY_OWNER_KEY
import androidx.lifecycle.SavedStateHandle
import androidx.lifecycle.Transformations
import androidx.lifecycle.ViewModel
import com.example.applyviewmodel.databinding.ActivityMainBinding

class MyViewModel(
    _counter : Int,
    private val repositoryImpl: MyRepositoryImpl,
    private val savedStateHandle: SavedStateHandle
    ): ViewModel() {
//    var counter : Int = _counter
        var counterFromRepository : LiveData<Int> = repositoryImpl.getCounter()

        fun increaseCounter() {
            repositoryImpl.increaseCounter()
        }

        var counter: Int = savedStateHandle.get<Int>(SAVE_STATE_KEY) ?: _counter

        var liveCounter : MutableLiveData<Int> = MutableLiveData(_counter)
        val modifiedCounter : LiveData<String> = Transformations.map(liveCounter) { counter ->
            "$counter 입니다"
        }

        val hasChecked : MutableLiveData<Boolean> = MutableLiveData<Boolean>(false)


    fun saveState() {
        savedStateHandle.set(SAVE_STATE_KEY, counter)
    }

    companion object {
        private const val SAVE_STATE_KEY = "counter"
    }

}
