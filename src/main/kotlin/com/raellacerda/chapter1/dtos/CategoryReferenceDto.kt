package com.raellacerda.chapter1.dtos

import jakarta.validation.constraints.NotNull

data class CategoryReferenceDto(
    @field:NotNull(message = "Id is required!")
    val id: Long
)