package com.gotor.gotor.util

import kotlin.random.Random

object MockUtils {
    fun getRandomValueInRange(min: Int, max: Int): Int {
        val randomMultiplier = Random.nextInt((max - min) / 1000 + 1)
        return min + randomMultiplier * 1000
    }
}