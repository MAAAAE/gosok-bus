package com.gotor.gotor.service.llm

import com.gotor.gotor.dto.openai.OpenAIBusDto
import org.springframework.stereotype.Service
import org.springframework.web.reactive.function.client.WebClient

@Service
class LLMApiClientServiceImpl(
    private val openaiClient: WebClient
) : LLMApiClientService {
    override fun parseText(text: String): OpenAIBusDto =
        openaiClient.get()
            .uri("/parse/{question}", text)
            .retrieve()
            .bodyToMono(OpenAIBusDto::class.java)
            .block() ?: throw RuntimeException("파싱 실패!")

}