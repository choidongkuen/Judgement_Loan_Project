package com.example.api.loan.review

interface LoanReviewService {

    fun loanReviewMain(userKey: String): LoanReviewDto.LoanReviewResponseDto

    fun getLoanReviewResult(userKey: String): LoanReviewDto.LoanReview
}