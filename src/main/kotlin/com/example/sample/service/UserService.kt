package com.example.sample.service

import com.example.sample.entity.UserEntity
import com.example.sample.model.authentication.AuthenticationRequest
import com.example.sample.model.authentication.AuthenticationResponse
import com.example.sample.model.authentication.RegisterRequest
import com.example.sample.repository.UserRepository
import com.example.sample.security.JwtService
import org.springframework.security.authentication.AuthenticationManager
import org.springframework.security.authentication.UsernamePasswordAuthenticationToken
import org.springframework.security.crypto.password.PasswordEncoder
import org.springframework.stereotype.Service


@Service
class UserService(
    private val userRepository: UserRepository,
    private val passwordEncoder: PasswordEncoder,
    private val jwtService: JwtService,
    private val authenticationManager: AuthenticationManager
) {
    fun register(registerRequest: RegisterRequest): AuthenticationResponse {

        if (userRepository.findByUsernameOrEmail(registerRequest.username, registerRequest.email) != null) {
            throw Exception("Email or Username are already registered")
        }

        val user = UserEntity(
            0,
            registerRequest.email,
            registerRequest.username,
            passwordEncoder.encode(registerRequest.password)
        )

        userRepository.save(user)

        val token = jwtService.generateToken(user)

        return AuthenticationResponse(token)
    }

    fun authenticate(authenticationRequest: AuthenticationRequest): AuthenticationResponse {

        this.authenticationManager.authenticate(
            UsernamePasswordAuthenticationToken(
                authenticationRequest.username,
                authenticationRequest.password
            )
        )

        val user = userRepository.findByUsername(authenticationRequest.username)

        return AuthenticationResponse(jwtService.generateToken(user))
    }
}
