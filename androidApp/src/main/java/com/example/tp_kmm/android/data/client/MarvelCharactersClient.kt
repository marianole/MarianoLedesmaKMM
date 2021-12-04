package com.example.tp_kmm.android.data.client

import com.example.tp_kmm.data.CharactersResponse
import com.google.gson.annotations.SerializedName
import retrofit2.http.GET
import retrofit2.http.Headers
import retrofit2.http.Query

interface MarvelCharactersClient {

    @GET("v1/public/characters")
    @Headers("Accept: application/json")
    suspend fun getAllCharacters(
        @Query("ts") timestamp: Long,
        @Query("hash") md5: String
    ): CharactersResponse

}