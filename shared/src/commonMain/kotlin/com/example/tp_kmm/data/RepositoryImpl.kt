package com.example.tp_kmm.data

import com.example.tp_kmm.domain.Character
import com.example.tp_kmm.domain.CharactersRepository
import com.example.tp_kmm.initLogger
import io.github.aakira.napier.Napier
import io.ktor.client.*
import io.ktor.client.features.json.*
import io.ktor.client.features.json.serializer.*
import io.ktor.client.features.logging.*
import io.ktor.client.request.*

class RepositoryImpl: CharactersRepository {

    private val httpClient = HttpClient {
        install(JsonFeature) {
            val json = kotlinx.serialization.json.Json{
                ignoreUnknownKeys = true
            }
            serializer = KotlinxSerializer(json)
        }

        install(Logging) {
            level = LogLevel.ALL
            logger = object : Logger {
                override fun log(message: String) {
                    Napier.v(tag = "HttpClient", message = message)
                }
            }
            Logger
        }
    }.also {
        initLogger()
    }

    override suspend fun getCharacters(timestamp: Long, md5: String): List<Character> {
        return httpClient.get<CharactersResponse>(){
            headers{
                append("Accept", "application/json")
            }
            url("https://gateway.marvel.com/v1/public/characters")
            parameter("ts",timestamp)
            parameter("apikey","552c3640505e47b74711610404437d49")
            parameter("hash",md5)
        }.toModel()
    }

    private fun CharactersResponse.toModel(): List<Character> {
        return this.characters.list.map {
            Character(it.name, it.description, it.thumbnail.toUrl())
        }
    }

}