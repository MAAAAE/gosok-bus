package com.gotor.gotor.service

import org.springframework.web.multipart.MultipartFile

interface SttApiClientService {
    fun toText(voice: MultipartFile): String
}