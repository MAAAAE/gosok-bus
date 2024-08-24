package com.gotor.gotor.controller.stt

import com.gotor.gotor.dto.bus.BusOptionResponse
import com.gotor.gotor.dto.openai.OpenAIBusDto
import com.gotor.gotor.service.bus.BusService
import com.gotor.gotor.service.stt.SttApiClientService
import io.swagger.v3.oas.annotations.tags.Tag
import org.slf4j.Logger
import org.slf4j.LoggerFactory
import org.springframework.http.ResponseEntity
import org.springframework.web.bind.annotation.PostMapping
import org.springframework.web.bind.annotation.RequestParam
import org.springframework.web.bind.annotation.RestController
import org.springframework.web.multipart.MultipartFile

@Tag(name = "STT API", description = "음성파일을 인식해서 결괏값 반환")
@RestController
class SttController(
    private val sttApiClientService: SttApiClientService,
    private val busService: BusService
) {
    private val logger: Logger = LoggerFactory.getLogger(SttController::class.java)


    @PostMapping("/api/bus/available")
    fun hello(@RequestParam voice: MultipartFile): ResponseEntity<List<BusOptionResponse>> {
        logger.info("[speech to text] API 호출됨.")
        val text = sttApiClientService.toText(voice)
        val mockRequest = OpenAIBusDto(
            departDate = "20180101",
            departTime = "1100",
            to = "서울경부",
            from = "부산",
            departOption = "0"
        )
        return ResponseEntity.ok(busService.getAllAvailableBusOption(mockRequest))
    }
}