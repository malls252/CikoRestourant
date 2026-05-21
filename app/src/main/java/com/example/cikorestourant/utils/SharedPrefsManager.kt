package com.example.cikorestourant.utils

import android.content.Context
import android.content.SharedPreferences

data class RestaurantProfile(
    val name: String,
    val address: String,
    val description: String,
    val operatingHours: String
)

class SharedPrefsManager(context: Context) {
    private val prefs: SharedPreferences = context.getSharedPreferences("restaurant_prefs", Context.MODE_PRIVATE)

    fun saveProfile(profile: RestaurantProfile) {
        prefs.edit().apply {
            putString("restaurant_name", profile.name)
            putString("restaurant_address", profile.address)
            putString("restaurant_description", profile.description)
            putString("restaurant_hours", profile.operatingHours)
            apply()
        }
    }

    fun getProfile(): RestaurantProfile {
        return RestaurantProfile(
            name = prefs.getString("restaurant_name", "Ciko Restourant") ?: "Ciko Restourant",
            address = prefs.getString("restaurant_address", "Jl. Makan Enak No. 123, Jakarta") ?: "Jl. Makan Enak No. 123, Jakarta",
            description = prefs.getString("restaurant_description", "Restoran keluarga yang menyajikan berbagai masakan Nusantara dan internasional dengan cita rasa autentik.") ?: "Restoran keluarga yang menyajikan berbagai masakan Nusantara dan internasional dengan cita rasa autentik.",
            operatingHours = prefs.getString("restaurant_hours", "Senin - Minggu: 10:00 - 22:00") ?: "Senin - Minggu: 10:00 - 22:00"
        )
    }
}
