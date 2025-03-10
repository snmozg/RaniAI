package com.sozge.raniai.ui.theme

import androidx.compose.foundation.isSystemInDarkTheme
import androidx.compose.material3.MaterialTheme
import androidx.compose.material3.darkColorScheme
import androidx.compose.material3.lightColorScheme
import androidx.compose.runtime.Composable

private val DarkColorScheme = darkColorScheme(
    primary = ownPurple,
    secondary = ownPink,
    background = ownBlack,
    onBackground = ownWhite,
    tertiary = ownGray
)

private val LightColorScheme = lightColorScheme(
    primary = ownPurple,
    secondary = ownPink,
    background = ownBlack,
    onBackground = ownWhite,
    tertiary = ownGray
)

@Composable
fun RaniAITheme(
    darkTheme: Boolean = isSystemInDarkTheme(),
    content: @Composable () -> Unit,
) {
    val colors = if (darkTheme) {
        DarkColorScheme
    } else {
        LightColorScheme
    }
    MaterialTheme(
        colorScheme = colors,
        typography = Typography,
        content = content
    )
}