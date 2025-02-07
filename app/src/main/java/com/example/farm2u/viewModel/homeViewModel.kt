package com.example.farm2u.viewModel

import androidx.compose.runtime.mutableStateOf
import androidx.lifecycle.ViewModel
import com.example.farm2u.R
import com.example.farm2u.model.CategoryItems
import com.example.farm2u.model.ProductItem
import kotlin.random.Random

class HomeViewModel : ViewModel() {
    val searchText = mutableStateOf("")
    val selectedCategory = mutableStateOf("All") // Default to all products

    // List of product categories
    val categoryItems = listOf(
        CategoryItems("All", R.drawable.basket),
        CategoryItems("Fruits", R.drawable.fruits),
        CategoryItems("Vegetables", R.drawable.vegetable),
        CategoryItems("Grains", R.drawable.grains),
        CategoryItems("Combo Packs", R.drawable.img_18) // New category for combos
    )

    // List of products including combo packs
    val productItems = listOf(
        // Individual products
        ProductItem(1, "Tomato", "Ramu's Farm", "${Random.nextInt(1, 100)} KG", R.drawable.tomato, 50.0, "Vegetables"),
        ProductItem(2, "Potato", "Kalia's Farm", "${Random.nextInt(1, 100)} KG", R.drawable.potato, 30.0, "Vegetables"),
        ProductItem(3, "Apple", "Ramesh's Farm", "${Random.nextInt(1, 100)} KG", R.drawable.apple, 100.0, "Fruits"),
        ProductItem(4, "Banana", "Suresh's Farm", "${Random.nextInt(1, 100)} KG", R.drawable.banana, 40.0, "Fruits"),
        ProductItem(5, "Carrot", "Raju's Farm", "${Random.nextInt(1, 100)} KG", R.drawable.carrot, 60.0, "Vegetables"),
        ProductItem(6, "Wheat", "Jaya's Farm", "${Random.nextInt(1, 100)} KG", R.drawable.wheat, 25.0, "Grains"),
        ProductItem(7, "Rice", "Sai's Farm", "${Random.nextInt(1, 100)} KG", R.drawable.rice, 35.0, "Grains"),
        ProductItem(8, "Jowar", "Rabi's Farm", "${Random.nextInt(1, 100)} KG", R.drawable.jowar, 45.0, "Grains"),
        ProductItem(9, "Onion", "Titu's Farm", "${Random.nextInt(1, 100)} KG", R.drawable.onion, 55.0, "Vegetables"),

        // Combo Packs (new category)
        ProductItem(10, "Combo Pack 1", "Farmer's Special", "Tomato + Potato + Onion (3 KG each)", R.drawable.img_9, 120.0, "Combo Packs"),
        ProductItem(11, "Combo Pack 2", "Healthy Mix", "Carrot + Tomato + Onion (4 KG each)", R.drawable.img_17, 150.0, "Combo Packs")
    )

    // Function to get filtered products based on the selected category
    fun getFilteredProducts(): List<ProductItem> {
        return if (selectedCategory.value == "All") {
            productItems
        } else {
            productItems.filter { it.category == selectedCategory.value }
        }
    }
}
