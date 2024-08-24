package com.gotor.gotor.service.bus

import com.gotor.gotor.dto.bus.BusOptionResponse
import com.gotor.gotor.dto.openai.OpenAIBusDto
import com.gotor.gotor.dto.openai.toTmoneyBusRequest
import com.gotor.gotor.dto.tmoney.toBusOptionResponse
import com.gotor.gotor.service.tmoney.TmoneyService
import org.springframework.stereotype.Service

@Service
class BusServiceImpl(
    private val tmoneyService: TmoneyService
): BusService {
    override fun getAllAvailableBusOption(openAIBusDto: OpenAIBusDto): List<BusOptionResponse> {
        val tmoneyBusResponse = tmoneyService.getAvailableBuses(openAIBusDto.toTmoneyBusRequest())
        return tmoneyBusResponse.map {
            it.toBusOptionResponse()
        }.toList()
    }
}
