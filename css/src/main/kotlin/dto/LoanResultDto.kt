package com.example.css.dto

class LoanResultDto {

    data class LoanResponseDto(
        val userKey: String,
        val userLimitAmount: Long, // 대출 한도
        val userLoanInterest: Double, // 대출 이자
    )
}