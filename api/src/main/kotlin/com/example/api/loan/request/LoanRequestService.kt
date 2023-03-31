package com.example.api.loan.request


interface LoanRequestService {

    fun loanRequestMain(
            loanRequestInputDto: LoanRequestDto.LoanRequestInputDto
    ): LoanRequestDto.LoanRequestResponseDto // main

    fun saveUserInfo(
            userKey: String,
            loanRequestInputDto: LoanRequestDto.LoanRequestInputDto
    ) // 유저 정보 저장

    fun loanRequestReview(userKey: String) // 대출 심사 요청
}