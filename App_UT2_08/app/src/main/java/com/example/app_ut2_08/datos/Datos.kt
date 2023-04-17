package com.example.app_ut2_08.datos

import com.example.app_ut2_08.R
import com.example.app_ut2_08.modelo.Categoria
import com.example.app_ut2_08.modelo.Producto

object Datos
{
    private val categorias = listOf<Categoria>(
        Categoria("Fruta",
            listOf<Producto>(
                Producto(1, "Manzanas", R.drawable.manzanas),
                Producto(2, "Peras", R.drawable.peras),
                Producto(3, "Plátanos", R.drawable.platanos),
                Producto(4, "Mandarinas", R.drawable.mandarinas),
            )
        ),
        Categoria("Legumbres",
            listOf<Producto>(
                Producto(5, "Alubias", R.drawable.alubias),
                Producto(6, "Arroz largo", R.drawable.arroz_largo),
                Producto(7, "Arroz redondo", R.drawable.arroz_redondo),
                Producto(8, "Garbanzos", R.drawable.garbanzos),
                Producto(9, "Lentejas", R.drawable.lentejas),
            )
        ),
        Categoria("Carnicería",
            listOf<Producto>(
                Producto(10, "Pollo", R.drawable.pollo),
                Producto(11, "Pavo", R.drawable.pavo),
                Producto(12, "Cerdo", R.drawable.cerdo),
                Producto(13, "Conejo", R.drawable.conejo),
                Producto(14, "Cordero", R.drawable.cordero),
                Producto(15, "Ternera", R.drawable.ternera),
            )
        ),
        Categoria("Refrescos",
            listOf<Producto>(
                Producto(16, "Cola", R.drawable.cola),
                Producto(17, "Naranja", R.drawable.naranja),
                Producto(18, "Limón", R.drawable.limon),
                Producto(19, "Tónica", R.drawable.tonica)
            )
        )
    )

    fun nombresCategorias(): List<String>
    {
        var lista= arrayListOf<String>()
        categorias.forEach { c -> lista.add(c.nombre) }
        return lista
    }

    fun getProductosCategoria(nombre: String): List<Producto>
    {
        var lista= arrayListOf<Producto>()
        categorias.forEach { c ->
            if(c.nombre.equals(nombre)){
                c.productos.forEach { p -> lista.add(p) }
            }
        }
        return lista
    }
}