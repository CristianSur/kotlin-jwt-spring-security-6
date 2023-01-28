package com.example.sample.controller

import org.springframework.http.ResponseEntity
import org.springframework.web.bind.annotation.GetMapping
import org.springframework.web.bind.annotation.RestController


@RestController
class GreetingController {

    @GetMapping("/home")
    fun greet(): ResponseEntity<String> = ResponseEntity.ok("Hello, welcome to secured endpoint.")

}
