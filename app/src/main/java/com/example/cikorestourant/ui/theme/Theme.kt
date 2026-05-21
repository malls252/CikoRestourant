package com.example.cikorestourant.ui.theme

import android.app.Activity
import androidx.compose.foundation.isSystemInDarkTheme
import androidx.compose.material3.MaterialTheme
import androidx.compose.material3.darkColorScheme
import androidx.compose.material3.lightColorScheme
import androidx.compose.runtime.Composable
import androidx.compose.runtime.SideEffect
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.graphics.toArgb
import androidx.compose.ui.platform.LocalView
import androidx.core.view.WindowCompat

private val DarkColorScheme = darkColorScheme(
    primary = BrightYellow,
    onPrimary = PureBlack,
    primaryContainer = DeepYellow,
    onPrimaryContainer = PureBlack,
    secondary = DeepYellow,
    onSecondary = PureBlack,
    background = PureBlack,
    onBackground = Color.White,
    surface = DarkGrey,
    onSurface = Color.White,
    surfaceVariant = RichBlack,
    onSurfaceVariant = Color.LightGray
)

private val LightColorScheme = lightColorScheme(
    primary = DeepYellow,
    onPrimary = PureBlack,
    primaryContainer = SoftYellow,
    onPrimaryContainer = PureBlack,
    secondary = RichBlack,
    onSecondary = Color.White,
    background = LightGrey,
    onBackground = PureBlack,
    surface = Color.White,
    onSurface = PureBlack,
    surfaceVariant = Color(0xFFE0E0E0),
    onSurfaceVariant = PureBlack
)

@Composable
fun CikoRestourantTheme(
    darkTheme: Boolean = isSystemInDarkTheme(),
    // Disable dynamic color to maintain our brand identity
    dynamicColor: Boolean = false,
    content: @Composable () -> Unit
) {
    val colorScheme = if (darkTheme) DarkColorScheme else LightColorScheme
    
    val view = LocalView.current
    if (!view.isInEditMode) {
        SideEffect {
            val window = (view.context as Activity).window
            window.statusBarColor = colorScheme.primary.toArgb()
            WindowCompat.getInsetsController(window, view).isAppearanceLightStatusBars = !darkTheme
        }
    }

    MaterialTheme(
        colorScheme = colorScheme,
        typography = Typography,
        content = content
    )
}
