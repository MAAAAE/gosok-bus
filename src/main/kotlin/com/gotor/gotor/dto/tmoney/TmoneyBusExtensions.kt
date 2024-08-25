package com.gotor.gotor.dto.tmoney

import com.gotor.gotor.dto.bus.BusOptionResponse
import com.gotor.gotor.dto.openai.OpenAIBusDto
import com.gotor.gotor.util.DateUtils
import com.gotor.gotor.util.MockUtils

fun SubResult.toBusOptionResponse(openAIBusDto: OpenAIBusDto) = BusOptionResponse(
    departTime = this.departTime,
    arrivalTime = DateUtils.addMinutesToHHMM(
        time = this.departTime,
        minutesToAdd = 240L),
    price = MockUtils.getRandomValueInRange(40000, 50000).toString(),
    from = openAIBusDto.from,
    to = openAIBusDto.to
)