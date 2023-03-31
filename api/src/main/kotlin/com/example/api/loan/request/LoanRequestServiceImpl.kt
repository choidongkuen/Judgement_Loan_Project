package com.example.api.loan.request

import com.example.api.loan.util.Encryptor
import com.example.api.loan.util.GenerateUserKey
import com.example.domain.repository.UserInfoRepository
import org.springframework.stereotype.Service

@Service
class LoanRequestServiceImpl(
        private val generateUserKey: GenerateUserKey,
        private val userInfoRepository: UserInfoRepository,
        private val encryptComponent: Encryptor
) : LoanRequestService {
    override fun loanRequestMain(
            loanRequestInputDto: LoanRequestDto.LoanRequestInputDto
    ): LoanRequestDto.LoanRequestResponseDto {

        val userKey = generateUserKey.generateUserKey()

        loanRequestInputDto.userRegistrationNumber = encryptComponent.encryptString(loanRequestInputDto.userRegistrationNumber)

        saveUserInfo(
                loanRequestInputDto.toUserInfoDto(userKey)
        )

        loanRequestReview("")

        return LoanRequestDto.LoanRequestResponseDto(userKey)
    }

    override fun saveUserInfo(userInfoDto: UserInfoDto) =
            userInfoRepository.save(userInfoDto.toEntity())


    override fun loanRequestReview(userKey: String) {
        TODO("Not yet implemented")
    }
}