package com.example.api.loan.review

import org.springframework.http.ResponseEntity
import org.springframework.web.bind.annotation.GetMapping
import org.springframework.web.bind.annotation.PathVariable
import org.springframework.web.bind.annotation.RequestMapping
import org.springframework.web.bind.annotation.RestController


// 대출 심사 결과 요청하는 컨트롤러

@RestController
@RequestMapping("/loan/api/v1")
class LoanReviewController(
        private val loanReviewServiceImpl: LoanReviewServiceImpl
) {

    @GetMapping("/review/{userKey}")
    fun getReviewResult(
            @PathVariable userKey: String
    ): ResponseEntity<LoanReviewDto.LoanReviewResponseDto> {
        return ResponseEntity.ok(
                loanReviewServiceImpl.loanReviewMain(userKey)
        )
    }
}