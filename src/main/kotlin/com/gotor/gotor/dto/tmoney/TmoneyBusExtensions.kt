package com.gotor.gotor.dto.tmoney

import com.gotor.gotor.dto.bus.BusOptionResponse
import com.gotor.gotor.util.DateUtils
import com.gotor.gotor.util.MockUtils

fun SubResult.toBusOptionResponse() = BusOptionResponse(
    departTime = this.departTime,
    arrivalTime = DateUtils.addMinutesToHHMM(
        time = this.departTime,
        minutesToAdd = 240L),
    price = MockUtils.getRandomValueInRange(40000, 50000).toString()
)