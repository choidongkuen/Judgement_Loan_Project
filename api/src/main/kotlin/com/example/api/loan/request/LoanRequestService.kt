package com.example.api.loan.request

import com.example.domain.domain.UserInfo


interface LoanRequestService {

    fun loanRequestMain(
            loanRequestInputDto: LoanRequestDto.LoanRequestInputDto
    ): LoanRequestDto.LoanRequestResponseDto // main

    fun saveUserInfo(
            userInfoDto: UserInfoDto
    ): UserInfo // 유저 정보 저장

    fun loanRequestReview(userKey: String) // 대출 심사 요청
}