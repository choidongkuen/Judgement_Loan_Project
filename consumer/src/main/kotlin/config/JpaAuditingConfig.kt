package com.example.consumer.config

import org.springframework.context.annotation.Configuration
import org.springframework.data.jpa.repository.config.EnableJpaAuditing
import org.springframework.data.jpa.repository.config.EnableJpaRepositories

@Configuration
@EnableJpaAuditing
@EnableJpaRepositories(basePackages = ["com.example.domain"]) // com.example.domain -> 오류(모듈임)
class JpaAuditingConfig {
}