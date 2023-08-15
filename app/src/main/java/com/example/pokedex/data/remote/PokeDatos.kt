package com.example.pokedex.data.remote
data class Poke(val name:String, val url:String)
data class PokeDatos(
    val results: List<Poke>

)
