package com.example.interaccinconimgenes

import android.media.MediaPlayer
import android.os.Bundle
import android.view.View
import android.widget.Button
import androidx.appcompat.app.AppCompatActivity
import androidx.constraintlayout.widget.ConstraintLayout

class MainActivity2 : AppCompatActivity() {
    private var mediaPlayer: MediaPlayer? = null
    private var musica: Int = R.raw.audio01

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_main2)

        val selectedItem = intent.getStringExtra("selectedItem")

        // Obtener el ConstraintLayout
        val layout = findViewById<ConstraintLayout>(R.id.main)

        // Cambiar la música según la selección
        musica = when (selectedItem) {
            "sound 1" -> R.raw.audio01
            "sound 2" -> R.raw.audio02
            "sound 3" -> R.raw.audio03
            "sound 4" -> R.raw.audio04
            else -> R.raw.audio05
        }

        // Botón Volver
        val backButton: Button = findViewById(R.id.volver)
        backButton.setOnClickListener {
            finish()
        }

        // Configurar botones
        val playButton: Button = findViewById(R.id.button2)
        playButton.setOnClickListener {
            music(it)
        }

        val pauseButton: Button = findViewById(R.id.button3)
        pauseButton.setOnClickListener {
            pauseMusic()
        }
    }

    private fun stopMusic() {
        mediaPlayer?.release()
        mediaPlayer = null
    }

    private fun pauseMusic() {
        mediaPlayer?.pause()
    }

    private fun playMusic() {
        if (mediaPlayer == null) {
            mediaPlayer = MediaPlayer.create(this, musica)
            mediaPlayer?.setOnCompletionListener {
                stopMusic()
            }
        }

        mediaPlayer?.start()
    }

    fun music(view: View) {
        when (view.id) {
            R.id.button2 -> playMusic()
            R.id.button3 -> pauseMusic()
            else -> {
                mediaPlayer?.stop()
                stopMusic()
            }
        }
    }

    override fun onDestroy() {
        super.onDestroy()
        stopMusic()
    }
}
