package com.example.interaccinconimgenes

import android.os.Bundle
import android.widget.Button
import androidx.appcompat.app.AppCompatActivity
import androidx.constraintlayout.widget.ConstraintLayout

class MainActivity2 : AppCompatActivity() {
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_main2)

        val selectedItem = intent.getStringExtra("selectedItem")

        // Obtener el ConstraintLayout
        val layout = findViewById<ConstraintLayout>(R.id.main)

        // Cambiar el fondo
        when (selectedItem) {
            "Imagen 1" -> layout.setBackgroundResource(R.drawable.ifa0001)
            "Imagen 2" -> layout.setBackgroundResource(R.drawable.ifa0002)
            "Imagen 3" -> layout.setBackgroundResource(R.drawable.ifa0003)
        }

        // botón Volver
        val backButton: Button = findViewById(R.id.volver)
        backButton.setOnClickListener {
            finish()
        }
    }
}