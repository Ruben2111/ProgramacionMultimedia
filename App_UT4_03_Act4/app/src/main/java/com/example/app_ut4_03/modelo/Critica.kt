package com.example.app_ut4_03.modelo

import androidx.room.ColumnInfo
import androidx.room.Entity
import androidx.room.ForeignKey
import androidx.room.ForeignKey.CASCADE
import androidx.room.PrimaryKey
import java.io.Serializable

@Entity(tableName = "criticas",
    foreignKeys =
        [ForeignKey(
            entity = Pelicula::class,
            childColumns = ["pelicula_id"],
            parentColumns = ["id"],
            onDelete = CASCADE)
        ]
    )
data class Critica (
    @PrimaryKey(autoGenerate = true)
    val id:Long,
    val texto: String,
    val valoracion:String,
    @ColumnInfo(name="pelicula_id")
    val peliculaId:Long

    ): Serializable