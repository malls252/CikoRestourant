package com.example.cikorestourant.ui.navigation

import androidx.compose.foundation.layout.Box
import androidx.compose.foundation.layout.fillMaxSize
import androidx.compose.material3.Text
import androidx.compose.runtime.*
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.platform.LocalContext
import androidx.navigation.NavHostController
import androidx.navigation.NavType
import androidx.navigation.compose.NavHost
import androidx.navigation.compose.composable
import androidx.navigation.navArgument
import com.example.cikorestourant.ui.screens.*
import com.example.cikorestourant.utils.SharedPrefsManager

@Composable
fun NavGraph(
    navController: NavHostController,
    modifier: Modifier = Modifier
) {
    val context = LocalContext.current
    val sharedPrefsManager = remember { SharedPrefsManager(context) }

    // State untuk refresh ProfileScreen setelah edit
    var refreshTrigger by remember { mutableStateOf(0) }

    NavHost(
        navController = navController,
        startDestination = "home",
        modifier = modifier
    ) {
        composable("home") {
            HomeScreen(navController, sharedPrefsManager)
        }

        composable("menu") {
            MenuScreen(navController)
        }

        composable(
            "detail/{menuId}",
            arguments = listOf(navArgument("menuId") { type = NavType.StringType })
        ) { backStackEntry ->
            val menuId = backStackEntry.arguments?.getString("menuId")
            DetailMenuScreen(navController, menuId)
        }

        composable("profile") {
            ProfileScreen(navController, sharedPrefsManager, refreshTrigger)
        }

        composable("edit-profile") {
            EditProfileScreen(
                navController = navController,
                sharedPrefsManager = sharedPrefsManager,
                onSaveSuccess = { refreshTrigger++ }
            )
        }

        composable("contact") {
            Box(modifier = Modifier.fillMaxSize(), contentAlignment = Alignment.Center) {
                Text("Halaman Kontak (Coming Soon)")
            }
        }
    }
}
