package com.raellacerda.chapter1.services


import com.raellacerda.chapter1.dtos.CategoryDto
import com.raellacerda.chapter1.entities.Category
import com.raellacerda.chapter1.mappers.toDto
import com.raellacerda.chapter1.repositories.CategoryRepository
import com.raellacerda.chapter1.services.exceptions.DatabaseException
import com.raellacerda.chapter1.services.exceptions.ResourceNotFoundException
import jakarta.persistence.EntityNotFoundException
import org.springframework.dao.DataIntegrityViolationException
import org.springframework.data.domain.Pageable
import org.springframework.stereotype.Service
import org.springframework.transaction.annotation.Propagation
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

    @Transactional
    fun update(id: Long, categoryDto: CategoryDto): CategoryDto {
        return try {
            val reference = categoryRepository.getReferenceById(id)
            reference.name = categoryDto.name
            val updated = categoryRepository.save(reference)
            updated.toDto()
        } catch (_: EntityNotFoundException) {
            throw ResourceNotFoundException("Category with $id Not Found")
        }
    }

    @Transactional(propagation = Propagation.SUPPORTS)
    fun delete(id: Long) {
        if (!categoryRepository.existsById(id)) throw ResourceNotFoundException("Category with $id Not Found")
        try {
            categoryRepository.deleteById(id)
        } catch (_: DataIntegrityViolationException) {
            throw DatabaseException("Data integrity violation")
        }
    }

}