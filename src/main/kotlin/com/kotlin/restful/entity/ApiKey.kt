package com.kotlin.restful.entity

import javax.persistence.Entity
import javax.persistence.Id
import javax.persistence.Table

@Entity
@Table(name = "apiKeys")
data class ApiKey(
    @Id
    val id: String
)
