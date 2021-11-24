package com.glomadov.example.cakeapp.data.storage

import com.glomadov.example.cakeapp.model.Cake
import com.glomadov.example.cakeapp.data.network.AppNetwork
import com.glomadov.example.cakeapp.data.network.model.CakeFullInfoBack
import com.glomadov.example.cakeapp.model.CakeFullInfo
import kotlinx.coroutines.CoroutineDispatcher
import kotlinx.coroutines.Dispatchers
import kotlinx.coroutines.withContext

class StorageNetData(
    private val defaultDispatcher: CoroutineDispatcher = Dispatchers.IO
) {
    private val cakesService = AppNetwork.cakesService

    suspend fun cakesList(): List<Cake> = withContext(defaultDispatcher){
        val response = cakesService.getCakes()
        val cakeList = if(response.isSuccessful){
            response.body()?.cake_list ?: listOf()
        } else listOf()

        cakeList.map{
            with(it){ Cake(id, name, calories?.toDouble(), image, price?.toDouble(), weight?.toDouble()) }
        }
    }

    suspend fun cake(id: Long): CakeFullInfo = withContext(defaultDispatcher){
        val response = cakesService.getCake(id)
        val cake = if(response.isSuccessful){
            response.body() ?: CakeFullInfoBack.emptyCakeFullInfoBack()
        } else CakeFullInfoBack.emptyCakeFullInfoBack()
        var cakeFullInfo: CakeFullInfo
        cake.apply {
            cakeFullInfo = CakeFullInfo(id, name, calories?.toDouble(), image, price?.toDouble(), weight?.toDouble(), compositions, storageConditions)
        }
        cakeFullInfo
    }
}