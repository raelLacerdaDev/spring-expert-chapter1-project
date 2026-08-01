package com.raellacerda.chapter1.repositories

import com.raellacerda.chapter1.entities.Category
import org.springframework.data.jpa.repository.JpaRepository
import org.springframework.stereotype.Repository

@Repository
interface CategoryRepository : JpaRepository<Category, Long> {
}