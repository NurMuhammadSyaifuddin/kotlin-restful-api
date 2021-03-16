package com.kotlin.restful.service

import com.kotlin.restful.model.CreateProductRequest
import com.kotlin.restful.model.ListProductRequest
import com.kotlin.restful.model.ProductsResponse
import com.kotlin.restful.model.UpdateProductRequest

interface ProductsService {

    fun create(createProductRequest: CreateProductRequest): ProductsResponse

    fun get(id: String): ProductsResponse

    fun update(id: String, updateProductRequest: UpdateProductRequest): ProductsResponse

    fun delete(id: String)

    fun list(listProductRequest: ListProductRequest): List<ProductsResponse>
}