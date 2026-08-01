package com.raellacerda.chapter1.entities

import jakarta.persistence.Entity
import jakarta.persistence.GeneratedValue
import jakarta.persistence.GenerationType
import jakarta.persistence.Id
import jakarta.persistence.ManyToMany

@Entity
class Category(
    @Id @GeneratedValue(strategy = GenerationType.IDENTITY)
    val id: Long? = null,
    val name: String,

    @ManyToMany(mappedBy = "_categories")
    private val _products: MutableSet<Product> = mutableSetOf(),
) {
    val products get() = _products.toList()

    override fun toString(): String {
        return "Category(id=$id, name='$name')"
    }
    override fun equals(other: Any?): Boolean {
        if (this === other) return true
        if(other !is Category) return false
        return id == other.id
    }
    override fun hashCode(): Int {
        return id?.hashCode() ?: 0
    }

    internal fun addProduct(product: Product) {
        _products.add(product)
    }
    internal fun removeProduct(product: Product) {
        _products.remove(product)
    }
}