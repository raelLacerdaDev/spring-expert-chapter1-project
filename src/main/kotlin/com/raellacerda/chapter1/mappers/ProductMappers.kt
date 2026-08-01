package com.raellacerda.chapter1.mappers

import com.raellacerda.chapter1.dtos.ProductDto
import com.raellacerda.chapter1.entities.Product

fun Product.toDto(): ProductDto = ProductDto(
    id = this.id,
    name = this.name,
    description = this.description,
    price = this.price,
    imgUrl = this.imgUrl,
)