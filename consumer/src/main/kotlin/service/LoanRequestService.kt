package com.example.consumer.service

import com.example.domain.domain.LoanReview
import com.example.domain.repository.UserReviewRepository
import org.springframework.stereotype.Service

@Service
class LoanRequestService(
    private val loanReviewRepository: UserReviewRepository
) {

    fun loanRequest() {
        // TODO:
    }

    fun loanRequestToCb() {
        
        // TODO:

    }

    fun saveLoanReviewData(loanReview: LoanReview) = loanReviewRepository.save(loanReview)

}