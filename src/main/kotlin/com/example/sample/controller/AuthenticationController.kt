package com.example.sample.controller

import com.example.sample.model.authentication.AuthenticationRequest
import com.example.sample.model.authentication.RegisterRequest
import com.example.sample.service.UserService
import org.springframework.http.ResponseEntity
import org.springframework.web.bind.annotation.PostMapping
import org.springframework.web.bind.annotation.RequestBody
import org.springframework.web.bind.annotation.RequestMapping
import org.springframework.web.bind.annotation.RestController


@RestController
@RequestMapping("/auth")
class AuthenticationController(
    private val userService: UserService,
) {

    @PostMapping("/register")
    fun register(@RequestBody registerRequest: RegisterRequest) =
        ResponseEntity.ok(userService.register(registerRequest))


    @PostMapping("/authenticate")
    fun authenticate(@RequestBody authenticationRequest: AuthenticationRequest) =
        ResponseEntity.ok(userService.authenticate(authenticationRequest))

}
