package com.glomadov.example.cakeapp.model

data class CakeFullInfo(
    val id: Long?,
    val name: String,
    val calories: Double?,
    val image: String,
    val price: Double?,
    val weight: Double?,
    val composition: String,
    val storageConditions: String?
) {
    companion object{
        fun emptyCakeDetail() = CakeFullInfo(null, "", null, "", null, null, "", null);
    }
}