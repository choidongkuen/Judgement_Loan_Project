package com.example.api.loan.request

import com.example.domain.domain.UserInfo
import com.example.dto.LoanRequestDto

data class UserInfoDto(
    val userRegistrationNumber: String,
    val userName: String,
    val userKey: String,
    val userIncomeAmount: Long
) {
    fun toEntity(): UserInfo =
        UserInfo(userKey, userRegistrationNumber, userName, userIncomeAmount)


    // from UserInfoDto -> com.example.dto.LoanRequestDto
    fun toLoanRequestKafkaDto() =
        LoanRequestDto(userKey, userName, userIncomeAmount, userRegistrationNumber)
}