package com.gotor.gotor.service.tmoney

import com.gotor.gotor.dto.tmoney.SubResult
import com.gotor.gotor.dto.tmoney.TmoneyBusRequest
import com.gotor.gotor.dto.tmoney.getMockData
import org.springframework.stereotype.Service

@Service
class TmoneyServiceImpl : TmoneyService {
    override fun getAvailableBuses(request: TmoneyBusRequest): List<SubResult> {
        return getMockData().response.subResultList
    }
}