package com.java.encryptionalogrithms.encryption_alogrithms

import com.java.encryptionalogrithms.Constants.TAG
import java.lang.Exception
import javax.crypto.Cipher
import javax.crypto.KeyGenerator
import javax.crypto.SecretKey

class AESAlogorithm {

    companion object{
        private const val alogorithmType = "AES"
        private const val keySize = 256
        private lateinit var secretKey: SecretKey

        init{
            val keyGenerator = KeyGenerator.getInstance("AES")
            keyGenerator.init(keySize)
            secretKey = keyGenerator.generateKey()
        }


        fun encryptData(plainText:ByteArray):ByteArray?{
            var result:ByteArray ?= null
            try {
                plainText.let {
                    val cipher = Cipher.getInstance(alogorithmType)
                    cipher.init(Cipher.ENCRYPT_MODE, secretKey)
                    result = cipher.doFinal(plainText)
                }
            }catch (exception : Exception){
                println("$TAG Exception in AES occured during encryption is $exception")
            }
            return result
        }

        fun decryptData(encryptedText:ByteArray):ByteArray?{
            var result:ByteArray ?= null
            try {
                encryptedText.let {
                    var cipher = Cipher.getInstance(alogorithmType)
                    cipher.init(Cipher.DECRYPT_MODE, secretKey)
                    val byteArray = cipher.doFinal(encryptedText)
                    println("DecryptedAESArray ${String(byteArray)}")
                }

            }catch (exception:Exception){
                println("$TAG Exception in AES occured during decryption is $exception")
            }
            return result
        }
    }

}