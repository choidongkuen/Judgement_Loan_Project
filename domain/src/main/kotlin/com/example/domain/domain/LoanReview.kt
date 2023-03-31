package com.example.domain.domain

import javax.persistence.*

@Table
@Entity
class LoanReview (

        @Column(name = "USR_KEY")
        val userKey: String,

        @Column(name = "LOAN_LMT_AMT")
        val loanLimitedAmount: Long,

        @Column(name = "LOAN_INTRT")
        val loanInterest: Double
) {
        @Id
        @GeneratedValue(strategy = GenerationType.IDENTITY)
        val id: Long? = null
}