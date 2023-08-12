package com.example.pokedex.data.local

import android.content.Context
import androidx.room.Database
import androidx.room.Room
import androidx.room.RoomDatabase

@Database(entities = [PokeEntity::class], version = 1)
abstract class PokeBaseDatos:RoomDatabase() {
    abstract fun getPokeDao(): PokeDao

    companion object {
        @Volatile
        private var INSTANCE: PokeBaseDatos? = null

        fun getDataBase(context: Context): PokeBaseDatos {
            val tempInstance = INSTANCE
            if (tempInstance != null) {
                return tempInstance
            }
            synchronized(this) {
                val instance = Room.databaseBuilder(
                    context.applicationContext,
                    PokeBaseDatos::class.java,
                    "razas_database"
                ).build()

                INSTANCE = instance
                return instance
            }
        }
    }
}

