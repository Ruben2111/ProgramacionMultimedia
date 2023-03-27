package com.example.app_ut2_04.datos

import com.example.app_ut2_04.R
import com.example.app_ut2_04.modelo.Animal

object DatosAnimales {
    fun getDatosAnimales(): ArrayList<Animal>
    {
        return arrayListOf<Animal>(
            Animal("Ballena", R.drawable.ballena,"Los mamiferos mas grandes de toda la tierra."),
            Animal("Bisonte", R.drawable.bisonte,"Animales peludos de la sabana africana."),
            Animal("Camaleon", R.drawable.camaleon,"Reptiles que se mimetizan con el ambiente."),
            Animal("Cebra", R.drawable.cebra,"Los animales que van en blanco y negro."),
            Animal("Cocodrilo", R.drawable.cocodrilo,"Uno de los drepredadores del rio Amazonas."),
            Animal("Elefante", R.drawable.elefante,"Se utilizan como monturas en la India."),
            Animal("Hipopotamo", R.drawable.hipopotamo,"A pesar de su apariencia inofensiva, son mortiferos."),
            Animal("Jirafa", R.drawable.jirafa,"Tienen el cuello largo para alimentarse de las hojas mas altas."),
            Animal("Mono", R.drawable.mono,"El animal mas parecido a los humanos."),
            Animal("Venado", R.drawable.venado,"Es un alimento muy nutritivo y delicioso."),
            Animal("Zorro", R.drawable.zorro,"Son pequeños, agiles y astutos."),
        )
    }
}