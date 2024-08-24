package com.gotor.gotor.controller

import org.springframework.web.bind.annotation.GetMapping
import org.springframework.web.bind.annotation.RestController

@RestController
class ExampleController {
    @GetMapping("/get")
    fun hello(): String = "hello"
}