package com.example.proyectoprueba.viewmodel

import androidx.lifecycle.LiveData
import androidx.lifecycle.MutableLiveData
import androidx.lifecycle.ViewModel
import com.example.proyectoprueba.data.api.DatosSelecciones
import com.example.proyectoprueba.modelo.Equipo

class EquiposViewModel : ViewModel()
{
    private val _listaEquipos = MutableLiveData<List<Equipo>>()
    private val _listaFavoritos = MutableLiveData<List<Equipo>>()

    val listaEquipos: LiveData<List<Equipo>> = _listaEquipos
    val listaFavoritos: LiveData<List<Equipo>> = _listaFavoritos

    fun cargarEquipos()
    {
        _listaEquipos.postValue(DatosSelecciones.equipos)
    }

    fun equiposFavoritos()
    {
        val lista = ArrayList<Equipo>()
        DatosSelecciones.equipos.forEach { x->
            if(x.favorito){
                lista.add(x)
            }
        }

        _listaFavoritos.postValue(lista)
    }
}