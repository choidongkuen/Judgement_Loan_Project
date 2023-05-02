package com.example.api.loan.review

import com.example.api.exception.CustomErrorCode
import com.example.api.exception.CustomException
import com.example.domain.domain.LoanReview
import com.example.domain.repository.UserReviewRepository
import org.springframework.stereotype.Service

@Service
class LoanReviewServiceImpl(
    private val userReviewRepository: UserReviewRepository
) : LoanReviewService {
    override fun loanReviewMain(userKey: String): LoanReviewDto.LoanReviewResponseDto {

        return LoanReviewDto.LoanReviewResponseDto(
            userKey = userKey,
            loanResult = getLoanReviewResult(userKey)?.toResponseDto()
                ?: throw CustomException(CustomErrorCode.RESULT_NOT_FOUND)
            // userKey 해당하는 loanResult 존재하지 않는 경우
        )

    }

    override fun getLoanReviewResult(userKey: String) =
        userReviewRepository.findByUserKey(userKey)

    private fun LoanReview.toResponseDto() = // LoanReview 확장 함수
        LoanReviewDto.LoanResult(
            userLimitAmount = this.loanLimitedAmount,
            userLoanInterest = this.loanInterest
        )
}