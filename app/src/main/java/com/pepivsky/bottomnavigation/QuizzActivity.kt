package com.pepivsky.bottomnavigation

import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.util.Log
import com.pepivsky.bottomnavigation.model.Collections

class QuizzActivity : AppCompatActivity() {
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_quizz)

        //obtener el extra con el index
        var bundle :Bundle ? = intent.extras
        var index = bundle!!.getInt("pos") // 1
        Log.i("quizzActivity", "$index     ${ Collections.collectionsList[index]}")

        //Collections.collectionsList[message]
    }
}