package com.example.api.loan.review

import com.example.domain.repository.UserReviewRepository
import org.springframework.stereotype.Service

@Service
class LoanReviewServiceImpl(
        private val userReviewRepository: UserReviewRepository
): LoanReviewService {
    override fun loanReviewMain(userKey: String): LoanReviewDto.LoanReviewResponseDto {

        val loanReviewResult = getLoanReviewResult(userKey)

        return LoanReviewDto.LoanReviewResponseDto(
                userKey = userKey,
                loanResult = LoanReviewDto.LoanResult(
                        userLimitAmount = loanReviewResult.userLimitAmount,
                        userLoanInterest = loanReviewResult.userLoanInterest
                )
        )

    }

    override fun getLoanReviewResult(userKey: String): LoanReviewDto.LoanReview {
        val result = userReviewRepository.findByUserKey(userKey)

        return LoanReviewDto.LoanReview(
                result.userKey,
                result.loanLimitedAmount,
                result.loanInterest
        )
    }
}