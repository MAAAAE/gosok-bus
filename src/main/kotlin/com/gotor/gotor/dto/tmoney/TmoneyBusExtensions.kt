package com.gotor.gotor.dto.tmoney

import com.gotor.gotor.dto.bus.BusOptionResponse

fun SubResult.toBusOptionResponse() = BusOptionResponse(
    departTime = this.departTime,
    arrivalTime = this.departTime,
    price = this.ticketPay
)