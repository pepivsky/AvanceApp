package com.pepivsky.bottomnavigation

import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.util.Log
import android.widget.Toast
import com.pepivsky.bottomnavigation.model.Collection
import com.pepivsky.bottomnavigation.model.Collections
import com.pepivsky.bottomnavigation.model.FlashCard

class QuizzActivity : AppCompatActivity(),  CardFragment.OnButtonListener {

    //private val cardsList = MutableList<FlashCard>()
    var cardsList = mutableListOf<FlashCard>()

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_quizz)

        //obtener el extra con el index
        var bundle: Bundle? = intent.extras
        var index = bundle!!.getInt("pos") // 1
        Log.i("quizzActivity", "$index     ${Collections.collectionsList[index]}")

        //obteniendo el arrayList
        cardsList = bundle.getParcelableArrayList<FlashCard>("lsitaTarjetas")!!
        Log.i("lista recibida", "$cardsList")

        //Collections.collectionsList[message]

        /*val collection = Collections.collectionsList[index]
        cardsList = collection.listCard
        Log.i("testeandoLista", "${cardsList}")*/

        //private val cardsList = mutableListOf<Card>

        newFragmentCard()
    }

    fun sacarTarjeta(): FlashCard {
        val rand =
            (0 until cardsList.size).random() //obtiendo un numero entre 0 y el tamano de la lista
        val card = cardsList[rand] //extrayendo un valor de la lista
        //eliminar el item
        cardsList.removeAt(rand) //quitando la palabra de la lista

        return card
    }

    fun newFragmentCard() { //funcion que crea fragments
        val card = sacarTarjeta()
        val fragment = CardFragment.newInstance(card) //pasandole el string que necesita el fragment

        //seteando el onButtonListener
        fragment.setOnButtonListener(this)

        //fragment.setOnbuttonListener(this)
        supportFragmentManager //TODO implemetar animaciones
            .beginTransaction()
            .setCustomAnimations(R.anim.slide_out_left, R.anim.slide_in_right)
            .replace(R.id.container, fragment)//conteneror y fragment por el cual se reemplaza
            .commit()

    }

    //Al darle clic al boton, se lanza este metodo que crea nuevos Fragments
    override fun onButtonClicked() { //funcion sobreescrita que viene en la interfaz
        if (cardsList.isNotEmpty()) { //si todavia hay elementos en mi lista puedo crear mas fragemnts
            newFragmentCard()
        } else {
            Toast.makeText(this, "No hay mas tarjetas", Toast.LENGTH_LONG).show()
        }
    }
}
