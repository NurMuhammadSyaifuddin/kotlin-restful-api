package com.kotlin.restful.service.impl

import com.kotlin.restful.entity.Product
import com.kotlin.restful.error.NotFoundException
import com.kotlin.restful.model.CreateProductRequest
import com.kotlin.restful.model.ListProductRequest
import com.kotlin.restful.model.ProductsResponse
import com.kotlin.restful.model.UpdateProductRequest
import com.kotlin.restful.repository.ProductsRepository
import com.kotlin.restful.service.ProductsService
import com.kotlin.restful.validation.ValidationUtil
import org.springframework.data.domain.PageRequest
import org.springframework.data.repository.findByIdOrNull
import org.springframework.stereotype.Service
import java.util.*
import java.util.stream.Collector
import java.util.stream.Collectors
import kotlin.streams.toList

@Service
class ProductServiceImpl(
    val productsRepository: ProductsRepository,
    val validationUtil: ValidationUtil
) : ProductsService {
    override fun create(createProductRequest: CreateProductRequest): ProductsResponse {
        validationUtil.validate(createProductRequest)

        val product = Product(
            id = createProductRequest.id!!,
            name = createProductRequest.name!!,
            price = createProductRequest.price!!,
            quantity = createProductRequest.quantity!!,
            createdAt = Date(),
            updatedAt = null
        )

        productsRepository.save(product)

        return convertProductToProductResponse(product)

    }

    override fun get(id: String): ProductsResponse {
        val product = findProductByIdOrNotFound(id)
        return convertProductToProductResponse(product)
    }

    override fun update(id: String, updateProductRequest: UpdateProductRequest): ProductsResponse {
        val product = findProductByIdOrNotFound(id)

        validationUtil.validate(updateProductRequest)

        product.apply {
            name = updateProductRequest.name!!
            price = updateProductRequest.price!!
            quantity = updateProductRequest.quantity!!
            updatedAt = Date()
        }

        productsRepository.save(product)

        return convertProductToProductResponse(product)

    }

    override fun delete(id: String) {
        val product = findProductByIdOrNotFound(id)
        productsRepository.delete(product)
    }

    override fun list(listProductRequest: ListProductRequest): List<ProductsResponse> {
        val page = productsRepository.findAll(PageRequest.of(listProductRequest.page, listProductRequest.size))
        val products: List<Product> = page.get().collect(Collectors.toList())
        return products.map { convertProductToProductResponse(it) }
    }

    private fun findProductByIdOrNotFound(id: String): Product {
        val product = productsRepository.findByIdOrNull(id)
        if (product == null) {
            throw NotFoundException()
        } else {
            return product
        }
    }

    private fun convertProductToProductResponse(product: Product): ProductsResponse {
        return ProductsResponse(
            id = product.id,
            name = product.name,
            price = product.price,
            quantity = product.quantity,
            createdAt = product.createdAt,
            updatedAt = product.updatedAt
        )
    }

}