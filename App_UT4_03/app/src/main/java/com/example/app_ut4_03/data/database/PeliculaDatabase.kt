package com.example.app_ut4_03.data.database

import android.content.Context
import androidx.room.Database
import androidx.room.Room
import androidx.room.RoomDatabase
import com.example.app_ut4_03.modelo.Critica
import com.example.app_ut4_03.modelo.Pelicula


@Database(
    entities = [Pelicula::class, Critica::class],
    version = 1
)
abstract class PeliculaDatabase:RoomDatabase()
{
    abstract fun peliculaDao():PeliculaDao

    companion object {
        private var INSTANCE: PeliculaDatabase? = null
        fun getDatabase(context: Context): PeliculaDatabase
        {
            if (INSTANCE == null) {
                synchronized(this) {
                    INSTANCE =
                        Room.databaseBuilder(context,PeliculaDatabase::class.java, "peliculas.db")
                            .createFromAsset("peliculas-copiar.db")
                            .build()
                }
            }
            return INSTANCE!!
        }
    }

}