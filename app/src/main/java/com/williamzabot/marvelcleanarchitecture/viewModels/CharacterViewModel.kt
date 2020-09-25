package com.williamzabot.marvelcleanarchitecture.viewModels

import androidx.lifecycle.LiveData
import androidx.lifecycle.ViewModel
import androidx.paging.DataSource
import androidx.paging.LivePagedListBuilder
import androidx.paging.PagedList
import com.williamzabot.data.local.datasource.CharacterDataSource
import com.williamzabot.data.remote.utils.PAGE_SIZE
import com.williamzabot.domain.models.Character
import com.williamzabot.domain.usecases.character.CharacterUseCase

class CharacterViewModel(private val characterUseCase: CharacterUseCase) : ViewModel() {

    val pagedListCharacter: LiveData<PagedList<Character>>

    init {
        val config = PagedList.Config.Builder()
            .setPageSize(PAGE_SIZE)
            .setEnablePlaceholders(false)
            .build()
        pagedListCharacter = initializedPagedListBuilder(config).build()
    }

    private fun initializedPagedListBuilder(config: PagedList.Config)
            : LivePagedListBuilder<Int, Character> {

        val dataSourceFactory = object : DataSource.Factory<Int, Character>() {
            override fun create(): DataSource<Int, Character> {
                return CharacterDataSource(characterUseCase)
            }
        }
        return LivePagedListBuilder<Int, Character>(dataSourceFactory, config)
    }
}