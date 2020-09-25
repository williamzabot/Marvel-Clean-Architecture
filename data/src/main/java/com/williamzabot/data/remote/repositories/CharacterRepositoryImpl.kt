package com.williamzabot.data.remote.repositories

import android.nfc.tech.MifareUltralight.PAGE_SIZE
import com.williamzabot.data.remote.api.CharacterService
import com.williamzabot.data.remote.mappers.toCharacter
import com.williamzabot.data.remote.utils.HASH
import com.williamzabot.data.remote.utils.PUBLIC_KEY
import com.williamzabot.data.remote.utils.TS
import com.williamzabot.domain.models.ResponseCharacters
import com.williamzabot.domain.repositories.CharacterRepository
import com.williamzabot.domain.utils.Result
import java.lang.Exception

class CharacterRepositoryImpl(private val characterService: CharacterService) :
    CharacterRepository {

    override suspend fun getCharacters(offset: Int): Result<ResponseCharacters> {
        val response = characterService.getCharacters(PUBLIC_KEY, HASH, TS, PAGE_SIZE, offset)
        return when (response.code()) {
            200 -> Result.Success(response.body()!!.toCharacter())
            else -> Result.Failure(Exception())
        }
    }
}
