package com.williamzabot.marvelcleanarchitecture.di

import com.williamzabot.marvelcleanarchitecture.viewModels.CharacterViewModel
import org.koin.androidx.viewmodel.dsl.viewModel
import org.koin.dsl.module

val presentationModule = module {
    viewModel {
        CharacterViewModel(characterUseCase = get())
    }
}