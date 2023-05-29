package com.example.domain.domain

import javax.persistence.*

@Entity
@Table(name = "LOAN_REVIEW")
class LoanReview(

    @Column(name = "USR_KEY")
    var userKey: String, // 유저 키

    @Column(name = "LOAN_LMT_AMT")
    var loanLimitedAmount: Long, // 대출 한도

    @Column(name = "LOAN_INTRT")
    var loanInterest: Double // 이자율
) {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    val id: Long? = null;
}