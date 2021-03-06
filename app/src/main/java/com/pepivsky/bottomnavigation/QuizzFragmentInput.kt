package com.pepivsky.bottomnavigation

import android.os.Bundle
import androidx.fragment.app.Fragment
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import android.widget.Button
import android.widget.EditText
import android.widget.TextView
import com.pepivsky.bottomnavigation.model.FlashCard

// TODO: Rename parameter arguments, choose names that match
// the fragment initialization parameters, e.g. ARG_ITEM_NUMBER
private const val ARG_CARD = "card"

/**
 * A simple [Fragment] subclass.
 * Use the [QuizzFragmentInput.newInstance] factory method to
 * create an instance of this fragment.
 */
class QuizzFragmentInput : Fragment(), View.OnClickListener {
    // TODO: Rename and change types of parameters
    var card: FlashCard? = null

    lateinit var tvConceptInput: TextView
    lateinit var edtConcept: EditText
    lateinit var btnContinue: Button

    //listener
    private var callback: OnButtonListener? = null //instancia de la interface, este es asignadoa al boton


    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        arguments?.let {
            card = it.getParcelable(ARG_CARD)
        }
    }

    override fun onCreateView(
        inflater: LayoutInflater, container: ViewGroup?,
        savedInstanceState: Bundle?
    ): View? {
        val view = inflater.inflate(R.layout.fragment_quizz_input, container, false)
        // Inflate the layout for this fragment
        tvConceptInput = view.findViewById(R.id.tvConceptInput)
        edtConcept = view.findViewById(R.id.edtConceptInput)
        btnContinue = view.findViewById(R.id.btnContitnuarInput)

        tvConceptInput.text = card?.concept //setear el valor del card

        //onclick del boton
        btnContinue.setOnClickListener {
            callback?.onButtonClicked()
        }
        return view

    }

    companion object {
        /**
         * Use this factory method to create a new instance of
         * this fragment using the provided parameters.
         *
         * @param param1 Parameter 1.
         * @param param2 Parameter 2.
         * @return A new instance of fragment QuizzFragmentInput.
         */
        // TODO: Rename and change types and number of parameters
        @JvmStatic
        fun newInstance(card: FlashCard?) =
            QuizzFragmentInput().apply {
                arguments = Bundle().apply {
                    putParcelable(ARG_CARD, card) //aqui se le puede pasar cualquier cosa

                }
            }
    }

    fun setOnButtonListener(callback: OnButtonListener) { //setter
        this.callback = callback

    }

    //interface para que el activity controle el onClic y pueda crear fragments
    interface OnButtonListener{
        fun onButtonClicked()
    }

    override fun onClick(v: View?) {
        //callback
    }
}