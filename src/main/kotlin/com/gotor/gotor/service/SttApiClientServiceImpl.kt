package com.gotor.gotor.service

import org.springframework.stereotype.Service
import org.springframework.web.multipart.MultipartFile
import org.springframework.web.reactive.function.client.WebClient

@Service
class SttApiClientServiceImpl(
    private val sttClient: WebClient
): SttApiClientService {


    override fun toText(voice: MultipartFile): String {
        return "서울에서 속초로 오늘 제일 빠른 버스"
    }
}