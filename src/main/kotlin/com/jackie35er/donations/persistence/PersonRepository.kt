package com.jackie35er.donations.persistence

import com.jackie35er.donations.domain.Person
import com.jackie35er.donations.persistence.custom.CustomPersonRepository
import org.springframework.data.jpa.repository.JpaRepository

interface PersonRepository : JpaRepository<Person, Int>, CustomPersonRepository {
}