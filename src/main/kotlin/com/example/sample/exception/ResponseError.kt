package com.example.sample.exception

import com.fasterxml.jackson.annotation.JsonFormat

@JsonFormat(shape = JsonFormat.Shape.OBJECT)
enum class ResponseError(val status: Int, val message: String) {

    ALREADY_REGISTERED(1000, "Already registered"),

    BAD_CREDENTIALS(1001, "Bad credentials")
}

