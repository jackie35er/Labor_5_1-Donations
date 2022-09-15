package com.jackie35er.donations.presentation.dto

import java.time.LocalDate
import javax.validation.constraints.Min
import javax.validation.constraints.PastOrPresent

data class DonationDto(
    @Min(value = 5)
    val amount: Int,

    @PastOrPresent
    val depositDate: LocalDate
)