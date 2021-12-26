package com.java.encryptionalogrithms.encryption_alogrithms

import com.java.encryptionalogrithms.Constants.TAG
import java.lang.Exception
import java.security.KeyPairGenerator
import java.security.PrivateKey
import java.security.PublicKey
import javax.crypto.Cipher
import javax.crypto.SecretKey

class RSAAlogorithm {

    companion object{
        const val alogorithType = "RSA"
        const val alogorithmSize = 2048
        private lateinit var publicKey: PublicKey
        private lateinit var privateKey: PrivateKey

        init {
            val keyPairGenerator = KeyPairGenerator.getInstance(alogorithType)
            keyPairGenerator.initialize(alogorithmSize)
            val keyPair = keyPairGenerator.genKeyPair()
            keyPair.apply {
                privateKey = private
                publicKey = public
            }
        }

        fun encryptData(plainText:ByteArray):ByteArray?{
            var result:ByteArray ?= null
            try{
                plainText.let {
                    val cipher = Cipher.getInstance(alogorithType)
                    cipher.init(Cipher.ENCRYPT_MODE, publicKey)
                    result = cipher.doFinal(plainText)
                }
            }catch (exception:Exception){
                println("$TAG exception in RSA occured during the encryption is ${exception.message}")
            }
            return result
        }

        fun decryptData(encryptedText:ByteArray):ByteArray?{
            var result:ByteArray ?= null
            try{
                encryptedText.let {
                    val cipher = Cipher.getInstance(alogorithType)
                    cipher.init(Cipher.DECRYPT_MODE, privateKey)
                    result = cipher.doFinal(encryptedText)
                }
            }catch (exception:Exception){
                println("$TAG exception in RSA occured during the decryption is ${exception.message}")
            }
            return result
        }
    }
}