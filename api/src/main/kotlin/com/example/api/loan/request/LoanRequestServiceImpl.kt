package com.example.api.loan.request

import com.example.api.loan.util.Encryptor
import com.example.api.loan.util.GenerateUserKey
import com.example.domain.repository.UserInfoRepository
import com.example.enum.KafkaTopic
import com.example.producer.LoanRequestSender
import org.springframework.stereotype.Service

@Service
class LoanRequestServiceImpl(
    private val generateUserKey: GenerateUserKey,
    private val userInfoRepository: UserInfoRepository,
    private val encryptComponent: Encryptor,
    private val loanRequestSender: LoanRequestSender
) : LoanRequestService {
    override fun loanRequestMain(
        loanRequestInputDto: LoanRequestDto.LoanRequestInputDto
    ): LoanRequestDto.LoanRequestResponseDto {

        val userKey = generateUserKey.generateUserKey() // 1. userKey 생성


        // 2. 회원 주민번호 암호화
        loanRequestInputDto.userRegistrationNumber =
            encryptComponent.encryptString(loanRequestInputDto.userRegistrationNumber) // 주민 번호 암호화

        val userInfoDto = loanRequestInputDto.toUserInfoDto(userKey)

        // 3. UserInfo 저장
        saveUserInfo(userInfoDto) // 회원정보 저장

        // 4. Kafka 를 통해 심사 요청 Produce
        loanRequestReview(userInfoDto)

        // 5. 응답 리턴
        return LoanRequestDto.LoanRequestResponseDto(userKey)
    }

    override fun saveUserInfo(userInfoDto: UserInfoDto) =
        userInfoRepository.save(userInfoDto.toEntity())

    override fun loanRequestReview(userInfoDto: UserInfoDto) {

        loanRequestSender.sendMessage(
            KafkaTopic.LOAN_REQUEST,
            userInfoDto.toLoanRequestKafkaDto()
        )
    }
}