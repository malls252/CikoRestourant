package com.example.cikorestourant.data

import androidx.compose.ui.graphics.vector.ImageVector
import androidx.compose.material.icons.Icons
import androidx.compose.material.icons.filled.*

data class MenuItem(
    val id: Int,
    val name: String,
    val price: Int,
    val description: String,
    val imageVector: ImageVector,
    val category: String
)

val sampleMenuItems = listOf(
    MenuItem(
        id = 1,
        name = "Nasi Goreng Spesial",
        price = 35000,
        description = "Nasi goreng dengan telur, ayam, udang, dan sayuran segar. Disajikan dengan kerupuk dan acar.",
        imageVector = Icons.Default.Restaurant,
        category = "Makanan"
    ),
    MenuItem(
        id = 2,
        name = "Mie Ayam Jamur",
        price = 28000,
        description = "Mie telur dengan topping ayam cincang, jamur, dan sawi hijau. Kuah kaldu ayam terpisah.",
        imageVector = Icons.Default.LunchDining,
        category = "Makanan"
    ),
    MenuItem(
        id = 3,
        name = "Sate Ayam Madura",
        price = 40000,
        description = "10 tusuk sate ayam dengan bumbu kacang spesial, lontong, dan sambal.",
        imageVector = Icons.Default.KebabDining,
        category = "Makanan"
    ),
    MenuItem(
        id = 4,
        name = "Es Teh Manis",
        price = 8000,
        description = "Teh hitam dengan gula aren dan es batu, segar dan manis.",
        imageVector = Icons.Default.LocalDrink,
        category = "Minuman"
    ),
    MenuItem(
        id = 5,
        name = "Jus Alpukat",
        price = 18000,
        description = "Jus alpukat segar dengan susu kental manis dan cokelat bubuk di atasnya.",
        imageVector = Icons.Default.Blender,
        category = "Minuman"
    ),
    MenuItem(
        id = 6,
        name = "Es Kopi Susu",
        price = 22000,
        description = "Kopi hitam dengan susu segar, gula aren, dan es batu.",
        imageVector = Icons.Default.Coffee,
        category = "Minuman"
    )
)
