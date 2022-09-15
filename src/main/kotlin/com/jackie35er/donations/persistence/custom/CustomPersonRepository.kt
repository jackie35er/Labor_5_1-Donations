package com.jackie35er.donations.persistence.custom

import com.jackie35er.donations.domain.Person

interface CustomPersonRepository {

    fun findAllPersonsWithMinSummedAmountOfDonations(minAmount: Int): List<Person>
}