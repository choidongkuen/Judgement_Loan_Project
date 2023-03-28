package com.example.loan

import org.springframework.boot.autoconfigure.SpringBootApplication
import org.springframework.boot.runApplication

@SpringBootApplication
class LoanApplication

fun main(args: Array<String>) {
    runApplication<LoanApplication>(*args)
}
