package com.glomadov.example.cakeapp.data.network.services

import retrofit2.Response
import com.glomadov.example.cakeapp.data.network.model.CakeFullInfoBack
import com.glomadov.example.cakeapp.data.network.model.CakesListBack

internal class CakesService(
    private val apiService: CakesServiceApi
) {

    suspend fun getCakes(): Response<CakesListBack> = apiService.getCakes()
    suspend fun getCake(id: Long): Response<CakeFullInfoBack> = apiService.getCake(id)
}