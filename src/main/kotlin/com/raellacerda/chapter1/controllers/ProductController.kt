package com.raellacerda.chapter1.controllers

import com.raellacerda.chapter1.dtos.ProductDto
import com.raellacerda.chapter1.dtos.ProductInsertDto
import com.raellacerda.chapter1.services.ProductService
import jakarta.validation.Valid
import org.springframework.data.domain.Pageable
import org.springframework.http.ResponseEntity
import org.springframework.web.bind.annotation.GetMapping
import org.springframework.web.bind.annotation.PathVariable
import org.springframework.web.bind.annotation.PostMapping
import org.springframework.web.bind.annotation.RequestBody
import org.springframework.web.bind.annotation.RequestMapping
import org.springframework.web.bind.annotation.RestController
import org.springframework.web.servlet.support.ServletUriComponentsBuilder


@RestController
@RequestMapping("/products")
class ProductController(
    private val productService: ProductService,
) {

    @GetMapping
    fun findAll(pageable: Pageable) = productService.findAll(pageable)

    @GetMapping("/{id}")
    fun findById(@PathVariable id: Long) : ResponseEntity<ProductDto> {
        val dto = productService.findById(id)
        return ResponseEntity.ok(dto)
    }

    @PostMapping
    fun create(@Valid @RequestBody dto: ProductInsertDto): ResponseEntity<ProductDto> {
        val newItem = productService.insert(dto)
        val uri = ServletUriComponentsBuilder.fromCurrentRequest().path("/{id}")
            .buildAndExpand(newItem.id).toUri()
        return ResponseEntity.created(uri).body(newItem)
    }

}