package com.example.myapplication

import android.annotation.SuppressLint
import android.os.Bundle
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import android.widget.Button
import androidx.constraintlayout.widget.ConstraintLayout
import androidx.fragment.app.Fragment

class ImageFragment : Fragment() {
    private var selectedItem: String? = null

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        arguments?.let {
            selectedItem = it.getString(ARG_SELECTED_ITEM)
        }
    }

    @SuppressLint("MissingInflatedId")
    override fun onCreateView(
        inflater: LayoutInflater, container: ViewGroup?,
        savedInstanceState: Bundle?
    ): View? {
        val view = inflater.inflate(R.layout.fragment_image, container, false)
        val layout: ConstraintLayout = view.findViewById(R.id.main)

        when (selectedItem) {
            "Imagen 1" -> layout.setBackgroundResource(R.drawable.ifa0001)
            "Imagen 2" -> layout.setBackgroundResource(R.drawable.ifa0002)
            "Imagen 3" -> layout.setBackgroundResource(R.drawable.ifa0003)
        }

        val backButton: Button = view.findViewById(R.id.volver)
        backButton.setOnClickListener {
            parentFragmentManager.popBackStack()
        }

        return view
    }

    companion object {
        private const val ARG_SELECTED_ITEM = "selectedItem"

        fun newInstance(selectedItem: String) = ImageFragment().apply {
            arguments = Bundle().apply {
                putString(ARG_SELECTED_ITEM, selectedItem)
            }
        }
    }
}
