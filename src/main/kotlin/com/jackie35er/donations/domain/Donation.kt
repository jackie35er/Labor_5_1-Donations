package com.jackie35er.donations.domain

import org.hibernate.Hibernate
import java.time.LocalDate
import javax.persistence.*
import javax.validation.constraints.Min
import javax.validation.constraints.PastOrPresent

@Entity(name = "donations")
data class Donation(
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    val id: Int?,

    @ManyToOne
    val person: Person,

    @Min(value = 5)
    val amount: Int,

    @PastOrPresent
    val depositDate: LocalDate
) {
    override fun equals(other: Any?): Boolean {
        if (this === other) return true
        if (other == null || Hibernate.getClass(this) != Hibernate.getClass(other)) return false
        other as Donation

        return id != null && id == other.id
    }

    override fun hashCode(): Int = javaClass.hashCode()
    override fun toString(): String {
        return "Donation(id=$id, person=$person, amount=$amount, depositDate=$depositDate)"

    }

}
