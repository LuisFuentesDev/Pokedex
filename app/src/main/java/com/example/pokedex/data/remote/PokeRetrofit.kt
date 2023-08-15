package com.example.pokedex.data.remote

import retrofit2.Retrofit
import retrofit2.converter.gson.GsonConverterFactory

class PokeRetrofit {
    companion object {
        private const val URL_BASE = "https://pokeapi.co/api/"

        fun getPokeRetrofit(): PokeApi {
            val mRetrofit = Retrofit.Builder()
                .baseUrl(URL_BASE)
                .addConverterFactory(GsonConverterFactory.create())
                .build()
            return mRetrofit.create(PokeApi::class.java)
        }
    }
}