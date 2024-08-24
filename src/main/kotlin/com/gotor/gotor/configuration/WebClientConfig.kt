package com.gotor.gotor.configuration

import org.springframework.context.annotation.Bean
import org.springframework.context.annotation.Configuration
import org.springframework.web.reactive.function.client.WebClient

@Configuration
class WebClientConfig {

    @Bean
    fun sttClient(): WebClient {
        return WebClient.builder()
            .baseUrl("https://openai.com")
            .defaultHeader("Accept", "application/json")  // 기본 헤더 설정
            .build()

    }

    @Bean
    fun openaiClient(): WebClient {
        return WebClient.builder()
            .baseUrl("https://openai.com")
            .defaultHeader("Accept", "application/json")  // 기본 헤더 설정
            .build();

    }

    @Bean
    fun speechClient(): SpeechClient {
        return SpeechClient.create()
    }
}