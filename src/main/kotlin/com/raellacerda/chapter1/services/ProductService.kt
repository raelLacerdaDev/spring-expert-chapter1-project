package com.raellacerda.chapter1.services


import com.raellacerda.chapter1.dtos.ProductDto
import com.raellacerda.chapter1.dtos.ProductRequestDto
import com.raellacerda.chapter1.entities.Product
import com.raellacerda.chapter1.mappers.toDto
import com.raellacerda.chapter1.repositories.CategoryRepository
import com.raellacerda.chapter1.repositories.ProductRepository
import com.raellacerda.chapter1.services.exceptions.DatabaseException
import com.raellacerda.chapter1.services.exceptions.ResourceNotFoundException
import jakarta.persistence.EntityNotFoundException
import org.springframework.dao.DataIntegrityViolationException
import org.springframework.data.domain.Pageable
import org.springframework.stereotype.Service
import org.springframework.transaction.annotation.Transactional

@Service
class ProductService(
    private val productRepository: ProductRepository,
    private val categoryRepository: CategoryRepository
) {

    @Transactional(readOnly = true)
    fun findAll(pageable: Pageable) = productRepository.findAll(pageable).map { it.toDto() }

    @Transactional(readOnly = true)
    fun findById(id: Long) = productRepository.findById(id).map { it.toDto() }.orElseThrow {
        ResourceNotFoundException("Product with $id Not Found")
    }

    @Transactional
    fun insert(dto: ProductRequestDto) : ProductDto {
        val newItem = Product(
            name = dto.name,
            description = dto.description,
            price = dto.price,
            imgUrl = dto.imgUrl,
        )
        dto.categories.forEach { category ->
            try {
                val categoryId = category.id
                val reference = categoryRepository.getReferenceById(categoryId)
                newItem.addCategory(reference)
            } catch (e: EntityNotFoundException) {
                throw ResourceNotFoundException("Category with ${category.id} Not Found")
            }
        }
        val product = productRepository.save(newItem)
        return product.toDto()
    }

    @Transactional
    fun update(id: Long, dto: ProductRequestDto): ProductDto {
        return try {
            val productReference = productRepository.getReferenceById(id)
            productReference.name = dto.name
            productReference.description = dto.description
            productReference.price = dto.price
            productReference.imgUrl = dto.imgUrl
            productReference.clearCategories()
            dto.categories.forEach { category ->
                try {
                    val categoryReference = categoryRepository.getReferenceById(category.id)
                    productReference.addCategory(categoryReference)
                } catch (e: EntityNotFoundException) {
                    throw ResourceNotFoundException("Category with ${category.id} Not Found")
                }
            }
            val updated = productRepository.save(productReference)
            updated.toDto()
        } catch (e: EntityNotFoundException) {
            throw ResourceNotFoundException("Product with $id not found")
        }
    }

    @Transactional
    fun delete(id: Long) {
        if (!productRepository.existsById(id)) throw ResourceNotFoundException("Product with $id Not Found")
        try {
            productRepository.deleteById(id)
        } catch (e: DataIntegrityViolationException) {
            throw DatabaseException("Data Integrity Violation")
        }

    }


}