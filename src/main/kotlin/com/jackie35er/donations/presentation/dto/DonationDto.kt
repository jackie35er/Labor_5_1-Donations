package com.jackie35er.donations.presentation.dto

import java.time.LocalDate
import javax.validation.constraints.Min
import javax.validation.constraints.PastOrPresent

data class DonationDto(
    @get:Min(value = 5)
    val amount: Int,

    @get:PastOrPresent
    val depositDate: LocalDate
)