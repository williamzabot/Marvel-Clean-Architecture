package com.williamzabot.domain.models

data class ResponseCharacters(
    val offset : Int,
    val total : Int,
    val characters : List<Character>)