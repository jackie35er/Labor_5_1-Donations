package com.jackie35er.donations.presentation.controller

import com.jackie35er.donations.domain.Donation
import com.jackie35er.donations.domain.Person
import com.jackie35er.donations.persistence.DonationRepository
import org.springframework.web.bind.annotation.GetMapping
import org.springframework.web.bind.annotation.PathVariable
import org.springframework.web.bind.annotation.RequestMapping
import org.springframework.web.bind.annotation.RestController
import org.springframework.web.client.HttpStatusCodeException
import javax.persistence.EntityNotFoundException

@RestController
@RequestMapping("/api/donations")
class DonationController(
    val donationRepository: DonationRepository,
) {

    @GetMapping("/{id}")
    fun findDonationById(@PathVariable id: Int): Donation {
        return donationRepository.findById(id).orElseThrow{ EntityNotFoundException("Donation not found") }
    }

}
