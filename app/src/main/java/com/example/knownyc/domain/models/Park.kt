package com.example.knownyc.domain.models

import androidx.annotation.DrawableRes

data class Park(
    val parkGISpropNum: String,
    val name: String,
    val address: String,
    val URL: String,
    val waterFront: Boolean,
    @DrawableRes val image: Int,
)
