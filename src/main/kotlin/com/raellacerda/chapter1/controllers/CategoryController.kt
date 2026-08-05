package com.raellacerda.chapter1.controllers


import com.raellacerda.chapter1.dtos.CategoryDto
import com.raellacerda.chapter1.services.CategoryService
import jakarta.validation.Valid
import org.springframework.data.domain.Pageable
import org.springframework.http.ResponseEntity
import org.springframework.web.bind.annotation.*
import org.springframework.web.servlet.support.ServletUriComponentsBuilder


@RestController
@RequestMapping("/categories")
class CategoryController(
    private val categoryService: CategoryService
) {

    @GetMapping
    fun findAll(pageable: Pageable) = categoryService.findAll(pageable)

    @GetMapping("/{id}")
    fun findById(@PathVariable id: Long) : ResponseEntity<CategoryDto> {
        val dto = categoryService.findById(id)
        return ResponseEntity.ok(dto)
    }

    @PostMapping
    fun insert(@Valid @RequestBody categoryDto: CategoryDto): ResponseEntity<CategoryDto> {
        val item = categoryService.insert(categoryDto)
        val uri = ServletUriComponentsBuilder.fromCurrentRequest().path("/{id}")
            .buildAndExpand(item.id).toUri()
        return ResponseEntity.created(uri).body(item)
    }

    @PutMapping("/{id}")
    fun update(@Valid @RequestBody categoryDto: CategoryDto, @PathVariable id: Long): ResponseEntity<CategoryDto> {
        val dto = categoryService.update(id, categoryDto)
        return ResponseEntity.ok(dto)
    }

    @DeleteMapping("/{id}")
    fun delete(@PathVariable id: Long): ResponseEntity<Unit> {
        categoryService.delete(id)
        return ResponseEntity.noContent().build()
    }


}