package com.kotlin.restful.repository

import com.kotlin.restful.entity.Product
import org.springframework.data.jpa.repository.JpaRepository

interface ProductsRepository : JpaRepository<Product, String>