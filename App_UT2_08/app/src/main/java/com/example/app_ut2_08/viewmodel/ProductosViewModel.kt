package com.example.app_ut2_08.viewmodel

import androidx.lifecycle.LiveData
import androidx.lifecycle.MutableLiveData
import androidx.lifecycle.ViewModel
import com.example.app_ut2_08.datos.Datos
import com.example.app_ut2_08.modelo.Producto

class ProductosViewModel: ViewModel()
{
    private val _listaCategorias = MutableLiveData<List<String>>()
    private val _listaProductos = MutableLiveData<List<Producto>>()
    private val _listaCompra = MutableLiveData<List<Producto>>()

    val listaCategorias: LiveData<List<String>> = _listaCategorias
    val listaProductos: LiveData<List<Producto>> = _listaProductos
    val listaCompra: LiveData<List<Producto>> = _listaCompra

    fun cargarCategorias()
    {
        _listaCategorias.postValue(Datos.nombresCategorias())
    }
    fun cargarProductos(categoria: String)
    {
        _listaProductos.postValue(Datos.getProductosCategoria(categoria))
    }
    fun insertarCesta(producto: Producto)
    {
        _listaCompra.value = _listaCompra.value?.plus(producto) ?: listOf(producto)
    }
}
