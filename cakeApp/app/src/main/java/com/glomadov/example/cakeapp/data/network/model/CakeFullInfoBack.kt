package com.glomadov.example.cakeapp.data.network.model

import java.math.BigDecimal

data class CakeFullInfoBack(
    val id: Long?,
    val name: String,
    val calories: BigDecimal?,
    val image: String,
    val price: BigDecimal?,
    val weight: BigDecimal?,
    val compositions: String,
    val storageConditions: String?
) {
    companion object {
        fun emptyCakeFullInfoBack() = CakeFullInfoBack(
            null,
            "", null,
            "", null, null, "", ""
        )
    }
    }