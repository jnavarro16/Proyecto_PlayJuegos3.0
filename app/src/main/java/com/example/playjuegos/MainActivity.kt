package com.example.playjuegos

import android.content.Intent
import android.os.Bundle
import android.view.Menu
import android.view.MenuItem
import android.widget.Button
import android.widget.Toast
import androidx.appcompat.app.AppCompatActivity
import com.google.android.material.chip.ChipGroup

// Actividad principal de la aplicación
class MainActivity : AppCompatActivity()
{
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)

        // Establecemos el contenido de la vista utilizando el layout de activity_main.xml
        setContentView(R.layout.activity_main)

        // Cambiar el color de la barra de notificaciones
        // window.statusBarColor = resources.getColor(R.color.purpura_osc, null)

        // Obtenemos la referencia al botón "jugador" desde el layout
        val jugador: Button = findViewById(R.id.botonNewPlayer)

        // Configuramos el listener para el botón que se acciona al pulsar
        jugador.setOnClickListener {
            lanzarNewPlayer()
            Toast.makeText(this, "New Player", Toast.LENGTH_SHORT).show()
        }

        // Obtenemos la referencia al botón "Preferencias" desde el layout
        val preferencias: Button = findViewById(R.id.botonPreferencies)
        preferencias.setOnClickListener {
            lanzarPreferences()
            Toast.makeText(this, "Preferencias", Toast.LENGTH_SHORT).show()
        }

        // Obtenemos la referencia al botón "play" desde el layout
        val play: Button = findViewById(R.id.botonPlay)
        play.setOnClickListener {
            lanzarPlay()
            Toast.makeText(this, "Play", Toast.LENGTH_SHORT).show()
        }
    }


    // Método para lanzar la actividad NewPlayer
    fun lanzarNewPlayer() {
        val i = Intent(this, NewPlayer::class.java)
        startActivity(i) // Iniciamos la nueva actividad
    }

    // Método para lanzar la actividad Preferences
    fun lanzarPreferences() {
        val i = Intent(this, Preferencias::class.java)
        startActivity(i) // Iniciamos la actividad
    }

    // Método para lanzar la actividad Play
    fun lanzarPlay() {
        val i = Intent(this, Play::class.java)
        startActivity(i) // Iniciamos la actividad
    }

    override fun onCreateOptionsMenu(menu: Menu?): Boolean {
        menuInflater.inflate(R.menu.menu_main, menu) // Inflar el menú
        return true
    }

    override fun onOptionsItemSelected(item: MenuItem): Boolean {
        val id = item.itemId

        if (id == R.id.action_search) {
            Toast.makeText(this, "Búsqueda", Toast.LENGTH_LONG).show()
            setContentView(R.layout.chip_group);

            // Obtenemos la referencia al grupo de Botones 1
            val chipGrupo1: ChipGroup = findViewById(R.id.grupoChip)

            // Configuramos el listener
            chipGrupo1.setOnCheckedStateChangeListener  { group, checkedId ->
                if (checkedId.isNotEmpty())
                {
                    // Obtenemos el chip seleccionado
                    val selectedChip = group.findViewById<com.google.android.material.chip.Chip>(checkedId[0])
                    val chipText = selectedChip.text.toString() // Cogemos el texto del chip seleccionado

                    // Mostramos el texto del Chip
                    Toast.makeText(this, "$chipText", Toast.LENGTH_SHORT).show()
                }
            }

            // Hacemos otra configuracion para el 2 Grupo de Chips (Genero)
            // Obtenemos la referencia al grupo de Botones 1
            val chipGrupo2: ChipGroup = findViewById(R.id.grupoChipGeneros2)

            // Configuramos el listener
            chipGrupo2.setOnCheckedStateChangeListener  { group, checkedId ->
                if (checkedId.isNotEmpty())
                {
                    // Obtenemos el chip seleccionado
                    val selectedChip = group.findViewById<com.google.android.material.chip.Chip>(checkedId[0])
                    val chipText = selectedChip.text.toString() // Cogemos el texto del chip seleccionado

                    // Mostramos el texto del Chip
                    Toast.makeText(this, "$chipText", Toast.LENGTH_SHORT).show()
                }
            }


            return true
        }

        return super.onOptionsItemSelected(item)
    }
}
