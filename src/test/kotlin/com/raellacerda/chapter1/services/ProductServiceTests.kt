package com.raellacerda.chapter1.services

import com.raellacerda.chapter1.dtos.CategoryDto
import com.raellacerda.chapter1.dtos.CategoryReferenceDto
import com.raellacerda.chapter1.dtos.ProductDto
import com.raellacerda.chapter1.dtos.ProductRequestDto
import com.raellacerda.chapter1.repositories.CategoryRepository
import com.raellacerda.chapter1.repositories.ProductRepository
import com.raellacerda.chapter1.services.exceptions.DatabaseException
import com.raellacerda.chapter1.services.exceptions.ResourceNotFoundException
import org.junit.jupiter.api.assertDoesNotThrow
import org.junit.jupiter.api.assertNotNull
import org.junit.jupiter.api.assertThrows
import org.junit.jupiter.api.extension.ExtendWith
import org.mockito.InjectMocks
import org.mockito.Mock
import org.mockito.Mockito
import org.mockito.Mockito.times
import org.mockito.Mockito.verify
import org.mockito.junit.jupiter.MockitoExtension
import org.springframework.data.domain.PageRequest
import kotlin.test.Test
import kotlin.test.assertTrue


@ExtendWith(MockitoExtension::class)
class ProductServiceTests {
    @Mock
    private lateinit var productRepository: ProductRepository

    @Mock
    private lateinit var categoryRepository: CategoryRepository

    @InjectMocks
    private lateinit var productService: ProductService

    val existingId = 1L
    val doesNotExistId = 200L
    val dependentId = 2L

    val dto = ProductRequestDto(
        name = "Dto Mocked",
        description = "lorem ipsum dolor sit amet consectetur adipiscing elit.",
        price = 100.0,
        imgUrl = "https://www.example.com/in/img-b4a064397/",
        categories = listOf(CategoryReferenceDto(1)),
    )

    @Test
    fun deleteShouldDoNothingWhenIdExists() {
        assertDoesNotThrow {
            productService.delete(existingId)
        }

        verify(productRepository, times(1)).deleteById(existingId)
    }

    @Test
    fun deleteShouldThrowExceptionWhenIdNotExists() {
        Mockito.`when`(productRepository.existsById(doesNotExistId)).thenReturn(false)
        assertThrows <ResourceNotFoundException> {
            productService.delete(doesNotExistId)
        }
    }

    @Test // nao tem como ter error de integridade nesse projeto mas e para treinar
    fun deleteShouldThrowExceptionWhenDependentId() {
        Mockito.`when`(productRepository.existsById(dependentId)).thenReturn(true)
        assertThrows<DatabaseException> {
            productService.delete(dependentId)
        }
    }

    @Test
    fun findAllShouldReturnPage() {
        val page = PageRequest.of(0, 10)
        val productPage = productService.findAll(page)

        assertNotNull(productPage)
        verify(productRepository, times(1)).findAll(page)

    }

    @Test
    fun findByIdShouldReturnProductDtoWhenIdExists() {
        val productDto = productService.findById(existingId)
        assertTrue(productDto is ProductDto)
        verify(productRepository, times(1)).findById(existingId)
    }

    @Test
    fun findByIdShouldThrowExceptionWhenIdNotExists() {
        assertThrows <ResourceNotFoundException> {
            productService.findById(doesNotExistId)
        }
        verify(productRepository).findById(doesNotExistId)
    }


    @Test
    fun updateShouldReturnProductDtoWhenIdExists() {
        val productDto = productService.update(existingId, dto)
        verify(productRepository).getReferenceById(existingId)
    }

    @Test
    fun updateShouldThrowExceptionWhenIdDoesNotExists() {
        assertThrows <ResourceNotFoundException> {
            productService.update(doesNotExistId, dto)
        }
        verify(productRepository).getReferenceById(doesNotExistId)

    }


}