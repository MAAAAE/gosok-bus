package com.gotor.gotor.service.stt

import org.springframework.web.multipart.MultipartFile

interface SttApiClientService {
    fun toText(voice: MultipartFile): String
}