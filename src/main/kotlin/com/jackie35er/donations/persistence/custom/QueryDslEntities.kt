package com.jackie35er.donations.persistence.custom

import com.jackie35er.donations.domain.QDonation
import com.jackie35er.donations.domain.QPerson

object QueryDslEntities {
    val person: QPerson = QPerson.person
    val donation: QDonation = QDonation.donation
}