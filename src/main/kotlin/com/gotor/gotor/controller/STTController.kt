package com.gotor.gotor.controller

import com.gotor.gotor.service.STTApiClientService
import org.springframework.web.bind.annotation.GetMapping
import org.springframework.web.bind.annotation.RequestBody
import org.springframework.web.bind.annotation.RestController
import org.springframework.web.multipart.MultipartFile

@RestController
class STTController(
    private val sttApiClientService: STTApiClientService
) {

    @GetMapping("/api/v3/stt")
    fun hello(@RequestBody voice: MultipartFile): String {
        return "서울에서 속초로 가는걸 찾고 있습니다."
    }
}