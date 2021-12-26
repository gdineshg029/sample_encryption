package com.java.encryptionalogrithms.encryption_alogrithms

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


        fun encryptData(plainText:String):String?{
            var result:String ?= null
            try {
                plainText.let {
                    val cipher = Cipher.getInstance(alogorithmType)
                    cipher.init(Cipher.ENCRYPT_MODE, secretKey)
                    result = cipher.doFinal(plainText.toByteArray()).toString()
                }
            }catch (exception : Exception){
                println("Exception occured during encryption is $exception")
            }
            return result
        }

        fun decryptData(encryptedText:String):String?{
            var result:String ?= null
            try {
                encryptedText.let {
                    var cipher = Cipher.getInstance(alogorithmType)
                    cipher.init(Cipher.DECRYPT_MODE, secretKey)
                    result = cipher.doFinal(encryptedText.toByteArray()).toString()
                }

            }catch (exception:Exception){
                println("Exception occured during decryption is $exception")
            }
            return result
        }
    }

}