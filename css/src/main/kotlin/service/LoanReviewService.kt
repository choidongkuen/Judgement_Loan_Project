package com.example.css.service

import com.example.css.dto.LoanRequestDto
import com.example.css.dto.LoanResultDto
import org.springframework.stereotype.Service

@Service
class LoanReviewService {

    fun loanReview(loanRequestDto: LoanRequestDto.LoanInputDto)
            : LoanResultDto.LoanResponseDto {

        val userIncomeAmount: Long = loanRequestDto.userIncomeAmount
        val userKey = loanRequestDto.userKey

        if (userIncomeAmount < 0) throw RuntimeException("Invalid userIncomeAmount !!")
        if (userIncomeAmount < 100_000_00) return LoanResultDto.LoanResponseDto(userKey, 100_000_00, 0.0)
        if (userIncomeAmount < 200_000_00) return LoanResultDto.LoanResponseDto(userKey, 200_000_00, 10.0)
        if (userIncomeAmount < 300_000_00) return LoanResultDto.LoanResponseDto(userKey, 300_000_00, 9.0)
        if (userIncomeAmount < 400_000_00) return LoanResultDto.LoanResponseDto(userKey, 400_000_00, 8.0)
        if (userIncomeAmount < 500_000_00) return LoanResultDto.LoanResponseDto(userKey, 500_000_00, 7.0)
        if (userIncomeAmount < 600_000_00) return LoanResultDto.LoanResponseDto(userKey, 600_000_00, 6.0)
        if (userIncomeAmount < 700_000_00) return LoanResultDto.LoanResponseDto(userKey, 700_000_00, 5.0)
        if (userIncomeAmount >= 800_000_00) return LoanResultDto.LoanResponseDto(userKey, 800_000_00, 4.0)
        else throw RuntimeException("Invalid userIncomeAmount !!")
    }
}