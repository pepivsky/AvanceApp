package com.pepivsky.bottomnavigation

import android.content.res.ColorStateList
import android.graphics.Color
import android.os.Bundle
import android.text.Editable
import android.text.TextWatcher
import android.util.Log
import androidx.fragment.app.Fragment
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import android.widget.Button
import android.widget.EditText
import android.widget.Toast
import androidx.recyclerview.widget.LinearLayoutManager
import androidx.recyclerview.widget.RecyclerView
import com.google.android.material.floatingactionbutton.FloatingActionButton
import com.pepivsky.bottomnavigation.model.FlashCard
import com.pepivsky.bottomnavigation.model.FlashCardAdapter


class CreateCollectionFragment : Fragment() {

    private lateinit var rvNewCard: RecyclerView
    private lateinit var fabAdd: FloatingActionButton
    private lateinit var btnGuardar: Button
    private lateinit var edtTitle: EditText
    private lateinit var edtDescription: EditText

    private lateinit var adapter: FlashCardAdapter

    val flashCards = mutableListOf<FlashCard>()



    override fun onCreateView(
        inflater: LayoutInflater, container: ViewGroup?,
        savedInstanceState: Bundle?
    ): View? {
        // Inflate the layout for this fragment
        return inflater.inflate(R.layout.fragment_create_collection, container, false)

    }

    override fun onViewCreated(view: View, savedInstanceState: Bundle?) {
        super.onViewCreated(view, savedInstanceState)

        //binding
        rvNewCard = view.findViewById(R.id.rviNewItems)
        fabAdd = view.findViewById(R.id.fabAdd)
        btnGuardar = view.findViewById(R.id.btnGuardar)
        edtTitle = view.findViewById(R.id.edtTitle)
        edtDescription = view.findViewById(R.id.edtDescription)


        flashCards.add(FlashCard(null, null))// primer item

        initRecycler()





        //agregar otro item
        fabAdd.setOnClickListener {
            flashCards.add(FlashCard(null, null))
            adapter.notifyItemInserted(flashCards.size -1 )
            Toast.makeText(context, "Agregado! Size ${flashCards.size}", Toast.LENGTH_SHORT).show()

        }

        //guardar los objetos
        btnGuardar.setOnClickListener {
            Log.i("myTag", "$flashCards")
            Log.i("size", "${flashCards.size}")
            /*val holder : FlashCardAdapter.FlashcardHolder
            holder.saveFlashCard()*/

        }


    }

    private fun initRecycler() {
        rvNewCard.layoutManager = LinearLayoutManager(context, LinearLayoutManager.VERTICAL, false)
        adapter = FlashCardAdapter(flashCards)
        rvNewCard.adapter = adapter

    }
}