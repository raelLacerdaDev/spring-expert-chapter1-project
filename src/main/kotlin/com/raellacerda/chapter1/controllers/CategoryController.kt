package com.raellacerda.chapter1.controllers


import com.raellacerda.chapter1.services.CategoryService
import org.springframework.web.bind.annotation.GetMapping
import org.springframework.web.bind.annotation.RequestMapping
import org.springframework.web.bind.annotation.RestController


@RestController
@RequestMapping("/categories")
class CategoryController(
    private val categoryService: CategoryService
) {

    @GetMapping
    fun findAll() = categoryService.findAll()

}