package com.jackie35er.donations.persistence

import com.jackie35er.donations.domain.Donation
import org.springframework.data.jpa.repository.JpaRepository

interface DonationRepository: JpaRepository<Donation, Int?> {
}