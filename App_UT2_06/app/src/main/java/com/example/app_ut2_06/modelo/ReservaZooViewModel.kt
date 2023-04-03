package com.example.app_ut2_06.modelo

import androidx.lifecycle.LiveData
import androidx.lifecycle.MutableLiveData
import androidx.lifecycle.ViewModel
import java.util.*

private const val PRECIO_ADULTO = 5.0
private const val PRECIO_NINO = 2.0

class ReservaZooViewModel : ViewModel(){
    private val _tipoReserva = MutableLiveData<String>()
    private val _fecha = MutableLiveData<Calendar>()
    private val _numeroAdultos = MutableLiveData<Int>()
    private val _numeroNinos = MutableLiveData<Int>()
    private val _precio = MutableLiveData<Double>()

    val tipoReserva: LiveData<String> = _tipoReserva
    val fecha :LiveData<Calendar> = _fecha
    val numeroAdultos :LiveData<Int> = _numeroAdultos
    val numeroNinos :LiveData<Int> = _numeroNinos
    val precio :LiveData<Double> = _precio

    fun setTipoReserva(tipo: String)
    {
        _tipoReserva.value = tipo
    }
    fun setFecha(fecha: Calendar)
    {
        _fecha.value = fecha
        actualizarPrecio()
    }
    fun setNumeroAdultos(numero: Int)
    {
        _numeroAdultos.value = numero
        actualizarPrecio()
    }
    fun setNumeroNinos(numero: Int)
    {
        _numeroNinos.value = numero
        actualizarPrecio()
    }

    private fun actualizarPrecio()
    {
        var precioCalculado = (numeroAdultos.value ?: 0) * PRECIO_ADULTO + (numeroNinos.value ?: 0) * PRECIO_NINO

        //Fecha sábado o domingo -> 1€ más por persona
        if((fecha.value?.get(Calendar.DAY_OF_WEEK) ?: -1) == Calendar.SATURDAY
            || (fecha.value?.get(Calendar.DAY_OF_WEEK) ?: -1) == Calendar.SUNDAY)
        {
            precioCalculado+= ((numeroAdultos.value ?: 0) + ( numeroNinos.value ?: 0))
        }
        _precio.value = precioCalculado
    }

    fun resetearReserva()
    {
        _fecha.value = Calendar.getInstance()
        _numeroNinos.value = 0
        _numeroAdultos.value = 1
        _tipoReserva.value = ""
        actualizarPrecio()
    }

    init
    {
        resetearReserva()
    }
}