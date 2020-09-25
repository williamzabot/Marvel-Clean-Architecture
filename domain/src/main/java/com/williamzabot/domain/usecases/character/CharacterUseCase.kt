package com.williamzabot.domain.usecases.character

import com.williamzabot.domain.models.ResponseCharacters
import com.williamzabot.domain.repositories.CharacterRepository
import com.williamzabot.domain.usecases.BaseUseCase
import com.williamzabot.domain.utils.Result
import java.lang.Exception

class CharacterUseCase(private val characterRepository: CharacterRepository) :
    BaseUseCase<ResponseCharacters, CharacterUseCase.Params>() {

    data class Params(val offset: Int)

    override suspend fun execute(params: Params?): Result<ResponseCharacters> {
        if (params == null) throw IllegalArgumentException()
        return when (val result = characterRepository.getCharacters(params.offset)) {
            is Result.Success -> Result.Success(result.data)
            is Result.Failure -> Result.Failure(Exception())
        }
    }
}