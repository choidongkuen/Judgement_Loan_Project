package com.example.css.dto

class LoanRequestDto {

    data class LoanInputDto(
        val userKey: String,
        val userName: String,
        val userRegistrationNumber: String,
        val userIncomeAmount: Long
    )
}