package com.example.api.loan.request


/*
request :
    1. userName, -> 이름
    2. userIncomeAmount, -> 소득
    3. userRegistrationNumber -> 주민 번호
*/

class LoanRequestDto {

    data class LoanRequestInputDto( // 요청
            val userName: String,
            val userIncomeAmount: Long,
            val userRegistrationNumber: String
    ) {
        fun toUserInfoDto(userKey: String) =
                UserInfoDto(
                        this.userRegistrationNumber,
                        this.userName,
                        userKey,
                        this.userIncomeAmount
                )
    }


    data class LoanRequestResponseDto( // 응답
            val userKey: String
    )
}