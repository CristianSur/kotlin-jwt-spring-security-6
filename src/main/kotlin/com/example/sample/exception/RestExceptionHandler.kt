package com.example.sample.exception

import org.slf4j.Logger
import org.slf4j.LoggerFactory
import org.springframework.http.HttpStatus.*
import org.springframework.security.authentication.BadCredentialsException
import org.springframework.web.bind.annotation.ExceptionHandler
import org.springframework.web.bind.annotation.ResponseStatus
import org.springframework.web.bind.annotation.RestControllerAdvice

@RestControllerAdvice
class RestExceptionHandler {

    val log: Logger = LoggerFactory.getLogger(RestExceptionHandler::class.java.name)

    @ExceptionHandler
    @ResponseStatus(CONFLICT)
    fun handleRegisteredException(e: RegisteredException): ResponseError {
        log.error(e.message, e)
        return ResponseError.ALREADY_REGISTERED
    }

    @ExceptionHandler
    @ResponseStatus(UNAUTHORIZED)
    fun handleBadCredentialsException(e: BadCredentialsException): ResponseError {
        log.error(e.message, e)
        return ResponseError.BAD_CREDENTIALS
    }
}

class RegisteredException : Exception()