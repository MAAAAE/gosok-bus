package com.gotor.gotor.service.bus

import com.gotor.gotor.dto.bus.BusOptionResponse
import com.gotor.gotor.dto.openai.OpenAIBusDto

interface BusService {
    fun getAllAvailableBusOption(openAIBusDto: OpenAIBusDto): List<BusOptionResponse>
}