package com.example.pokedex.data

import android.util.Log
import androidx.lifecycle.LiveData
import com.example.pokedex.data.local.PokeDao
import com.example.pokedex.data.local.PokeEntity
import com.example.pokedex.data.remote.PokeApi

class Repositorio(private val pokeApi: PokeApi, private val pokeDao: PokeDao) {

    fun obtenerPokemonEntity(): LiveData<List<PokeEntity>> = pokeDao.getPokemon()

    suspend fun getPokemones() {
        val respuesta = pokeApi.getData()
        if (respuesta.isSuccessful) {
            val resp = respuesta.body()
            resp?.let { pokemonList ->
                val pokeEntityList = pokemonList.results.map { pokemon ->
                    PokeEntity(pokemon.name,pokemon.url)
                }
                pokeDao.insertPokemon(pokeEntityList)
            }
        } else {
            Log.e("repositorio", respuesta.errorBody().toString())
        }
    }
}