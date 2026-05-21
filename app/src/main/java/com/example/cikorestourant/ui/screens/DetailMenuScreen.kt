package com.example.cikorestourant.ui.screens

import androidx.compose.foundation.background
import androidx.compose.foundation.layout.*
import androidx.compose.foundation.shape.RoundedCornerShape
import androidx.compose.material.icons.Icons
import androidx.compose.material.icons.automirrored.filled.ArrowBack
import androidx.compose.material3.*
import androidx.compose.runtime.Composable
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.draw.clip
import androidx.compose.ui.graphics.Brush
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.text.font.FontWeight
import androidx.compose.ui.unit.dp
import androidx.compose.ui.unit.sp
import androidx.navigation.NavController
import com.example.cikorestourant.data.sampleMenuItems

@OptIn(ExperimentalMaterial3Api::class)
@Composable
fun DetailMenuScreen(navController: NavController, menuId: String?) {
    val id = menuId?.toIntOrNull() ?: 1
    val menuItem = sampleMenuItems.find { it.id == id }

    Scaffold(
        containerColor = MaterialTheme.colorScheme.background,
        topBar = {
            TopAppBar(
                title = { Text("DETAIL MENU", fontWeight = FontWeight.ExtraBold) },
                navigationIcon = {
                    IconButton(onClick = { navController.navigateUp() }) {
                        Icon(Icons.AutoMirrored.Filled.ArrowBack, contentDescription = "Kembali")
                    }
                },
                colors = TopAppBarDefaults.topAppBarColors(
                    containerColor = MaterialTheme.colorScheme.primary,
                    titleContentColor = Color.Black,
                    navigationIconContentColor = Color.Black
                )
            )
        }
    ) { paddingValues ->
        if (menuItem != null) {
            Column(
                modifier = Modifier
                    .fillMaxSize()
                    .padding(paddingValues)
            ) {
                // Large Hero Section
                Box(
                    modifier = Modifier
                        .fillMaxWidth()
                        .height(300.dp)
                        .background(
                            Brush.verticalGradient(
                                listOf(MaterialTheme.colorScheme.primary, MaterialTheme.colorScheme.background)
                            )
                        ),
                    contentAlignment = Alignment.Center
                ) {
                    Surface(
                        modifier = Modifier.size(180.dp),
                        shape = RoundedCornerShape(24.dp),
                        color = Color.Black.copy(alpha = 0.1f)
                    ) {
                        Icon(
                            imageVector = menuItem.imageVector,
                            contentDescription = menuItem.name,
                            modifier = Modifier.padding(40.dp).size(100.dp),
                            tint = Color.Black
                        )
                    }
                }

                Column(
                    modifier = Modifier
                        .fillMaxWidth()
                        .padding(horizontal = 24.dp),
                    verticalArrangement = Arrangement.spacedBy(16.dp)
                ) {
                    Row(
                        modifier = Modifier.fillMaxWidth(),
                        horizontalArrangement = Arrangement.SpaceBetween,
                        verticalAlignment = Alignment.CenterVertically
                    ) {
                        Column {
                            Text(
                                text = menuItem.name,
                                fontSize = 32.sp,
                                fontWeight = FontWeight.ExtraBold,
                                color = MaterialTheme.colorScheme.onBackground
                            )
                            Text(
                                text = menuItem.category,
                                fontSize = 16.sp,
                                color = MaterialTheme.colorScheme.primary,
                                fontWeight = FontWeight.Bold
                            )
                        }
                    }

                    Text(
                        text = "Rp ${menuItem.price}",
                        fontSize = 28.sp,
                        fontWeight = FontWeight.ExtraBold,
                        color = MaterialTheme.colorScheme.primary
                    )

                    HorizontalDivider(color = MaterialTheme.colorScheme.onBackground.copy(alpha = 0.1f))

                    Text(
                        text = "Deskripsi",
                        fontWeight = FontWeight.Bold,
                        fontSize = 18.sp,
                        color = MaterialTheme.colorScheme.onBackground
                    )

                    Text(
                        text = menuItem.description,
                        fontSize = 15.sp,
                        lineHeight = 22.sp,
                        color = MaterialTheme.colorScheme.onBackground.copy(alpha = 0.7f)
                    )

                    Spacer(modifier = Modifier.weight(1f))

                    Button(
                        onClick = { /* Add to cart */ },
                        modifier = Modifier
                            .fillMaxWidth()
                            .height(60.dp)
                            .padding(bottom = 8.dp),
                        shape = RoundedCornerShape(16.dp),
                        colors = ButtonDefaults.buttonColors(
                            containerColor = MaterialTheme.colorScheme.primary,
                            contentColor = Color.Black
                        )
                    ) {
                        Text("PESAN SEKARANG", fontWeight = FontWeight.ExtraBold, fontSize = 16.sp)
                    }
                }
            }
        }
    }
}
