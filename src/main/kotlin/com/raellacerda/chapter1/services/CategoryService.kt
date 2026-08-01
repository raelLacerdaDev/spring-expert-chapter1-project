package com.raellacerda.chapter1.services

import com.raellacerda.chapter1.dtos.CategoryDto
import com.raellacerda.chapter1.mappers.toDto
import com.raellacerda.chapter1.repositories.CategoryRepository
import org.springframework.stereotype.Service
import org.springframework.transaction.annotation.Transactional

@Service
class CategoryService(
    private val categoryRepository: CategoryRepository
) {

    @Transactional(readOnly = true)
    fun findAll() : List<CategoryDto> = categoryRepository.findAll().map { it.toDto() }

}