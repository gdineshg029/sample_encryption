package com.java.encryptionalogrithms

import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import com.java.encryptionalogrithms.Constants.TAG
import com.java.encryptionalogrithms.encryption_alogrithms.AESAlogorithm
import com.java.encryptionalogrithms.encryption_alogrithms.RSAAlogorithm

class MainActivity : AppCompatActivity() {

    val plainText = "Hello Dinesh . Welcome to ciphers.Cipher is an encryption alogorithm  used to convert plaintext into ciphertext"

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_main)
        println("Plain text to be encrypted is :")
        println(plainText)
        (1..10).forEach {
            print("*")
            if(it ==10){
                println("*")
            }
        }

        val aesCipherText = AESAlogorithm.encryptData(plainText.encodeToByteArray())

        println("$TAG Enryption with AES is \n $TAG ${String(aesCipherText!!)}}")

        val rsaCipherText = RSAAlogorithm.encryptData(plainText.encodeToByteArray())

        println("$TAG Enryption with RSA is \n $TAG ${String(rsaCipherText!!)}}")

        println("$TAG Deryption with AES is \n $TAG ${String(AESAlogorithm.decryptData(aesCipherText!!)!!)}")

        println("$TAG Deryption with RSA is \n $TAG ${String(RSAAlogorithm.decryptData(rsaCipherText!!)!!)}")
    }
}