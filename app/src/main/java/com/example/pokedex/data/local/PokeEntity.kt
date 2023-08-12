package com.example.pokedex.data.local

import androidx.room.Entity
import androidx.room.PrimaryKey

@Entity(tableName = "tabla_pokemon")
data class PokeEntity(@PrimaryKey val name: String, val url: String)
