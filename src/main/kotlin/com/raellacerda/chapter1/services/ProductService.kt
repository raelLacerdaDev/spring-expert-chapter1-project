package com.raellacerda.chapter1.services

import com.raellacerda.chapter1.mappers.toDto
import com.raellacerda.chapter1.repositories.ProductRepository
import com.raellacerda.chapter1.services.exceptions.ResourceNotFoundException
import org.springframework.data.domain.Pageable
import org.springframework.stereotype.Service
import org.springframework.transaction.annotation.Transactional

@Service
class ProductService(
    private val productRepository: ProductRepository
) {

    @Transactional(readOnly = true)
    fun findAll(pageable: Pageable) = productRepository.findAll(pageable).map { it.toDto() }

    @Transactional(readOnly = true)
    fun findById(id: Long) = productRepository.findById(id).map { it.toDto() }.orElseThrow {
        ResourceNotFoundException("Category with $id Not Found")
    }

}