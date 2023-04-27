package com.example.examenabril_rubenecheverria.datos

import com.example.examenabril_rubenecheverria.R
import com.example.examenabril_rubenecheverria.modelo.Participante

object DatosParticipantes {
    val participantes = listOf<Participante>(
        Participante("Karmento", "Quiero y Duelo", R.drawable.karmento, 35, 20, 0, false),
        Participante("Megara", "Arcadia", R.drawable.megara, 50, 28, 0, false),
        Participante("Alice Wonder", "Yo Quisiera", R.drawable.alice_wonder, 53,16,0, false),
        Participante("Fusa Nocta", "Mi Familia", R.drawable.fusa_nocta, 24, 25, 0, false),
        Participante("Agoney", "Quiero arder", R.drawable.agoney, 80,30,0, false),
        Participante("Blanca Paloma", "Eaea", R.drawable.blanca_paloma, 94,35,0, false),
        Participante("José Otero", "Inviernos en Marte", R.drawable.jose_otero, 37,22,0, false),
        Participante("Vicco", "Nochentera", R.drawable.vicco, 59,40,0, true)
    )
}