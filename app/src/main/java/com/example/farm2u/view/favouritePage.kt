package com.example.farm2u.view

import androidx.compose.foundation.Image
import androidx.compose.foundation.clickable
import androidx.compose.foundation.layout.*
import androidx.compose.foundation.lazy.LazyColumn
import androidx.compose.foundation.lazy.items
import androidx.compose.foundation.shape.CircleShape
import androidx.compose.foundation.shape.RoundedCornerShape
import androidx.compose.material3.*
import androidx.compose.runtime.*
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.draw.clip
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.res.painterResource
import androidx.compose.ui.text.font.FontWeight
import androidx.compose.ui.unit.dp
import androidx.compose.ui.unit.sp
import androidx.navigation.NavController
import com.example.farm2u.R

@OptIn(ExperimentalMaterial3Api::class)
@Composable
fun Favourites(navController: NavController) {
    var searchQuery by remember { mutableStateOf("") }

    val farmers = listOf(
        Triple("Ramesh", "\"I have been growing organic wheat for years.\"", "Sold 50kg of wheat"),
        Triple("Suresh", "\"Rice and maize farming has been in my family for generations.\"", "Supplied 10kg of maize"),
        Triple("Mahesh", "\"I take pride in growing fresh vegetables with natural methods.\"", "Supplied 30kg of fresh veggies"),
        Triple("Khuresh", "\"Wheat farming is my passion, and I ensure quality in every harvest.\"", "Sold 15kg of wheat"),
        Triple("Syama", "\"For years, I have cultivated rice and maize with dedication.\"", "Supplied 10kg of maize"),
        Triple("Rahul", "\"Growing vegetables using traditional techniques is my way of life.\"", "Supplied 3kg of fresh veggies"),
        Triple("Debadatta", "\"I focus on natural farming techniques for the best wheat quality.\"", "Sold 5kg of wheat"),
        Triple("Rabi", "\"Maize farming has been my work and passion since childhood.\"", "Supplied 10kg of maize"),
        Triple("Mahi", "\"I love providing fresh vegetables directly from my farm.\"", "Supplied 30kg of fresh veggies")
    )

    // Map farmer names to corresponding image resources
    val farmerImages = mapOf(
        "Ramesh" to R.drawable.farmer_1,
        "Suresh" to R.drawable.farmer_2,
        "Mahesh" to R.drawable.placeholdersky,
        "Khuresh" to R.drawable.img_11,
        "Syama" to R.drawable.img_12,
        "Rahul" to R.drawable.img_13,
        "Debadatta" to R.drawable.img_14,
        "Rabi" to R.drawable.img_15,
        "Mahi" to R.drawable.img_16
    )

    Box(modifier = Modifier.fillMaxSize()) {
        // Background image
        Image(
            painter = painterResource(id = R.drawable.img_3),
            contentDescription = "Background Image",
            modifier = Modifier
                .fillMaxSize()
                .align(Alignment.Center)
        )

        // Main content over the background
        Column(modifier = Modifier.fillMaxSize()) {
            // Top Navbar
            TopAppBar(
                title = { Text(text = "Favourites") },
            )

            // LazyColumn to make the content scrollable
            LazyColumn(
                modifier = Modifier
                    .fillMaxSize()
                    .padding(horizontal = 16.dp, vertical = 8.dp)
            ) {
                item {
                    // Search bar
                    OutlinedTextField(
                        value = searchQuery,
                        onValueChange = { searchQuery = it },
                        modifier = Modifier.fillMaxWidth(),
                        placeholder = { Text(text = "Search farmers...") },
                        colors = TextFieldDefaults.textFieldColors(containerColor = Color.White)
                    )
                    Spacer(modifier = Modifier.height(16.dp))
                }

                // Filter farmers based on search query
                val filteredFarmers = farmers.filter {
                    it.first.contains(searchQuery, ignoreCase = true)
                }

                // Display filtered farmers
                items(filteredFarmers) { (name, description, previousDeals) ->
                    Card(
                        modifier = Modifier
                            .fillMaxWidth()
                            .padding(vertical = 10.dp)
                            .clickable {
                                navController.navigate("farmer_details/$name/$description/$previousDeals")
                            },
                        shape = RoundedCornerShape(12.dp),
                        elevation = CardDefaults.cardElevation(6.dp),
                        colors = CardDefaults.cardColors(containerColor = Color.White)
                    ) {
                        Row(
                            modifier = Modifier.padding(16.dp),
                            horizontalArrangement = Arrangement.spacedBy(16.dp)
                        ) {
                            // Assign the correct image for each farmer
                            val farmerImage = farmerImages[name] ?: R.drawable.farmer

                            Image(
                                painter = painterResource(id = farmerImage),
                                contentDescription = "Farmer Image",
                                modifier = Modifier
                                    .size(80.dp)
                                    .clip(CircleShape) // Makes the image circular
                            )

                            Column {
                                Text(text = name, fontSize = 18.sp, fontWeight = FontWeight.Bold, color = Color.Black)
                                Text(text = description, fontSize = 14.sp, color = Color.Gray)
                                Text(text = previousDeals, fontSize = 12.sp, color = Color.DarkGray)
                            }
                        }
                    }
                }
            }
        }
    }
}
