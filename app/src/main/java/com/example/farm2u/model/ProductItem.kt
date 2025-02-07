package com.example.farm2u.model

data class ProductItem(
    val id: Int,
    val name: String,
    val farmerName: String,
    val quantity: String,
    val image: Int,
    val price: Double,
    val category: String // <-- Add this field
)
