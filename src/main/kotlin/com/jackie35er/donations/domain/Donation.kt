package com.jackie35er.donations.domain

import java.time.LocalDate
import javax.persistence.*
import javax.validation.constraints.Min
import javax.validation.constraints.NotNull
import javax.validation.constraints.PastOrPresent

@Entity(name = "donations")
data class Donation(
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    val id: Int?,

    @ManyToOne
    val person: Person,

    @Min(value = 5)
    @NotNull
    val amount: Int,

    @PastOrPresent
    val depositDate: LocalDate
)
