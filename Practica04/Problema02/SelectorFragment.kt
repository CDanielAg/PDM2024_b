package com.example.myapplication

import android.os.Bundle
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import android.widget.AdapterView
import android.widget.ArrayAdapter
import android.widget.Button
import android.widget.Spinner
import android.widget.Toast
import androidx.fragment.app.Fragment

class SelectorFragment : Fragment() {
    private var selectedItem = ""

    override fun onCreateView(
        inflater: LayoutInflater, container: ViewGroup?,
        savedInstanceState: Bundle?
    ): View? {
        val view = inflater.inflate(R.layout.fragment_selector, container, false)

        val spinner: Spinner = view.findViewById(R.id.spinner_img)
        val items = listOf("Imagen 1", "Imagen 2", "Imagen 3")
        val btn: Button = view.findViewById(R.id.Siguiente)

        // Configurar el adaptador del spinner
        val adapter = ArrayAdapter(requireContext(), android.R.layout.simple_spinner_item, items)
        adapter.setDropDownViewResource(android.R.layout.simple_spinner_dropdown_item)
        spinner.adapter = adapter

        // Configuración de la selección del spinner
        spinner.onItemSelectedListener = object : AdapterView.OnItemSelectedListener {
            override fun onItemSelected(parent: AdapterView<*>?, view: View?, position: Int, id: Long) {
                selectedItem = items[position]
                Toast.makeText(requireContext(), selectedItem, Toast.LENGTH_SHORT).show()
            }

            override fun onNothingSelected(parent: AdapterView<*>?) {}
        }

        // Botón para ir al fragmento de visualización
        btn.setOnClickListener {
            val transaction = parentFragmentManager.beginTransaction()
            transaction.replace(R.id.fragment_container, ImageFragment.newInstance(selectedItem))
            transaction.addToBackStack(null) // Añadir a la pila de retroceso
            transaction.commit() // Usar el commit tradicional
        }

        return view
    }
}
