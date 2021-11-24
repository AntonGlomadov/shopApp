package com.glomadov.example.cakeapp.data.network.model

import java.math.BigDecimal

data class CakeBack(
    val id: Long?,
    val name: String,
    val calories: BigDecimal?,
    val image: String,
    val price: BigDecimal?,
    val weight: BigDecimal?
) {
}