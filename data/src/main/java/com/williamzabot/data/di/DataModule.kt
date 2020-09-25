package com.williamzabot.data.di

import com.williamzabot.data.remote.repositories.CharacterRepositoryImpl
import com.williamzabot.domain.repositories.CharacterRepository
import org.koin.dsl.module

val dataModule = module {
    factory<CharacterRepository> {
        CharacterRepositoryImpl(characterService = get())
    }
}