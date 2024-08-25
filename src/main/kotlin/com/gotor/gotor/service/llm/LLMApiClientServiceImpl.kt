package com.gotor.gotor.service.llm

import com.gotor.gotor.common.exception.GotorException
import com.gotor.gotor.dto.openai.OpenAIBusDto
import org.springframework.stereotype.Service
import org.springframework.web.reactive.function.client.WebClient
import org.springframework.web.reactive.function.client.WebClientResponseException

@Service
class LLMApiClientServiceImpl(
    private val openaiClient: WebClient
) : LLMApiClientService {
    override fun parseText(text: String): OpenAIBusDto {
        if (text.isBlank()) {
            throw GotorException("파싱할 text가 없습니다.")
        }

        return runCatching {
            openaiClient.get()
                .uri("/parse/{question}", text)
                .retrieve()
                .bodyToMono(OpenAIBusDto::class.java)
                .block()
        }.getOrElse { throwable ->
            // 특정 예외 유형에 따라 다르게 처리할 수 있음
            when (throwable) {
                is WebClientResponseException -> {
                    throw GotorException("API 호출 실패: ${throwable.statusCode}", throwable)
                }
                else -> {
                    throw GotorException("파싱 실패! text: $text", throwable)
                }
            }
        } ?: throw GotorException("파싱 실패! text: $text") // null일 경우
    }

}