package com.example.domain.repository

import com.example.domain.domain.UserInfo
import org.springframework.data.jpa.repository.JpaRepository

interface UserInfoRepository : JpaRepository<Long, UserInfo>
