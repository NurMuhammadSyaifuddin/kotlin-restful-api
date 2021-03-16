package com.kotlin.restful.controller

import com.kotlin.restful.model.*
import com.kotlin.restful.service.ProductsService
import org.springframework.web.bind.annotation.*

@RestController
class ProductController(val productsService: ProductsService) {

    @PostMapping(
        value = ["/api/products"],
        produces = ["application/json"],
        consumes = ["application/json"]
    )
    fun createProduct(@RequestBody body: CreateProductRequest): WebResponse<ProductsResponse>{
        val productResponse = productsService.create(body)

        return convertProductResponseToWebResponse(productResponse)
    }

    @GetMapping(
        value = ["/api/products/{idProduct}"]
    )
    fun getProduct(@PathVariable("idProduct") id: String): WebResponse<ProductsResponse>{
        val productsResponse = productsService.get(id)

        return convertProductResponseToWebResponse(productsResponse)
    }

    @PutMapping(
        value = ["/api/products/{idProduct}"],
        produces = ["application/json"],
        consumes = ["application/json"]
    )
    fun updateProduct(
        @PathVariable("idProduct") id: String,
        @RequestBody updateProductRequest: UpdateProductRequest
    ): WebResponse<ProductsResponse>{
        val productResponse = productsService.update(id, updateProductRequest)

        return convertProductResponseToWebResponse(productResponse)
    }

    @DeleteMapping(
        value = ["/api/products/{idProduct}"],
        produces = ["application/json"]
    )
    fun deleteProduct(@PathVariable("idProduct") id: String): WebResponse<String>{
        productsService.delete(id)
        return WebResponse(
            code = 200,
            status = "OK",
            data = "DELETED $id"
        )
    }

    private fun convertProductResponseToWebResponse(productResponse: ProductsResponse): WebResponse<ProductsResponse> =
        WebResponse(
            code = 200,
            status = "OK",
            data = productResponse
        )

    @GetMapping(
        value = ["/api/products"],
        produces = ["application/json"]
    )
    fun listProducts(
        @RequestParam(value = "size", defaultValue = "10") size: Int,
        @RequestParam(value = "page", defaultValue = "0") page: Int
    ): WebResponse<List<ProductsResponse>>{
        val request = ListProductRequest(size, page)
        val responses = productsService.list(request)
        return WebResponse(
            code = 200,
            status = "OK",
            data = responses
        )
    }

}