package com.pepivsky.bottomnavigation.model

import android.os.Parcelable
import kotlinx.parcelize.Parcelize

@Parcelize
data class FlashCard(var concept: String?, var definition: String? ) : Parcelable
