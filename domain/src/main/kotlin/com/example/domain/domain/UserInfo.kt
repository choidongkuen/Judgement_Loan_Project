package com.example.domain.domain

import javax.persistence.*


@Entity
@Table(name = "USER_INFO")
class UserInfo(

    @Column(name = "USR_KEY")
    val userKey: String, // 유저 키

    @Column(name = "USR_REG_NUM")
    val userRegistrationNumber: String, // 유저 주민번호

    @Column(name = "USR_NM")
    val userName : String, // 유저 이름

    @Column(name = "USR_ICM_AMT")
    val userIncomeAmount: Long, // 유저 소득


) {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    val id: Long? = null
}
