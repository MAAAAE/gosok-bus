package com.gotor.gotor.service.llm

import com.gotor.gotor.dto.openai.OpenAIBusDto

interface LLMApiClientService {
    fun parseText(text: String): OpenAIBusDto
}