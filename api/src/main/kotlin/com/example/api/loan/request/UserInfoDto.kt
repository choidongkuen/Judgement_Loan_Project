package com.example.api.loan.request

import com.example.domain.domain.UserInfo

data class UserInfoDto(
        val userRegistrationNumber: String,
        val userName: String,
        val userKey: String,
        val userIncomeAmount: Long
) {
    fun toEntity(): UserInfo =
            UserInfo(
                    userKey, userRegistrationNumber, userName, userIncomeAmount
            )
}