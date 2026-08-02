package com.raellacerda.chapter1.services


import com.raellacerda.chapter1.dtos.ProductDto
import com.raellacerda.chapter1.dtos.ProductInsertDto
import com.raellacerda.chapter1.entities.Product
import com.raellacerda.chapter1.mappers.toDto
import com.raellacerda.chapter1.repositories.CategoryRepository
import com.raellacerda.chapter1.repositories.ProductRepository
import com.raellacerda.chapter1.services.exceptions.ResourceNotFoundException
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
        ResourceNotFoundException("Category with $id Not Found")
    }

    @Transactional
    fun insert(dto: ProductInsertDto) : ProductDto {
        val newItem = Product(
            name = dto.name,
            description = dto.description,
            price = dto.price,
            imgUrl = dto.imgUrl,
        )
        dto.categories.forEach { category ->
            val categoryId = category.id
            val reference = categoryRepository.getReferenceById(categoryId)
            newItem.addCategory(reference)
        }
        val product = productRepository.save(newItem)
        return product.toDto()
    }

}