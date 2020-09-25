package com.williamzabot.data.remote.api

import com.williamzabot.data.remote.models.AllCharacter
import retrofit2.Response
import retrofit2.http.GET
import retrofit2.http.Query

interface CharacterService {

    @GET("/v1/public/characters")
    suspend fun getCharacters(
        @Query("apikey") apiKey: String,
        @Query("hash") hash: String,
        @Query("ts") ts: Int,
        @Query("limit") limit : Int,
        @Query("offset") offset: Int
    ) : Response<AllCharacter>
}