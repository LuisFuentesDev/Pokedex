package com.example.pokedex.data.local

import androidx.lifecycle.LiveData
import androidx.room.Dao
import androidx.room.Insert
import androidx.room.OnConflictStrategy
import androidx.room.Query
import com.example.pokedex.data.remote.PokeDatos

@Dao
interface PokeDao {
    @Insert(onConflict = OnConflictStrategy.REPLACE)
    suspend fun insertPokemon(pokeEntities: List<PokeEntity>)

    @Query("SELECT * FROM tabla_pokemon ORDER BY name ASC")
    fun getPokemon(): LiveData<List<PokeEntity>>
}