package com.gotor.gotor.dto.openai

import com.gotor.gotor.dto.tmoney.TmoneyBusRequest

fun OpenAIBusDto.toTmoneyBusRequest() = TmoneyBusRequest(
    timDte = this.departDate,
    timTim = this.departTime,
    terFr = this.from,
    terTo = this.to,
    calFlg = "0",
    jobDiv = this.departOption,
    busGra = "1"
)