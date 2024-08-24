package com.gotor.gotor.util

import java.time.LocalDateTime
import java.time.format.DateTimeFormatter

object FileUtils {
    private val formatter = DateTimeFormatter.ofPattern("yyyy-MM-dd_HH-mm-ss")

    // 현재 날짜를 기반으로 파일 이름 생성
    fun generateFileNameWithDate(extension: String): String {
        val currentDateTime = LocalDateTime.now()
        val formattedDate = currentDateTime.format(formatter)
        return "$formattedDate.$extension"
    }
}