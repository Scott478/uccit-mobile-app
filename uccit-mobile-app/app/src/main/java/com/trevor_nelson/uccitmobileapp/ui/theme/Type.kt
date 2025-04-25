package com.trevor_nelson.uccitmobileapp.ui.theme

import androidx.compose.foundation.isSystemInDarkTheme
import androidx.compose.material3.MaterialTheme
import androidx.compose.material3.darkColorScheme
import androidx.compose.material3.lightColorScheme
import androidx.compose.runtime.Composable

private val LightColorScheme = lightColorScheme(
    primary = UccRed,
    secondary = UccBlue,
    tertiary = UccGold,
    background = LightBackground,
    surface = LightBackground,
    onPrimary = LightBackground,
    onSecondary = LightBackground,
    onBackground = UccBlue,
    onSurface = UccBlue
)

private val DarkColorScheme = darkColorScheme(
    primary = UccRed,
    secondary = UccBlue,
    tertiary = UccGold,
    background = DarkBackground,
    surface = DarkBackground,
    onPrimary = DarkBackground,
    onSecondary = DarkBackground,
    onBackground = UccGold,
    onSurface = UccGold
)

@Composable
fun UCCITMobileAppTheme(
    darkTheme: Boolean = isSystemInDarkTheme(),
    content: @Composable () -> Unit
) {
    MaterialTheme(
        colorScheme = if (darkTheme) DarkColorScheme else LightColorScheme,
        typography = AppTypography,
        content = content
    )
}