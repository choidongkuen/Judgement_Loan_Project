package com.example.enum

// Kafka topic -> Partitions 으로 구성
enum class KafkaTopic(val topicName: String) {
    LOAN_REQUEST("loanRequest")
}