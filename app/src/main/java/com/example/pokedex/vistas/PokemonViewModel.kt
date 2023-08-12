package com.example.pokedex.vistas

import android.app.Application
import androidx.lifecycle.AndroidViewModel
import androidx.lifecycle.viewModelScope
import com.example.pokedex.data.Repositorio
import com.example.pokedex.data.local.PokeBaseDatos
import com.example.pokedex.data.remote.PokeRetrofit
import kotlinx.coroutines.launch

class PokemonViewModel(application: Application) : AndroidViewModel(application) {

    private val repositorio: Repositorio

    fun pokemonLiveData() = repositorio.obtenerPokemonEntity()

    init {
        val pokeApi = PokeRetrofit.getPokeRetrofit()
        val pokeDataBase = PokeBaseDatos.getDataBase(application).getPokeDao()
        repositorio = Repositorio(pokeApi, pokeDataBase)

    }
    fun getAllPokemones() = viewModelScope.launch {
        repositorio.getPokemones()
    }
}