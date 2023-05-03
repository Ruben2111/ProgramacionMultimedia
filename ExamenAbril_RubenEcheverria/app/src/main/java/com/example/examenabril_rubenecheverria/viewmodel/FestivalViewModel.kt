package com.example.examenabril_rubenecheverria.viewmodel

import androidx.lifecycle.LiveData
import androidx.lifecycle.MutableLiveData
import androidx.lifecycle.ViewModel
import androidx.lifecycle.map
import com.example.examenabril_rubenecheverria.datos.DatosParticipantes
import com.example.examenabril_rubenecheverria.modelo.Participante
import com.example.examenabril_rubenecheverria.modelo.puntos

class FestivalViewModel:ViewModel()
{
    private val _listaParticipantes = MutableLiveData<List<Participante>>()
    private val _listaFavoritos = MutableLiveData<List<Participante>>()

    val listaParticipantes: LiveData<List<Participante>> = _listaParticipantes
    val listaFavoritos: LiveData<List<Participante>> = _listaFavoritos

    init
    {
        _listaParticipantes.postValue(DatosParticipantes.participantes)
    }

    fun participantesOrdenados():LiveData<List<Participante>>
    {
        return _listaParticipantes.map { it.sortedByDescending {it.puntos()}}
    }

    fun cargarFavoritos(){
        val lista = ArrayList<Participante>()
        DatosParticipantes.participantes.forEach { x->
            if(x.favorito){
                lista.add(x)
            }
        }

        _listaFavoritos.postValue(lista)
    }

    fun cambiarFavorito(participante:Participante){
        participante.favorito = !participante.favorito
    }
}