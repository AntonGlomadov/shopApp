package com.glomadov.example.cakeapp.data.network.services

import retrofit2.Response
import retrofit2.http.GET
import retrofit2.http.Path
import com.glomadov.example.cakeapp.data.network.model.CakeFullInfoBack
import com.glomadov.example.cakeapp.data.network.model.CakesListBack

internal interface CakesServiceApi {

    @GET("cakes")
    suspend fun getCakes(): Response<CakesListBack>

    @GET("cake/{id}")
    suspend fun getCake(@Path("id") id : Long) : Response<CakeFullInfoBack>

}