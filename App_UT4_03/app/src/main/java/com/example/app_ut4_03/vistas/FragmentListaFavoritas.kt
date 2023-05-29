package com.example.app_ut4_03.vistas

import android.app.NotificationChannel
import android.app.NotificationManager
import android.content.Context
import android.graphics.Color
import android.os.Build
import android.os.Bundle
import androidx.fragment.app.Fragment
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import androidx.core.app.NotificationCompat
import androidx.core.os.bundleOf
import androidx.fragment.app.activityViewModels
import androidx.navigation.NavController
import androidx.navigation.NavDeepLinkBuilder
import androidx.navigation.findNavController
import androidx.recyclerview.widget.LinearLayoutManager
import com.example.app_ut4_03.R
import com.example.app_ut4_03.databinding.FragmentListaFavoritasBinding
import com.example.app_ut4_03.modelo.Pelicula
import com.example.app_ut4_03.viewmodel.PeliculasViewModel


class FragmentListaFavoritas : Fragment() {

    private lateinit var binding:FragmentListaFavoritasBinding
    private lateinit var navController: NavController
    private val peliculasViewModel: PeliculasViewModel by activityViewModels { PeliculasViewModel.Factory}

    override fun onCreateView(
        inflater: LayoutInflater, container: ViewGroup?,
        savedInstanceState: Bundle?
    ): View? {
        binding= FragmentListaFavoritasBinding.inflate(inflater,container,false)
        return binding.root
    }

    override fun onViewCreated(view: View, savedInstanceState: Bundle?) {
        super.onViewCreated(view, savedInstanceState)

        navController = view.findNavController()

        peliculasViewModel.peliculasFavoritas.observe(viewLifecycleOwner){
            binding.apply {
                var lista=peliculasViewModel.peliculasFavoritas.value
                recyclerViewFavoritas.adapter = PeliculasAdapter(
                    lista,
                    onClickPelicula = { onClickPelicula(it) },
                    cambiarFavorita = { peliculasViewModel.cambiarFavorita(it.id)},
                    crearNotificacion = { crearNotificacion(it) }
                )
                recyclerViewFavoritas.layoutManager = LinearLayoutManager(context)
            }
        }
    }

    private fun onClickPelicula(pelicula: Pelicula)
    {
        val accion = FragmentListaFavoritasDirections.actionFragmentListaFavoritasToFragmentDetalle(pelicula=pelicula)
        navController.navigate(accion)
    }

    private fun crearNotificacion(pelicula: Pelicula)
    {
        val notificationManager = activity?.getSystemService(Context.NOTIFICATION_SERVICE) as NotificationManager
        val pendingIntent = NavDeepLinkBuilder(requireContext())
            .setComponentName(MainActivity::class.java)
            .setGraph(R.navigation.grafico_navegacion)
            .setDestination(R.id.fragmentDetalle, bundleOf("pelicula" to pelicula) )
            .createPendingIntent()

        // Comprobando si la versión es mayor que oreo(API 26)
        if (Build.VERSION.SDK_INT >= Build.VERSION_CODES.O) {
            val notificationChannel = NotificationChannel(getString(R.string.titulo), getString(R.string.sinopsis), NotificationManager.IMPORTANCE_HIGH)
            notificationChannel.enableLights(true)
            notificationChannel.lightColor = Color.GREEN
            notificationChannel.enableVibration(true)
            notificationManager.createNotificationChannel(notificationChannel)
        }

        val notificacion = NotificationCompat.Builder(requireContext(), "id")
            .setContentTitle(pelicula.titulo)
            .setContentText("Se ha quitado de favorita")
            .setSmallIcon(R.drawable.ic_imagen)
            .setPriority(NotificationCompat.PRIORITY_HIGH)
            .setContentIntent(pendingIntent).build()
        notificationManager.notify(1234, notificacion)
    }
}