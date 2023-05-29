package com.example.api.loan.review

import io.swagger.annotations.Api
import io.swagger.annotations.ApiOperation
import org.springframework.http.ResponseEntity
import org.springframework.web.bind.annotation.GetMapping
import org.springframework.web.bind.annotation.PathVariable
import org.springframework.web.bind.annotation.RequestMapping
import org.springframework.web.bind.annotation.RestController


// 대출 심사 결과 요청하는 컨트롤러
@Api(tags = ["대출 심사 결과 요청 API"])
@RestController
@RequestMapping("/loan/api/v1")
class LoanReviewController(
    private val loanReviewServiceImpl: LoanReviewServiceImpl
) {

    @ApiOperation(value = "대출 심사 결과 요청하는 API")
    @GetMapping("/review/{userKey}")
    fun getReviewResult(
        @PathVariable userKey: String
    ): ResponseEntity<LoanReviewDto.LoanReviewResponseDto> {
        return ResponseEntity.ok(
            loanReviewServiceImpl.loanReviewMain(userKey)
        )
    }
}