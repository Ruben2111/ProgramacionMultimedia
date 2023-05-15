package com.example.app_ut4_03.vistas

import android.os.Bundle
import androidx.fragment.app.Fragment
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import com.example.app_ut4_03.databinding.FragmentListaFavoritasBinding


class FragmentListaFavoritas : Fragment() {

    private lateinit var binding:FragmentListaFavoritasBinding

    override fun onCreateView(
        inflater: LayoutInflater, container: ViewGroup?,
        savedInstanceState: Bundle?
    ): View? {
        binding= FragmentListaFavoritasBinding.inflate(inflater,container,false)
        return binding.root
    }
}