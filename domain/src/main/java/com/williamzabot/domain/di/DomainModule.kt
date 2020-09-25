package com.williamzabot.domain.di

import com.williamzabot.domain.usecases.character.CharacterUseCase
import org.koin.dsl.module

val domainModule = module {
    factory {
        CharacterUseCase(characterRepository = get())
    }
}
