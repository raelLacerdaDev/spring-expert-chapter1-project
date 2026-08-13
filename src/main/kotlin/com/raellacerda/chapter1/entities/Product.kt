package com.raellacerda.chapter1.entities

import jakarta.persistence.Column
import jakarta.persistence.Entity
import jakarta.persistence.EntityListeners
import jakarta.persistence.GeneratedValue
import jakarta.persistence.GenerationType
import jakarta.persistence.Id
import jakarta.persistence.JoinColumn
import jakarta.persistence.JoinTable
import jakarta.persistence.ManyToMany
import jakarta.persistence.PreUpdate
import org.springframework.data.annotation.CreatedDate
import org.springframework.data.annotation.LastModifiedDate
import org.springframework.data.jpa.domain.support.AuditingEntityListener
import java.time.Instant

@Entity
@EntityListeners(AuditingEntityListener::class)
class Product(
    @Id @GeneratedValue(strategy = GenerationType.IDENTITY)
    val id: Long? = null,
    var name: String,
    @Column(length = 2600)
    var description: String,
    var price: Double,
    var imgUrl: String,
    @CreatedDate
    @Column(nullable = false, updatable = false)
    var createdAt: Instant? = null,
    @LastModifiedDate
    @Column(nullable = false)
    var updatedAt: Instant? = null,

    @ManyToMany
    @JoinTable(
        name = "product_categories",
        joinColumns = [JoinColumn(name = "product_id")],
        inverseJoinColumns = [JoinColumn(name = "category_id")]
    )
    private val _categories: MutableSet<Category> = mutableSetOf(),
) {
    val categories get() = _categories.toList()

    override fun toString(): String {
        return "Product(id:$id, name:$name, description:$description, price:$price, imgUrl:$imgUrl)"
    }
    override fun equals(other: Any?): Boolean {
        if (this === other) return true
        if(other !is Product) return false
        return id == other.id
    }
    override fun hashCode(): Int {
        return id?.hashCode() ?: 0
    }

    fun addCategory(category: Category) {
        _categories.add(category)
//        category.addProduct(this) - discutir sobre isso
    }

    fun removeCategory(category: Category) {
        _categories.remove(category)
//        category.removeProduct(this)
    }

    fun clearCategories() {
        _categories.clear()
    }

}