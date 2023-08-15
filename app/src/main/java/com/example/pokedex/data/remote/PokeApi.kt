package com.example.pokedex.data.remote

import retrofit2.Response
import retrofit2.http.GET
import retrofit2.http.Query

interface PokeApi {
    @GET("v2/pokemon")
    suspend fun getData(): Response<PokeDatos>
}