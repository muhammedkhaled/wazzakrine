package com.muhkhaled.wazzakrine.core.presentation.theme

import androidx.compose.foundation.isSystemInDarkTheme
import androidx.compose.material.MaterialTheme
import androidx.compose.material.darkColors
import androidx.compose.material.lightColors
import androidx.compose.runtime.Composable

private val DarkColorPalette = darkColors(

)

private val LightColorPalette = lightColors(
    primary = SeaGreen,
    onPrimary = White,
    primaryVariant = PhilippineGreen,
    onSecondary = White,
    background = Cultured,
    onBackground = DarkSlateGray,
    surface = White,
    onSurface = ViridianGreen,
    error = AlabamaCrimson,
    onError = White
)

@Composable
fun WazzakrineTheme(darkTheme: Boolean = isSystemInDarkTheme(), content: @Composable () -> Unit) {
    val colors = if (darkTheme) {
        DarkColorPalette
    } else {
        LightColorPalette
    }

    MaterialTheme(
        colors = colors,
        typography = Typography,
        shapes = Shapes,
        content = content
    )
}