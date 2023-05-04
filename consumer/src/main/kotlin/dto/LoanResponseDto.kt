package com.example.consumer.dto

import com.example.domain.domain.LoanReview

data class LoanResponseDto(
    val userKey: String,
    val userLoanInterest: Double,
    val userLimitAmount: Long
) {

    fun toLoanReviewEntity(): LoanReview =
        LoanReview(
            userKey = userKey,
            loanInterest = userLoanInterest,
            loanLimitedAmount = userLimitAmount
        )
}