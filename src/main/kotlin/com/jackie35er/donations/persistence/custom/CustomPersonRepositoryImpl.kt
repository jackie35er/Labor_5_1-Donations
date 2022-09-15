package com.jackie35er.donations.persistence.custom

import com.jackie35er.donations.domain.Person
import com.jackie35er.donations.persistence.custom.QueryDslEntities.donation
import com.jackie35er.donations.persistence.custom.QueryDslEntities.person
import com.querydsl.jpa.impl.JPAQueryFactory
import javax.persistence.EntityManager
import javax.persistence.PersistenceContext


class CustomPersonRepositoryImpl(
    @PersistenceContext
    private val entityManager: EntityManager
) : CustomPersonRepository {

    private val queryFactory = JPAQueryFactory(entityManager)

    override fun findAllPersonsWithMinSummedAmountOfDonations(minAmount: Int): List<Person> {
        return queryFactory.selectFrom(person)
            .innerJoin(donation)
            .on(donation.person.eq(person))
            .groupBy(person)
            .having(donation.amount.sum().gt(minAmount))
            .fetch()
    }


}