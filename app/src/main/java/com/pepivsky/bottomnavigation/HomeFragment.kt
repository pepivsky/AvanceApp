package com.pepivsky.bottomnavigation

import android.os.Bundle
import androidx.fragment.app.Fragment
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import android.widget.EditText
import androidx.recyclerview.widget.LinearLayoutManager
import androidx.recyclerview.widget.RecyclerView
import com.pepivsky.bottomnavigation.model.Collection
import com.pepivsky.bottomnavigation.model.CollectionAdapter


class HomeFragment : Fragment() {

    private lateinit var rvCollections: RecyclerView
    private lateinit var edtBuscar: EditText

    val collections = mutableListOf(
        Collection("Verbos ingles"),
        Collection("Fundamentos de POO"),
        Collection("Patologias"),
        Collection("tipos de notas musicales"),
        Collection("Probando si el textview se puede ajustar y leerse bien cuando es largo")



    )

    //val lista = MutableListOf
    val listaColecciones = mutableListOf<Collection>()

    override fun onCreateView(
        inflater: LayoutInflater, container: ViewGroup?,
        savedInstanceState: Bundle?
    ): View? {
        // Inflate the layout for this fragment
        return inflater.inflate(R.layout.fragment_home, container, false)
    }

    override fun onViewCreated(view: View, savedInstanceState: Bundle?) {
        super.onViewCreated(view, savedInstanceState)

        rvCollections = view.findViewById(R.id.rvCollections)
        edtBuscar = view.findViewById(R.id.edtSearch)

        initRecycler()

        /*edtBuscar.setFocusableInTouchMode(false);
        edtBuscar.setFocusable(false);
        edtBuscar.setFocusableInTouchMode(true);
        edtBuscar.setFocusable(true);*/

    }

    fun initRecycler() {
        rvCollections.layoutManager = LinearLayoutManager(context, LinearLayoutManager.HORIZONTAL, false)
        val adapter = CollectionAdapter(collections) //se le pasa la lista
        rvCollections.adapter = adapter
    }

}

