package com.example.app_ut2_03

import android.annotation.SuppressLint
import android.graphics.Color
import android.graphics.drawable.Drawable
import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.widget.*


class MainActivity : AppCompatActivity() {
    private var precio:Double = 0.0

    @SuppressLint("UseSwitchCompatOrMaterialCode")
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_main)

        var imagen=findViewById<ImageView>(R.id.imageViewDestino)

        val grupo=findViewById<RadioGroup>(R.id.radioGrupo)
        grupo.setOnCheckedChangeListener { p0, p1 ->
            cambioOpcion(p1)
        }

        val switch=findViewById<Switch>(R.id.switchIva)
        switch.setOnCheckedChangeListener { compoundButton, b ->
            cambioSwitch()
        }

        val mostrar=findViewById<Button>(R.id.botonMostrar)
        mostrar.setOnClickListener(){
            var id=grupo.checkedRadioButtonId
            when(id){
                R.id.radioPeninsula -> imagen.setImageResource(R.drawable.costa_peninsular)
                R.id.radioIslas -> imagen.setImageResource(R.drawable.costa_insular)
                R.id.radioInterior -> imagen.setImageResource(R.drawable.turismo_interior)
            }
        }
    }

    @SuppressLint("UseSwitchCompatOrMaterialCode")
    private fun cambioOpcion(radioId: Int){
        precio=
            when(radioId) {
                R.id.radioPeninsula -> 600.0
                R.id.radioIslas ->900.0
                R.id.radioInterior->520.0
                else -> 0.0
            }

        val switch=findViewById<Switch>(R.id.switchIva)
        if(switch.isChecked){
            precio*=1.21
        }

        val texto=findViewById<TextView>(R.id.textViewPrecio)
        texto.text= precio.toString()

        color()
    }

    @SuppressLint("UseSwitchCompatOrMaterialCode")
    private fun cambioSwitch() {
        val switch=findViewById<Switch>(R.id.switchIva)
        if(switch.isChecked){
            precio*=1.21
        }else{
            precio/=1.21
        }
        val texto=findViewById<TextView>(R.id.textViewPrecio)
        texto.text= precio.toString()

        color()
    }

    private fun color(){
        val texto=findViewById<TextView>(R.id.textViewPrecio)
        val presupuesto=findViewById<EditText>(R.id.editTextPresupuesto).text.toString().toDoubleOrNull()

        if (presupuesto != null) {
            if(presupuesto>precio){
                texto.setTextColor(Color.GREEN)
            }else{
                texto.setTextColor(Color.RED)
            }
        }
    }
}