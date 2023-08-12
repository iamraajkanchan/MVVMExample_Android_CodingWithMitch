package com.example.mvvmexample.viewmodels

import androidx.lifecycle.LiveData
import androidx.lifecycle.MutableLiveData
import androidx.lifecycle.ViewModel
import com.example.mvvmexample.models.NicePlace
import com.example.mvvmexample.repositories.NicePlaceRepository

class MainActivityViewModel : ViewModel() {
    private val _nicePlaces: MutableLiveData<List<NicePlace>> = MutableLiveData()
    val nicePlaces: LiveData<List<NicePlace>> get() = _nicePlaces
    private var repository: NicePlaceRepository = NicePlaceRepository.getInstance()
    private var mIsUpdating: MutableLiveData<Boolean> = MutableLiveData()

    init {
        _nicePlaces.value = repository.getNicePlaces()
    }

    fun addNewValue(nicePlace: NicePlace) {
        mIsUpdating.value = true
    }

}