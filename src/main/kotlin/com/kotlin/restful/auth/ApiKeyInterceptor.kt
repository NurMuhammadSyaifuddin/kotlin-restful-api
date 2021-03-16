package com.kotlin.restful.auth

import com.kotlin.restful.error.UnAuthorizedException
import com.kotlin.restful.repository.ApiKeyRepository
import org.springframework.stereotype.Component
import org.springframework.ui.ModelMap
import org.springframework.web.context.request.WebRequest
import org.springframework.web.context.request.WebRequestInterceptor
import java.lang.Exception

@Component
class ApiKeyInterceptor(val apiKeyRepository: ApiKeyRepository): WebRequestInterceptor {
    override fun preHandle(request: WebRequest) {
        val apiKey = request.getHeader("X-Api-Key") ?: throw UnAuthorizedException()

        if (!apiKeyRepository.existsById(apiKey)) throw UnAuthorizedException()

        // valid

    }

    override fun postHandle(request: WebRequest, model: ModelMap?) {
        // Nothing
    }

    override fun afterCompletion(request: WebRequest, ex: Exception?) {
        // Nothing
    }
}