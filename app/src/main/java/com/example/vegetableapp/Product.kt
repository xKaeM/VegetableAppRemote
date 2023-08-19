package com.example.vegetableapp

import androidx.annotation.DrawableRes
import androidx.annotation.StringRes

data class Product(
    @StringRes val productName: Int,
    @DrawableRes val productImage: Int,
    val price: Double,
    @StringRes val poundsOrEach: Int
)
