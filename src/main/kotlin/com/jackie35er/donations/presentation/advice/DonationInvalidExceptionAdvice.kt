package com.jackie35er.donations.presentation.advice

import com.jackie35er.donations.presentation.exception.DonationInvalidException
import org.springframework.http.HttpHeaders
import org.springframework.http.HttpStatus
import org.springframework.http.ResponseEntity
import org.springframework.web.bind.annotation.ControllerAdvice
import org.springframework.web.bind.annotation.ExceptionHandler
import org.springframework.web.context.request.WebRequest
import org.springframework.web.servlet.mvc.method.annotation.ResponseEntityExceptionHandler

@ControllerAdvice
class DonationInvalidExceptionAdvice : ResponseEntityExceptionHandler() {
    @ExceptionHandler(value = [DonationInvalidException::class])
    fun handleEntityNotFoundException(exception: Exception, request: WebRequest): ResponseEntity<Any> {
        return handleExceptionInternal(exception, exception.message, HttpHeaders(), HttpStatus.BAD_REQUEST, request)
    }
}