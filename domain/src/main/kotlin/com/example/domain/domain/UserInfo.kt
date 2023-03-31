package com.example.domain.domain

import javax.persistence.*


@Entity
@Table(name = "USER_INFO")
class UserInfo(

    @Column(name = "USR_KEY")
    val userKey: String,

    @Column(name = "USR_REG_NUM")
    val userRegistrationNumber: String,


    @Column(name = "USR_ICM_AMT")
    val userIncomeAmount: Long,


) {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    val id: Long? = null
}
