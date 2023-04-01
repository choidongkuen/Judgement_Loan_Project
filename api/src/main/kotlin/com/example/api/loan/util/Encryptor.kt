package com.example.api.loan.util

import org.springframework.stereotype.Component
import java.util.*
import javax.crypto.Cipher
import javax.crypto.spec.IvParameterSpec
import javax.crypto.spec.SecretKeySpec

@Component
class Encryptor {

    companion object {
        private const val secretKey = "oingisprettyintheworld1234567890"
    } // secret key


    private val encoder = Base64.getEncoder()
    private val decoder = Base64.getDecoder()

    fun encryptString(encryptString: String): String { // 암호화

        val encryptedString
            = cipherPkcs5(Cipher.ENCRYPT_MODE, secretKey).doFinal(encryptString.toByteArray(Charsets.UTF_8)) // 암호화

        return String(encoder.encode(encryptedString)) // 인코딩
    }

    fun decryptString(decryptString: String): String { // 복호화

        val byteString
        = decoder.decode(decryptString.toByteArray(Charsets.UTF_8)) // 디코딩

        return String(cipherPkcs5(Cipher.DECRYPT_MODE, secretKey).doFinal(byteString))
    }

    fun cipherPkcs5(opMode: Int, secretKey: String): Cipher {

        val c = Cipher.getInstance("AES/CBC/PKCS5Padding")
        val sk = SecretKeySpec(secretKey.toByteArray(Charsets.UTF_8), "AES")
        val iv = IvParameterSpec(secretKey.substring(0, 16).toByteArray(Charsets.UTF_8))

        c.init(opMode, sk, iv)
        return c
    }
}