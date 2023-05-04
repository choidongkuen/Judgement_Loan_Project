package com.example.css.controller

import com.example.css.dto.LoanRequestDto.*
import com.example.css.dto.LoanResultDto.*
import com.example.css.service.LoanReviewService
import org.springframework.web.bind.annotation.PostMapping
import org.springframework.web.bind.annotation.RequestBody
import org.springframework.web.bind.annotation.RequestMapping
import org.springframework.web.bind.annotation.RestController


/*
    대출 심사 요청 후 회원 정보(UserInfo) 저장 후, userKey 로 심사 결과(Loan Review)를 요청 하는 경우 외부 시스템을 통해 심사를 진행
*/
@RestController
@RequestMapping("/css/api/v1")
class LoanReviewController(
    private val loanReviewService: LoanReviewService
) {

    @PostMapping("/request")
    fun loanReview(@RequestBody loanRequestDto: LoanInputDto)
            : LoanResponseDto {
        return this.loanReviewService.loanReview(loanRequestDto)
    }
}