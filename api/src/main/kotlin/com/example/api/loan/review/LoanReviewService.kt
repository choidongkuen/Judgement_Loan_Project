package com.example.api.loan.review

import com.example.domain.domain.LoanReview

interface LoanReviewService {

    fun loanReviewMain(userKey: String): LoanReviewDto.LoanReviewResponseDto

    // user Key 에 해당하는 대출 심사 결과 얻기
    fun getLoanReviewResult(userKey: String): LoanReview?
}