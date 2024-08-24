package com.gotor.gotor.controller.stt

import com.gotor.gotor.service.stt.SttApiClientService
import io.swagger.v3.oas.annotations.tags.Tag
import org.slf4j.Logger
import org.slf4j.LoggerFactory
import org.springframework.web.bind.annotation.PostMapping
import org.springframework.web.bind.annotation.RequestParam
import org.springframework.web.bind.annotation.RestController
import org.springframework.web.multipart.MultipartFile

@Tag(name = "Example API", description = "This API provides examples of different operations.")
@RestController
class SttController(
    private val sttApiClientService: SttApiClientService
) {
    private val logger: Logger = LoggerFactory.getLogger(SttController::class.java)


    @PostMapping("/api/stt")
    fun hello(@RequestParam voice: MultipartFile): String {
        logger.info("[speech to text] API 호출됨.")
        return sttApiClientService.toText(voice)
    }
}