package com.example.cikorestourant.ui.screens

import androidx.compose.foundation.layout.*
import androidx.compose.foundation.rememberScrollState
import androidx.compose.foundation.verticalScroll
import androidx.compose.material.icons.Icons
import androidx.compose.material.icons.automirrored.filled.ArrowBack
import androidx.compose.material.icons.filled.*
import androidx.compose.material3.*
import androidx.compose.runtime.*
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.text.font.FontWeight
import androidx.compose.ui.unit.dp
import androidx.compose.ui.unit.sp
import androidx.navigation.NavController
import com.example.cikorestourant.utils.RestaurantProfile
import com.example.cikorestourant.utils.SharedPrefsManager

@OptIn(ExperimentalMaterial3Api::class)
@Composable
fun EditProfileScreen(
    navController: NavController,
    sharedPrefsManager: SharedPrefsManager,
    onSaveSuccess: () -> Unit
) {
    val currentProfile = remember { sharedPrefsManager.getProfile() }

    var name by remember { mutableStateOf(currentProfile.name) }
    var address by remember { mutableStateOf(currentProfile.address) }
    var description by remember { mutableStateOf(currentProfile.description) }
    var hours by remember { mutableStateOf(currentProfile.operatingHours) }

    Scaffold(
        topBar = {
            TopAppBar(
                title = { Text("Edit Profil Restoran", fontWeight = FontWeight.Bold) },
                navigationIcon = {
                    IconButton(onClick = { navController.navigateUp() }) {
                        Icon(Icons.AutoMirrored.Filled.ArrowBack, contentDescription = "Batal/Kembali")
                    }
                },
                colors = TopAppBarDefaults.topAppBarColors(
                    containerColor = MaterialTheme.colorScheme.primary,
                    titleContentColor = MaterialTheme.colorScheme.onPrimary,
                    navigationIconContentColor = MaterialTheme.colorScheme.onPrimary
                )
            )
        }
    ) { paddingValues ->
        Column(
            modifier = Modifier
                .fillMaxSize()
                .padding(paddingValues)
                .verticalScroll(rememberScrollState())
                .padding(24.dp),
            verticalArrangement = Arrangement.spacedBy(20.dp)
        ) {
            Text(
                text = "Edit Informasi Restoran",
                fontSize = 20.sp,
                fontWeight = FontWeight.Bold,
                color = MaterialTheme.colorScheme.primary
            )

            // Form Nama
            OutlinedTextField(
                value = name,
                onValueChange = { name = it },
                label = { Text("Nama Restoran") },
                leadingIcon = { Icon(Icons.Default.Restaurant, contentDescription = null) },
                modifier = Modifier.fillMaxWidth(),
                singleLine = true
            )

            // Form Alamat
            OutlinedTextField(
                value = address,
                onValueChange = { address = it },
                label = { Text("Alamat") },
                leadingIcon = { Icon(Icons.Default.LocationOn, contentDescription = null) },
                modifier = Modifier.fillMaxWidth(),
                minLines = 2
            )

            // Form Deskripsi
            OutlinedTextField(
                value = description,
                onValueChange = { description = it },
                label = { Text("Deskripsi") },
                leadingIcon = { Icon(Icons.Default.Description, contentDescription = null) },
                modifier = Modifier.fillMaxWidth(),
                minLines = 3
            )

            // Form Jam Buka
            OutlinedTextField(
                value = hours,
                onValueChange = { hours = it },
                label = { Text("Jam Buka") },
                leadingIcon = { Icon(Icons.Default.Schedule, contentDescription = null) },
                modifier = Modifier.fillMaxWidth(),
                singleLine = true,
                placeholder = { Text("Contoh: Senin - Minggu: 10:00 - 22:00") }
            )

            Spacer(modifier = Modifier.height(8.dp))

            // Tombol Simpan
            Button(
                onClick = {
                    val newProfile = RestaurantProfile(name, address, description, hours)
                    sharedPrefsManager.saveProfile(newProfile)
                    onSaveSuccess()
                    navController.navigateUp()
                },
                modifier = Modifier.fillMaxWidth(),
                colors = ButtonDefaults.buttonColors(
                    containerColor = MaterialTheme.colorScheme.primary
                )
            ) {
                Icon(Icons.Default.Save, contentDescription = null)
                Spacer(modifier = Modifier.width(8.dp))
                Text("Simpan Perubahan", fontSize = 16.sp)
            }

            // Tombol Batal
            OutlinedButton(
                onClick = { navController.navigateUp() },
                modifier = Modifier.fillMaxWidth()
            ) {
                Icon(Icons.Default.Cancel, contentDescription = null)
                Spacer(modifier = Modifier.width(8.dp))
                Text("Batal", fontSize = 16.sp)
            }
        }
    }
}
