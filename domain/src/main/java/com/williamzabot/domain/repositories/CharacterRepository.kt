package com.williamzabot.domain.repositories

import com.williamzabot.domain.models.ResponseCharacters
import com.williamzabot.domain.utils.Result

interface CharacterRepository {
    suspend fun getCharacters(offset : Int) : Result<ResponseCharacters>
}