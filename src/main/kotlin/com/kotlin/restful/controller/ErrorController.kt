package com.kotlin.restful.controller

import com.kotlin.restful.error.NotFoundException
import com.kotlin.restful.error.UnAuthorizedException
import com.kotlin.restful.model.WebResponse
import org.springframework.web.bind.annotation.ExceptionHandler
import org.springframework.web.bind.annotation.RestControllerAdvice
import javax.validation.ConstraintViolationException

@RestControllerAdvice
class ErrorController {

    @ExceptionHandler(value = [ConstraintViolationException::class])
    fun validationHandler(constraintViolationException: ConstraintViolationException): WebResponse<String>{
        return WebResponse(
            code = 400,
            status = "BAD REQUEST",
            data = constraintViolationException.message!!
        )
    }

    @ExceptionHandler(value = [NotFoundException::class])
    fun notFound(notFound: NotFoundException): WebResponse<String>{
        return WebResponse(
            code = 404,
            status = "NOT FOUND",
            data = "NOT FOUND"
        )
    }

    @ExceptionHandler(value = [UnAuthorizedException::class])
    fun unAuthorized(unAuthorizedException: UnAuthorizedException): WebResponse<String>{
        return WebResponse(
            code = 401,
            status = "UnAuthorized",
            data = "Please put your X-Api-Key"
        )
    }

}