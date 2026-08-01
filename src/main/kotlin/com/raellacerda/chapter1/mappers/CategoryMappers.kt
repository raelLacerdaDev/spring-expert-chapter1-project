package com.raellacerda.chapter1.mappers

import com.raellacerda.chapter1.dtos.CategoryDto
import com.raellacerda.chapter1.entities.Category

fun Category.toDto(): CategoryDto = CategoryDto(
    id = this.id,
    name = this.name,
)