package com.kotlin.restful.model

import java.util.*

data class ProductsResponse(
    val id: String,

    val name: String,

    val price: Long,

    val quantity: Int,

    val createdAt: Date,

    val updatedAt: Date?
)
