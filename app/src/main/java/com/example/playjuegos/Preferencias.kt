package com.example.playjuegos

import android.os.Bundle
import android.widget.Button
import android.widget.RadioButton
import android.widget.RadioGroup
import android.widget.RatingBar
import android.widget.SeekBar
import android.widget.Toast
import androidx.appcompat.app.AppCompatActivity
import com.google.android.material.floatingactionbutton.FloatingActionButton

class Preferencias : AppCompatActivity() {
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.preferences)

        // Inicializamos los componentes
        val rb = findViewById<RatingBar>(R.id.ratingBar)
        val sb = findViewById<SeekBar>(R.id.seekBar)
        val radioGroup = findViewById<RadioGroup>(R.id.radioGroup)
        val fab = findViewById<FloatingActionButton>(R.id.floatingActionButton)


        // RATINGBAR
        rb.onRatingBarChangeListener =
            RatingBar.OnRatingBarChangeListener { _, rating, _ ->
                sb.progress = rating.toInt()
            }

        // SEEKBAR
        sb.setOnSeekBarChangeListener(object : SeekBar.OnSeekBarChangeListener {
            override fun onProgressChanged(seekBar: SeekBar, progress: Int, fromUser: Boolean) {
                rb.rating = progress.toFloat()
            }

            override fun onStopTrackingTouch(seekBar: SeekBar) {}

            override fun onStartTrackingTouch(seekBar: SeekBar) {}

        })


        // Listener para el FAB (Boton)
        fab.setOnClickListener {
            val seleccionID = radioGroup.checkedRadioButtonId

            // Condicion que comprueba la seleccion
            if (seleccionID == -1) {
                Toast.makeText(
                    applicationContext,
                    "No has pulsado ninguna opción",
                    Toast.LENGTH_LONG
                ).show()
            } else {
                val seleccionBotonRad =
                    findViewById<RadioButton>(seleccionID) // Enlazara la seleccion del usuario con el boton radio
                val seleccionJuego =
                    seleccionBotonRad.text // Mostrará el texto del boton seleccionado
                val rating = rb.rating
                val mensaje =
                    "Has elegido: $seleccionJuego\nPuntuación: $rating" // Mostramos el mensaje
                Toast.makeText(applicationContext, mensaje, Toast.LENGTH_LONG).show()

            }
        }


    }

}