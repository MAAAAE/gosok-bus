package com.gotor.gotor.dto.openai

data class OpenAIBusDto(
    val departDate: String,
    val departTime: String,
    val to: String,
    val from: String,
    val departOption: String = "0",
)
