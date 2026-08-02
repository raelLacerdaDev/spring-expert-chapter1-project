package com.raellacerda.chapter1.services


import com.raellacerda.chapter1.dtos.CategoryDto
import com.raellacerda.chapter1.entities.Category
import com.raellacerda.chapter1.mappers.toDto
import com.raellacerda.chapter1.repositories.CategoryRepository
import com.raellacerda.chapter1.services.exceptions.ResourceNotFoundException
import org.springframework.data.domain.Pageable
import org.springframework.stereotype.Service
import org.springframework.transaction.annotation.Transactional

@Service
class CategoryService(
    private val categoryRepository: CategoryRepository
) {

    @Transactional(readOnly = true)
    fun findAll(pageable: Pageable) = categoryRepository.findAll(pageable).map { it.toDto() }

    @Transactional(readOnly = true)
    fun findById(id: Long): CategoryDto = categoryRepository.findById(id).map { it.toDto() }.orElseThrow {
        ResourceNotFoundException("Category with $id Not Found")
    }

    @Transactional
    fun insert(categoryDto: CategoryDto) : CategoryDto {
        val newItem = Category(name = categoryDto.name)
        val category = categoryRepository.save(newItem)
        return category.toDto()
    }

}