package com.williamzabot.domain.usecases

import com.williamzabot.domain.utils.Result

abstract class BaseUseCase<T : Any, in Params> {
    abstract suspend fun execute(params: Params?): Result<T>
}