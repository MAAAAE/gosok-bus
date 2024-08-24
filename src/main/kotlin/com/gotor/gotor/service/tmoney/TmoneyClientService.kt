package com.gotor.gotor.service.tmoney

import com.gotor.gotor.dto.tmoney.SubResult
import com.gotor.gotor.dto.tmoney.TmoneyBusRequest

interface TmoneyClientService {
    fun getAvailableBuses(request: TmoneyBusRequest): List<SubResult>
}