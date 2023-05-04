package com.example.consumer.service

import com.example.consumer.dto.LoanResponseDto
import com.example.domain.domain.LoanReview
import com.example.domain.repository.UserReviewRepository
import com.example.dto.LoanRequestDto
import org.springframework.boot.web.client.RestTemplateBuilder
import org.springframework.stereotype.Service
import java.time.Duration

@Service
class LoanRequestService(
    private val loanReviewRepository: UserReviewRepository
) {

    companion object {
        // css url(LoanReviewController)
        private val cssUrl = "http://localhost:8080/css/api/v1/request"
    }

    fun loanRequest(loanRequestDto: LoanRequestDto) {
        // CB component 에 요청 보내기 -> 응닶값을 DB 저장(LoanReview Repository)
        // RestTemplate vs webClient

        // 1. loanRequestToCb -> css 요청
        // 2. saveLoanReviewData -> LoanReviewRepository LoanReview 엔티티 저장

        val reviewResult = loanRequestToCb(loanRequestDto) // 1

        saveLoanReviewData(reviewResult.toLoanReviewEntity()) // 2
    }

    fun loanRequestToCb(loanRequestDto: LoanRequestDto): LoanResponseDto {

        val restTemplate = RestTemplateBuilder()
            .setConnectTimeout(Duration.ofMillis(1000))
            .setReadTimeout(Duration.ofMillis(1000))
            .build()

        // css 요청
        return restTemplate.postForEntity(cssUrl, loanRequestDto, LoanResponseDto::class.java).body!!
    }

    fun saveLoanReviewData(loanReview: LoanReview) = loanReviewRepository.save(loanReview)
}