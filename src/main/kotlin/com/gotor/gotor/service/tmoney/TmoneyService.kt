package com.gotor.gotor.service.tmoney

import com.gotor.gotor.dto.tmoney.SubResult
import com.gotor.gotor.dto.tmoney.TmoneyBusRequest

interface TmoneyService {
    fun getAvailableBuses(request: TmoneyBusRequest): List<SubResult>
}