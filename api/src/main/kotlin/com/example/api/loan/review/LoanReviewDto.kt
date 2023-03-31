package com.example.api.loan.review

class LoanReviewDto {

    data class LoanReviewResponseDto(
            val userKey: String,
            val loanResult: LoanResult
    )


    data class LoanResult(
            val userLimitAmount: Long,
            val userLoanInterest: Double
    )
}