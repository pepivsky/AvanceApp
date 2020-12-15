package com.pepivsky.bottomnavigation.model

import android.media.Image

data class Collection(val tittle: String, val listCard: MutableList<FlashCard>)

//object statico
object Collections {
    val collectionsList = mutableListOf<Collection>()
}

