package com.williamzabot.data.remote.di

import com.jakewharton.retrofit2.adapter.kotlin.coroutines.CoroutineCallAdapterFactory
import com.williamzabot.data.remote.api.CharacterService
import com.williamzabot.data.remote.utils.BASE_URL
import okhttp3.OkHttpClient
import okhttp3.logging.HttpLoggingInterceptor
import org.koin.dsl.module
import retrofit2.Retrofit
import retrofit2.converter.gson.GsonConverterFactory

inline fun <reified T> providerWebService(): T {
    return Retrofit.Builder()
        .baseUrl(BASE_URL)
        .client(providerOkHttpClient())
        .addConverterFactory(GsonConverterFactory.create())
        .addCallAdapterFactory(CoroutineCallAdapterFactory())
        .build()
        .create(T::class.java)
}

fun providerOkHttpClient() = OkHttpClient.Builder().apply {
    val logging = HttpLoggingInterceptor()
    logging.level = HttpLoggingInterceptor.Level.BODY
    addInterceptor(logging)
}.build()

val networkModule = module {
    factory {
        providerWebService<CharacterService>()
    }
}