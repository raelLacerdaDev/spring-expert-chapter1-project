package com.raellacerda.chapter1.controllers

import com.raellacerda.chapter1.services.ProductService
import org.springframework.web.bind.annotation.GetMapping
import org.springframework.web.bind.annotation.RequestMapping
import org.springframework.web.bind.annotation.RestController


@RestController
@RequestMapping("/products")
class ProductController(
    private val productService: ProductService
) {

    @GetMapping
    fun findAll() = productService.findAll()

}