package com.example.mvvmexample.viewmodels

import android.os.AsyncTask
import androidx.lifecycle.LiveData
import androidx.lifecycle.MutableLiveData
import androidx.lifecycle.ViewModel
import com.example.mvvmexample.MainActivity
import com.example.mvvmexample.models.NicePlace
import com.example.mvvmexample.repositories.NicePlaceRepository

class MainActivityViewModel : ViewModel() {
    private var mNicePlaces = MutableLiveData<List<NicePlace>>()
    private var mNicePlaceRepository: NicePlaceRepository = NicePlaceRepository.getInstance()
    private var mIsUpdating: MutableLiveData<Boolean> = MutableLiveData()

    fun initialize() {
        mNicePlaces = mNicePlaceRepository.getNicePlaces()
    }

    fun addNewValue(nicePlace: NicePlace) {
        mIsUpdating.value = true
    }

    fun getNicePlaces(): LiveData<List<NicePlace>> {
        return mNicePlaces
    }

}