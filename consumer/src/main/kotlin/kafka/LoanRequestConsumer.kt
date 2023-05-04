package com.example.consumer.kafka

import com.example.consumer.service.LoanRequestService
import com.example.dto.LoanRequestDto
import com.fasterxml.jackson.databind.ObjectMapper
import org.springframework.kafka.annotation.KafkaListener
import org.springframework.stereotype.Service

@Service
class LoanRequestConsumer(
    private val objectMapper: ObjectMapper,
    private val loanRequestService: LoanRequestService
    // TODO : CB 사 호출 로직
) {
    @KafkaListener(topics = ["loanRequest"], groupId = "loan")
    fun loanRequestTopicConsumer(message: String) {

        // 1. Producer 에서 send 한 LoanRequestDto으로 역직렬화
        val loanRequestKafkaDto = objectMapper.readValue(message, LoanRequestDto::class.java)
        println(loanRequestKafkaDto)

        this.loanRequestService.loanRequest(loanRequestKafkaDto)
    }
}

