package com.example.app_ut3_02.viewmodel

import androidx.lifecycle.MutableLiveData
import androidx.lifecycle.ViewModel
import androidx.lifecycle.viewModelScope
import com.example.app_ut3_02.model.Centro
import com.example.app_ut3_02.model.CentrosRepository
import kotlinx.coroutines.launch

class CentrosViewModel : ViewModel() {
    val centrosLiveData = MutableLiveData<List<Centro>>()

    private val repository = CentrosRepository()

    fun cargarDatos()
    {
        viewModelScope.launch {
            centrosLiveData.postValue(repository.get())
        }
    }
}