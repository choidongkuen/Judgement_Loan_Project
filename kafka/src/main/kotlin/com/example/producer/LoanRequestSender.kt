package com.example.producer

import com.example.dto.LoanRequestDto
import com.example.enum.KafkaTopic
import com.fasterxml.jackson.databind.ObjectMapper
import org.springframework.kafka.core.KafkaTemplate
import org.springframework.stereotype.Component

// kafka 를 통해 produce
@Component
class LoanRequestSender(
    private val kafkaTemplate: KafkaTemplate<String, String>,
    private val objectMapper: ObjectMapper
) {
    fun sendMessage(topic: KafkaTopic, loanRequestDto: LoanRequestDto) {
        kafkaTemplate.send(topic.topicName, objectMapper.writeValueAsString(loanRequestDto))
    }
}