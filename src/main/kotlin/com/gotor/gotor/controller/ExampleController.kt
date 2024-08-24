package com.gotor.gotor.controller

import com.gotor.gotor.dto.bus.BusOptionResponse
import com.gotor.gotor.dto.openai.OpenAIBusDto
import com.gotor.gotor.service.bus.BusService
import org.springframework.web.bind.annotation.GetMapping
import org.springframework.web.bind.annotation.RestController

@RestController
class ExampleController(
    private val busService: BusService
) {
    @GetMapping("/get")
    fun hello(): List<BusOptionResponse> {
        val mockRequest = OpenAIBusDto(
            departDate = "20180101",
            departTime = "1100",
            to = "서울경부",
            from = "부산",
            departOption = "0"
        )
        return busService.getAllAvailableBusOption(mockRequest)
    }
}