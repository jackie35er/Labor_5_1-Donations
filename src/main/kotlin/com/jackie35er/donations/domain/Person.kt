package com.jackie35er.donations.domain

import javax.persistence.*
import javax.validation.constraints.NotBlank

@Entity(name = "persons")
data class Person(
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    val id: Int?,

    @get:NotBlank
    @get:Column
    val firstName: String,

    @get:NotBlank
    @get:Column
    val lastName: String
) {
    override fun equals(other: Any?): Boolean {
        if (this === other) return true
        if (javaClass != other?.javaClass) return false

        other as Person

        if (id != other.id) return false

        return true
    }

    override fun hashCode(): Int {
        return id ?: 0
    }

    override fun toString(): String {
        return "Person(id=$id, firstName='$firstName', lastName='$lastName')"
    }
}
