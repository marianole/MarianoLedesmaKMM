package com.example.tp_kmm.android.data.service

import com.example.tp_kmm.android.BuildConfig
import com.example.tp_kmm.data.RepositoryImpl
import com.example.tp_kmm.domain.CharactersRepository
import java.security.MessageDigest
import java.security.NoSuchAlgorithmException
import javax.crypto.Cipher.PRIVATE_KEY
import javax.crypto.Cipher.PUBLIC_KEY
import com.example.tp_kmm.domain.Character


class CharactersService(
    private val charactersRepository: RepositoryImpl
) {

    suspend fun getCharacters(): List<Character> {
        val timestamp = System.currentTimeMillis()
        return charactersRepository.getCharacters(
            timestamp,
            md5(timestamp.toString() + BuildConfig.PRIVATE_KEY + BuildConfig.PUBLIC_KEY)
        )
    }

    private fun md5(string: String): String {
        val MD5 = "MD5"
        try {
            // Create MD5 Hash
            val digest = MessageDigest
                .getInstance(MD5)
            digest.update(string.toByteArray())
            val messageDigest = digest.digest()

            // Create Hex String
            val hexString = StringBuilder()
            for (aMessageDigest in messageDigest) {
                var h = Integer.toHexString(0xFF and aMessageDigest.toInt())
                while (h.length < 2) h = "0$h"
                hexString.append(h)
            }
            return hexString.toString()
        } catch (e: NoSuchAlgorithmException) {
            e.printStackTrace()
        }
        return ""
    }

}