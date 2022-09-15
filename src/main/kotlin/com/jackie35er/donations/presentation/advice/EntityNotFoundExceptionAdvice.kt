package com.jackie35er.donations.presentation.advice

import org.springframework.http.HttpHeaders
import org.springframework.http.HttpStatus
import org.springframework.http.ResponseEntity
import org.springframework.web.bind.annotation.ControllerAdvice
import org.springframework.web.bind.annotation.ExceptionHandler
import org.springframework.web.client.HttpStatusCodeException
import org.springframework.web.context.request.WebRequest
import org.springframework.web.servlet.mvc.method.annotation.ResponseEntityExceptionHandler
import java.lang.Exception
import javax.persistence.EntityNotFoundException

@ControllerAdvice
class EntityNotFoundExceptionAdvice: ResponseEntityExceptionHandler() {

    @ExceptionHandler(value = [EntityNotFoundException::class])
    fun handleEntityNotFoundException(exception: Exception, request: WebRequest): ResponseEntity<Any>{
        return handleExceptionInternal(exception,exception.message, HttpHeaders() ,HttpStatus.NOT_FOUND, request)
    }
}