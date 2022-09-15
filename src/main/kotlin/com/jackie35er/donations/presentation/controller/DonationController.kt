package com.jackie35er.donations.presentation.controller

import com.jackie35er.donations.domain.Donation
import com.jackie35er.donations.domain.Person
import com.jackie35er.donations.persistence.DonationRepository
import com.jackie35er.donations.persistence.PersonRepository
import org.springframework.http.MediaType
import org.springframework.web.bind.annotation.*
import javax.persistence.EntityNotFoundException

@RestController
@RequestMapping("/api/donations")
class DonationController(
    val donationRepository: DonationRepository,
    val personRepository: PersonRepository,
) {

    @GetMapping("/{id}")
    fun findDonationById(@PathVariable id: Int): Donation {
        return donationRepository.findById(id).orElseThrow { EntityNotFoundException("Donation not found for id: $id") }
    }

    @GetMapping("/donations", produces = [MediaType.APPLICATION_JSON_VALUE])
    @ResponseBody
    fun findAllPersonsWithMinSummedAmountOfDonations(@RequestParam min: Int): List<Person> {
        return personRepository.findAllPersonsWithMinSummedAmountOfDonations(min)
    }


}
