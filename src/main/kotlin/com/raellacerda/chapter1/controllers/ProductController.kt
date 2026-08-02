package com.raellacerda.chapter1.controllers

import com.raellacerda.chapter1.services.ProductService
import org.springframework.data.domain.Pageable
import org.springframework.web.bind.annotation.GetMapping
import org.springframework.web.bind.annotation.PathVariable
import org.springframework.web.bind.annotation.RequestMapping
import org.springframework.web.bind.annotation.RequestParam
import org.springframework.web.bind.annotation.RestController


@RestController
@RequestMapping("/products")
class ProductController(
    private val productService: ProductService
) {

    @GetMapping
    fun findAll(pageable: Pageable) = productService.findAll(pageable)

    @GetMapping("/{id}")
    fun findById(@PathVariable id: Long) = productService.findById(id)

}