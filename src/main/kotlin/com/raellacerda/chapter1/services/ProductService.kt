package com.raellacerda.chapter1.services

import com.raellacerda.chapter1.dtos.ProductDto
import com.raellacerda.chapter1.mappers.toDto
import com.raellacerda.chapter1.repositories.ProductRepository
import org.springframework.data.domain.Page
import org.springframework.data.domain.Pageable
import org.springframework.stereotype.Service
import org.springframework.transaction.annotation.Transactional

@Service
class ProductService(
    private val productRepository: ProductRepository
) {

    @Transactional(readOnly = true)
    fun findAll(pageable: Pageable) = productRepository.findAll(pageable).map { it.toDto() }


}