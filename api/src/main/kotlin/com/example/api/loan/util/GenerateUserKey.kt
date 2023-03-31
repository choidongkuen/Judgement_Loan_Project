package com.example.api.loan.util

import org.springframework.stereotype.Component
import java.util.*


@Component
class GenerateUserKey {

    fun generateUserKey() = UUID.randomUUID().toString().replace("-", "") // "-" 모두 제거
}