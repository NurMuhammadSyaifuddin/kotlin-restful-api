package com.kotlin.restful.config

import com.kotlin.restful.entity.ApiKey
import com.kotlin.restful.repository.ApiKeyRepository
import org.springframework.boot.ApplicationArguments
import org.springframework.boot.ApplicationRunner
import org.springframework.stereotype.Component

@Component
class ApiKeyConfiguration(val apiKeyRepository: ApiKeyRepository) : ApplicationRunner{

    val apiKey = "secret"

    override fun run(args: ApplicationArguments?) {
        if (!apiKeyRepository.existsById(apiKey)){
            val data = ApiKey(apiKey)
            apiKeyRepository.save(data)
        }
    }
}