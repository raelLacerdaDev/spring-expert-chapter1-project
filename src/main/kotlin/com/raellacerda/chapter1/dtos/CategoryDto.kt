package com.raellacerda.chapter1.dtos

import jakarta.validation.constraints.NotBlank
import jakarta.validation.constraints.Size

data class CategoryDto(
    val id: Long? = null,
    @field:NotBlank
    @field:Size(max = 255)
    val name: String
)