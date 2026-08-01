package com.raellacerda.chapter1.dtos

data class ProductDto(
    val id: Long? = null,
    val name: String,
    val description: String,
    val price: Double,
    val imgUrl: String,
    val categories: List<CategoryDto>
)
