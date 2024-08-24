package com.gotor.gotor.util

import java.time.LocalTime
import java.time.format.DateTimeFormatter

object DateUtils {
    fun addMinutesToHHMM(time: String, minutesToAdd: Long): String {
        val formatter = DateTimeFormatter.ofPattern("HHmm")
        val localTime = LocalTime.parse(time, formatter)

        val updatedTime = localTime.plusMinutes(minutesToAdd)
        return updatedTime.format(formatter)
    }
}