package com.jackie35er.donations.presentation.controller

import com.jackie35er.donations.domain.Donation

import com.jackie35er.donations.persistence.DonationRepository
import com.jackie35er.donations.persistence.PersonRepository
import com.jackie35er.donations.presentation.dto.DonationDto
import org.springframework.http.MediaType
import org.springframework.web.bind.annotation.*
import javax.persistence.EntityNotFoundException
import javax.validation.Valid


@RestController
@RequestMapping("/api/persons")
class PersonController(
    val donationRepository: DonationRepository,
    val personRepository: PersonRepository
) {

    @GetMapping("/{id}/donations")
    fun getAllDonations(@PathVariable id: Int): List<Donation> {
        val donations = donationRepository.findAllByPersonId(id)
        if (donations.isEmpty())
            throw EntityNotFoundException("Person not found for id: $id")

        return donations
    }

    @PostMapping("/{id}/donations", consumes = [MediaType.APPLICATION_JSON_VALUE])
    fun saveDonation(@PathVariable id: Int, @RequestBody @Valid newDonation: DonationDto) {
        val person = personRepository.findById(id)
            .orElseThrow { EntityNotFoundException("Person not found for id: $id") }
        val donations = Donation(//make mapper or smth
            id = null,
            person = person,
            amount = newDonation.amount,
            depositDate = newDonation.depositDate
        )

        donationRepository.save(donations)
    }
}

