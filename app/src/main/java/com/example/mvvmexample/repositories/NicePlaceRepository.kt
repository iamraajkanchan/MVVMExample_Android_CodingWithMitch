package com.example.mvvmexample.repositories

import com.example.mvvmexample.models.NicePlace

class NicePlaceRepository {
    private val dataSet = ArrayList<NicePlace>()

    companion object {
        private var nicePlaceRepository = NicePlaceRepository()
        fun getInstance(): NicePlaceRepository {
            return nicePlaceRepository
        }
    }

    // Pretend to get data from Web Service or Online Source
    fun getNicePlaces(): List<NicePlace> {
        setNicePlaces()
        return dataSet
    }

    private fun setNicePlaces() {
        dataSet.add(NicePlace("Trondheim", "https://i.redd.it/tpsnoz5bzo501.jpg"))
        dataSet.add(NicePlace("Portugal", "https://i.redd.it/qn7f9oqu7o501.jpg"))
        dataSet.add(
            NicePlace(
                "Rocky Mountain National Park",
                "https://i.redd.it/j6myfqglup501.jpg"
            )
        )
        dataSet.add(NicePlace("Havasu Falls", "https://i.redd.it/0h2gm1ix6p501.jpg"))
        dataSet.add(NicePlace("Mahahual", "https://i.redd.it/k98uzl68eh501.jpg"))
        dataSet.add(NicePlace("Austrailia", "https://i.redd.it/obx4zydshg601.jpg"))
    }
}