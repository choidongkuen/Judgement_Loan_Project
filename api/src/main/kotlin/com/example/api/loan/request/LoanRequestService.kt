package com.example.api.loan.request


interface LoanRequestService {

    fun loanRequestMain() // main

    fun saveUserInfo() // 유저 정보 저장

    fun loanRequestReview() // 대출 심사 요청
}