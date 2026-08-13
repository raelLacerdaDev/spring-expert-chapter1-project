package com.raellacerda.chapter1.repositories


import com.raellacerda.chapter1.entities.Product
import org.junit.jupiter.api.Assertions.assertEquals
import org.springframework.beans.factory.annotation.Autowired
import org.springframework.boot.data.jpa.test.autoconfigure.DataJpaTest
import kotlin.test.Test
import kotlin.test.assertFalse
import kotlin.test.assertTrue

@DataJpaTest
//@TestConstructor(autowireMode = TestConstructor.AutowireMode.ALL)
class ProductRepositoriesTests @Autowired constructor(
    private val productRepository: ProductRepository
) {

    val existingId = 1L
    val notExistId = 10000L

    @Test
    fun deleteShouldDeleteObjectWhenIdExists() {

        productRepository.deleteById(existingId)

        val check = productRepository.existsById(existingId)

        assertFalse(check)
    }

    @Test
    fun deleteShouldDoNothingWhenIdDoesNotExist() {

        val dataCountBefore = productRepository.count()

        productRepository.deleteById(notExistId)

        val dataCountAfter = productRepository.count()

        assertEquals(dataCountBefore, dataCountAfter)

    }

    @Test
    fun postShouldIncrementDataCount() {
        val dataCountBefore = productRepository.count()
        val item = Product(
            name = "New Product",
            description =  "this is a new product",
            price = 0.0,
            imgUrl = "www.example.com",
        )
        productRepository.save(item)
        val dataCountAfter = productRepository.count()

        assertEquals(dataCountBefore + 1, dataCountAfter)

    }

    @Test
    fun findByIdShouldReturnCorrectProductWhenIdExist() {
        val product = productRepository.findById(existingId)
        assertTrue(product.isPresent)
    }

    @Test
    fun findByIdShouldReturnEmptyWhenIdDoesNotExist() {
        val product = productRepository.findById(notExistId)
        assertTrue(product.isEmpty)

    }



}