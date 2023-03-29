package com.example.app_ut2_04.datos

import com.example.app_ut2_04.R
import com.example.app_ut2_04.modelo.Animal


object DatosAnimales {
    fun getDatosAnimales(): ArrayList<Animal>
    {
        return arrayListOf<Animal>(
            Animal("Ballena", R.drawable.ballena,
                "Las ballenas son los animales más grandes que jamás hayan existido. No son peces, respiran aire a través de pulmones y dan a luz a crías vivas que se alimentan de leche materna.",0),
            Animal("Bisonte", R.drawable.bisonte,
                "Son bestias formidables, los animales terrestres más pesados de América del Norte. Su peso puede inclinar la balanza a más de una tonelada y tienen cuernos curvos y afilados.",0),
            Animal("Camaleon", R.drawable.camaleon,
                "Es un reptil de tamaño medio que en estado adulto alcanza hasta los 280-301 mm (incluyendo cola), si bien la media es menor. La longitud del cuerpo es de 145 mm.",0),
            Animal("Cebra", R.drawable.cebra,
                "Las cebras son animales sociales que viven en manadas. Pacen en grupo, normalmente hierba, e incluso se acicalan unas a otras. La especie más abundante es la cebra de llanura.",0),
            Animal("Cocodrilo", R.drawable.cocodrilo,
                "Se trata de la familia dominante de reptiles, caracterizados por su gran fuerza y agresividad y, además, son muy antiguos pues habitan desde hace unos 200 millones de años.",0),
            Animal("Elefante", R.drawable.elefante,
                "Son animales mamíferos, exclusivamente herbívoros cuya característica principal es su larga trompa y sus enormes orejas. Se organizan en manadas de unos 20 miembros.",0),
            Animal("Hipopotamo", R.drawable.hipopotamo,
                "El hipopótamo es un gran mamífero artiodáctilo fundamentalmente herbívoro. Es el tercer animal terrestre más grande del mundo, después del elefante y el rinoceronte blanco.",0),
            Animal("Jirafa", R.drawable.jirafa,
                "La jirafa es el animal terrestre más alto del mundo y uno de los protagonistas indiscutibles de la sabana africana. Esta peculiar especie puede llegar a medir 5 metros de altura.",0),
            Animal("Mono", R.drawable.mono,
                "Se llama mono a un animal mamífero y primate, que acompaña al ser humano en su clasificación zoológica y se le asemeja física y conductualmente más que cualquier otro animal del mundo.",0),
            Animal("Venado", R.drawable.venado,
                "Mamífero rumiante, de tamaño mediano, perteneciente a la familia de los cérvidos. Su cuerpo es esbelto, patas relativamente largas y delgadas y cola reducida.",0),
            Animal("Zorro", R.drawable.zorro,
                "Se conoce como zorro o raposos a unas diez especies de la familia de los cánidos, en apariencia semejantes a un perro de tamaño medio con orejas puntiagudas, hocico largo y delgado, y cola y cuerpo peludos.",0),
        )
    }
}