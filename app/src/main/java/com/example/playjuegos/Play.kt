package com.example.playjuegos

import android.os.Bundle
import android.widget.CheckBox
import android.widget.Toast
import androidx.appcompat.app.AppCompatActivity
import com.google.android.material.floatingactionbutton.FloatingActionButton

class Play : AppCompatActivity()
{
    override fun onCreate(savedInstanceState: Bundle?)
    {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.games)

        // Inicializamos las Referencias a los CheckBox
        val checkBox1 = findViewById<CheckBox>(R.id.checkBoxAngry)
        val checkBox2 = findViewById<CheckBox>(R.id.checkBoxDragon)
        val checkBox3 = findViewById<CheckBox>(R.id.checkBoxRacing)
        val checkBox4 = findViewById<CheckBox>(R.id.checkBoxDefense)
        val checkBox5 = findViewById<CheckBox>(R.id.checkBoxSoccer)
        val checkBox6 = findViewById<CheckBox>(R.id.checkBoxNinja)
        val checkBox7 = findViewById<CheckBox>(R.id.checkBoxAir)

        // Hacemos referencia al boton "fab"
        val fab = findViewById<FloatingActionButton>(R.id.floatingActionButton)

        // Codigo al hacer click al boton
        fab.setOnClickListener{
            // Crearemos una lista para las selecciones
            val opcionesSelec = mutableListOf<String>()

            // Condiciones que se añaden a la lista anterior si son seleccionados
            if (checkBox1.isChecked) opcionesSelec.add("Angry Birds")
            if (checkBox2.isChecked) opcionesSelec.add("Dragon City")
            if (checkBox3.isChecked) opcionesSelec.add("Hill Climbing Racing")
            if (checkBox4.isChecked) opcionesSelec.add("Radiant Defense")
            if (checkBox5.isChecked) opcionesSelec.add("Pocket Soccer")
            if (checkBox6.isChecked) opcionesSelec.add("Ninja Jump")
            if (checkBox7.isChecked) opcionesSelec.add("Air Control")

            // Condicion para comprobar si hay o no algun checkbox seleccionado en la lista "opcionesSelec"
            if (opcionesSelec.isEmpty())
            {
                Toast.makeText(this, "No has seleccionado ninguna opción.", Toast.LENGTH_LONG).show()
            } else {
                var mensaje = "Has elegido: "
                for (opcion in opcionesSelec)
                {
                    mensaje += "$opcion, "
                }

                Toast.makeText(this, mensaje.trim(), Toast.LENGTH_SHORT).show()
            }
        }

    }
}