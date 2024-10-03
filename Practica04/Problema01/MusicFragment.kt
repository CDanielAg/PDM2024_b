package com.example.interaccinconimgenes

import android.media.MediaPlayer
import android.os.Bundle
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import android.widget.Button
import androidx.constraintlayout.widget.ConstraintLayout
import androidx.fragment.app.Fragment

class MusicFragment : Fragment() {
    private var mediaPlayer: MediaPlayer? = null
    private var musica: Int = R.raw.audio01

    override fun onCreateView(
        inflater: LayoutInflater, container: ViewGroup?,
        savedInstanceState: Bundle?
    ): View? {
        val view = inflater.inflate(R.layout.fragment_music, container, false)

        val selectedItem = arguments?.getString("selectedItem")

        // Obtener el ConstraintLayout
        val layout = view.findViewById<ConstraintLayout>(R.id.main)

        // Cambiar la música según la selección
        musica = when (selectedItem) {
            "sound 1" -> R.raw.audio01
            "sound 2" -> R.raw.audio02
            "sound 3" -> R.raw.audio03
            "sound 4" -> R.raw.audio04
            else -> R.raw.audio05
        }

        // Botón Volver
        val backButton: Button = view.findViewById(R.id.volver)
        backButton.setOnClickListener {
            parentFragmentManager.popBackStack() // Volver al fragmento anterior
        }

        // Configurar botones
        val playButton: Button = view.findViewById(R.id.button2)
        playButton.setOnClickListener {
            playMusic()
        }

        val pauseButton: Button = view.findViewById(R.id.button3)
        pauseButton.setOnClickListener {
            pauseMusic()
        }

        return view
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
            mediaPlayer = MediaPlayer.create(requireContext(), musica)
            mediaPlayer?.setOnCompletionListener {
                stopMusic()
            }
        }

        mediaPlayer?.start()
    }

    override fun onDestroyView() {
        super.onDestroyView()
        stopMusic()
    }

    companion object {
        fun newInstance(selectedItem: String): MusicFragment {
            val fragment = MusicFragment()
            val args = Bundle()
            args.putString("selectedItem", selectedItem)
            fragment.arguments = args
            return fragment
        }
    }
}
