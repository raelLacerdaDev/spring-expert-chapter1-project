package com.raellacerda.chapter1.entities

import jakarta.persistence.Entity
import jakarta.persistence.GeneratedValue
import jakarta.persistence.GenerationType
import jakarta.persistence.Id

@Entity
class Category(
    @Id @GeneratedValue(strategy = GenerationType.AUTO)
    val id: Long? = null,
    val name: String,
) {
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
}