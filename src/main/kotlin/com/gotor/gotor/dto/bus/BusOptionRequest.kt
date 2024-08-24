package com.gotor.gotor.dto.bus

data class BusOptionRequest(
    val departDate: String,
    val departTime: String,
    val from: String,
    val to: String,
    val timeOption: String,
)
