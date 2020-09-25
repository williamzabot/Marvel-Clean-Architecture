package com.williamzabot.data.local.datasource

import androidx.paging.PageKeyedDataSource
import com.williamzabot.data.remote.utils.PAGE_SIZE
import com.williamzabot.domain.models.Character
import com.williamzabot.domain.usecases.character.CharacterUseCase
import com.williamzabot.domain.usecases.character.CharacterUseCase.Params
import com.williamzabot.domain.utils.Result
import kotlinx.coroutines.CoroutineScope
import kotlinx.coroutines.Dispatchers
import kotlinx.coroutines.launch

class CharacterDataSource(
    private val characterUseCase: CharacterUseCase
) : PageKeyedDataSource<Int, Character>() {

    override fun loadInitial(
        params: LoadInitialParams<Int>,
        callback: LoadInitialCallback<Int, Character>
    ) {
        CoroutineScope(Dispatchers.IO).launch {
            when (val result = characterUseCase.execute(Params(0))) {
                is Result.Success -> {
                    val offset = result.data.offset
                    if (offset <= result.data.total) {
                        callback.onResult(
                            result.data.characters,
                            offset,
                            offset + PAGE_SIZE
                        )
                    }
                }
            }
        }
    }

    override fun loadAfter(params: LoadParams<Int>, callback: LoadCallback<Int, Character>) {
        CoroutineScope(Dispatchers.IO).launch {
            when (val result = characterUseCase.execute(Params(params.key))) {
                is Result.Success -> {
                    val data = result.data
                    callback.onResult(data.characters, data.offset + PAGE_SIZE)
                }
            }
        }
    }

    override fun loadBefore(params: LoadParams<Int>, callback: LoadCallback<Int, Character>) {
    }

}