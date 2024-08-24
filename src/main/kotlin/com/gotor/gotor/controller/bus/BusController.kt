package com.gotor.gotor.controller.bus

import com.gotor.gotor.dto.bus.BusReservationRequest
import com.gotor.gotor.service.bus.BusService
import com.gotor.gotor.util.FileUtils
import org.apache.http.client.methods.HttpHead
import org.springframework.http.HttpHeaders
import org.springframework.http.MediaType
import org.springframework.http.ResponseEntity
import org.springframework.web.bind.annotation.GetMapping
import org.springframework.web.bind.annotation.PostMapping
import org.springframework.web.bind.annotation.RequestBody
import org.springframework.web.bind.annotation.ResponseBody
import org.springframework.web.bind.annotation.RestController

@RestController
class BusController(
    private val busService: BusService
) {

    @PostMapping("/api/bus/reservation")
    fun reserveBus(@RequestBody busRequest: BusReservationRequest): ResponseEntity<ByteArray> {
        val ticketImage = busService.makeBusReservation(busRequest)
        val fileName = FileUtils.generateFileNameWithDate("png")
        return ResponseEntity.ok()
            .header(HttpHeaders.CONTENT_DISPOSITION, "attachment; filename=\"$fileName\"")
            .contentType(MediaType.IMAGE_PNG)
            .body(ticketImage)
    }
}
