package com.gotor.gotor.service.bus

import com.gotor.gotor.dto.bus.BusOptionResponse
import com.gotor.gotor.dto.bus.BusReservationRequest
import com.gotor.gotor.dto.openai.OpenAIBusDto
import com.gotor.gotor.dto.openai.toTmoneyBusRequest
import com.gotor.gotor.dto.tmoney.toBusOptionResponse
import com.gotor.gotor.service.tmoney.TmoneyClientService
import org.springframework.core.io.ClassPathResource
import org.springframework.stereotype.Service
import java.io.IOException

@Service
class BusServiceImpl(
    private val tmoneyService: TmoneyClientService
) : BusService {
    override fun getAllAvailableBusOption(openAIBusDto: OpenAIBusDto): List<BusOptionResponse> {
        val tmoneyBusResponse = tmoneyService.getAvailableBuses(openAIBusDto.toTmoneyBusRequest())
        return tmoneyBusResponse.map {
            it.toBusOptionResponse(openAIBusDto=openAIBusDto)
        }.toList()
    }

    override fun makeBusReservation(busReservationRequest: BusReservationRequest): ByteArray? {
        // TODO: Make Real reservation
        return try {
            val imgFile = ClassPathResource("static/ticket.png")
            imgFile.inputStream.readBytes()
        } catch (ex: IOException) {
            null
        }
    }
}
