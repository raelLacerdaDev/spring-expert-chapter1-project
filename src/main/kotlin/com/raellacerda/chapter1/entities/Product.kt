package com.raellacerda.chapter1.entities

import jakarta.persistence.Entity
import jakarta.persistence.GeneratedValue
import jakarta.persistence.GenerationType
import jakarta.persistence.Id

@Entity
class Product(
    @Id @GeneratedValue(strategy = GenerationType.AUTO)
    val id: Long? = null,
    val name: String,
    val description: String,
    val price: Double,
    val imgUrl: String,
) {
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
}