package com.example.api.loan.request

import com.example.api.loan.util.Encryptor
import com.example.api.loan.util.GenerateUserKey
import com.example.domain.domain.UserInfo
import com.example.domain.repository.UserInfoRepository
import com.fasterxml.jackson.databind.ObjectMapper
import com.fasterxml.jackson.module.kotlin.KotlinModule
import io.mockk.every
import io.mockk.mockk
import org.junit.jupiter.api.Assertions.*
import org.junit.jupiter.api.BeforeEach
import org.junit.jupiter.api.DisplayName
import org.junit.jupiter.api.Test
import org.springframework.boot.test.autoconfigure.web.servlet.WebMvcTest
import org.springframework.boot.test.mock.mockito.MockBean
import org.springframework.http.MediaType
import org.springframework.test.web.servlet.MockMvc
import org.springframework.test.web.servlet.post
import org.springframework.test.web.servlet.setup.MockMvcBuilders

@WebMvcTest(LoanRequestController::class)
internal class LoanRequestControllerTest {

    private lateinit var mockMvc: MockMvc

    private lateinit var loanRequestController: LoanRequestController

    private lateinit var generateKey: GenerateUserKey

    private lateinit var encryptComponent: Encryptor

    private val userInfoRepository: UserInfoRepository = mockk()

    private lateinit var objectMapper: ObjectMapper // 직렬화를 위한 라이브러리

    @MockBean
    private lateinit var loanRequestServiceImpl: LoanRequestServiceImpl

    companion object {
        private const val baseUrl = "/loan/api/v1"
    }


    @BeforeEach
    fun init() {

        generateKey = GenerateUserKey()
        encryptComponent = Encryptor()

        loanRequestServiceImpl = LoanRequestServiceImpl(
            generateKey, userInfoRepository, encryptComponent
        )

        loanRequestController = LoanRequestController(loanRequestServiceImpl)

        mockMvc = MockMvcBuilders.standaloneSetup(loanRequestController).build()

        objectMapper = ObjectMapper().registerModule(KotlinModule.Builder().build())
    }


    @Test
    @DisplayName("성공적인 대출 심사 요청")
    fun successLoanRequestTest() {
        // given
        val loanRequestInputDto: LoanRequestDto.LoanRequestInputDto =
            LoanRequestDto.LoanRequestInputDto(
                userName = "TEST",
                userIncomeAmount = 10000,
                userRegistrationNumber = "971201-1216826"
            )

        every { userInfoRepository.save(any()) } returns UserInfo(
            "", "", "", 1
        )

        // when
        mockMvc.post(
            "$baseUrl/request"
        ) {
            contentType = MediaType.APPLICATION_JSON
            accept = MediaType.APPLICATION_JSON
            content = objectMapper.writeValueAsString(loanRequestInputDto)
        }.andExpect {
            status { isOk() }
        }
        // then
    }
}