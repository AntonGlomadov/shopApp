package com.glomadov.example.cakeapp.ui.cake.list

import android.app.Application
import androidx.lifecycle.AndroidViewModel
import androidx.lifecycle.LiveData
import androidx.lifecycle.MutableLiveData
import androidx.lifecycle.viewModelScope
import com.glomadov.example.cakeapp.App
import com.glomadov.example.cakeapp.data.storage.StorageNetData
import kotlinx.coroutines.launch
import com.glomadov.example.cakeapp.ui.cake.list.adapter.CakeVM

class CakesVM(application: Application) : AndroidViewModel(application) {
    private val cakes: MutableLiveData<List<CakeVM>> = MutableLiveData()
    private val storageNetData = StorageNetData();

    init{
        loadCakes()
    }

    fun getCakes(): LiveData<List<CakeVM>> {
        return cakes
    }
    private fun loadCakes(){
        viewModelScope.launch {
            cakes.postValue(storageNetData.cakesList().map { CakeVM(getApplication<App>(), it) })
        }
    }
}