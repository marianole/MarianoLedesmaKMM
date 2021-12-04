package com.example.tp_kmm.domain

interface CharactersRepository {

    suspend fun getCharacters(timestamp: Long, md5: String): List<Character>

}
