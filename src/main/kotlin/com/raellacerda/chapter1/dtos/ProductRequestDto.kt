package com.raellacerda.chapter1.dtos

import jakarta.validation.constraints.NotBlank
import jakarta.validation.constraints.PositiveOrZero
import jakarta.validation.constraints.Size
import org.hibernate.validator.constraints.URL

data class ProductRequestDto(
    val id: Long? = null,

    @field:NotBlank
    @field:Size(max = 255)
    val name: String,

    @field:NotBlank
    @field:Size(max = 2600)
    val description: String,

    @field:PositiveOrZero
    val price: Double,

    @field:URL
    @field:Size(max = 2083)
    val imgUrl: String,
    val categories: List<CategoryReferenceDto>
)