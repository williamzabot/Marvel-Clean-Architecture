package com.williamzabot.data.remote.mappers

import com.williamzabot.data.remote.models.AllCharacter
import com.williamzabot.domain.models.Character
import com.williamzabot.domain.models.ResponseCharacters

fun AllCharacter.toCharacter() = ResponseCharacters(
    data.offset,
    data.total,
    data.heroes.map {
        Character(it.name, "${it.thumbnail.path}.${it.thumbnail.extension}")
    })

