package com.example.footprynt.ui

import androidx.compose.foundation.isSystemInDarkTheme
import androidx.compose.material3.MaterialTheme
import androidx.compose.material3.Typography
import androidx.compose.material3.lightColorScheme
import androidx.compose.material3.darkColorScheme
import androidx.compose.runtime.Composable
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.text.TextStyle
import androidx.compose.ui.text.font.FontFamily
import androidx.compose.ui.text.font.FontWeight
import androidx.compose.ui.unit.sp

private val DarkColorScheme = darkColorScheme(
    primary = Color(0xFF22C55E),
    secondary = Color(0xFF0EA5E9),
    tertiary = Color(0xFF121F33)
)

private val LightColorScheme = lightColorScheme(
    primary = Color(0xFF22C55E),
    secondary = Color(0xFF0EA5E9),
    tertiary = Color(0xFF0B1222),
    background = Color.White,
    surface = Color.White,
    onPrimary = Color.White,
    onSecondary = Color.White,
    onTertiary = Color.White,
    onBackground = Color(0xFF0B1222),
    onSurface = Color(0xFF0B1222),
)

val Typography = Typography(
    displayMedium = TextStyle(
        fontFamily = FontFamily.Default,
        fontWeight = FontWeight.Bold,
        fontSize = 54.sp,
        letterSpacing = (-1).sp,
        color = Color(0xFF0B1222)
    ),
    labelSmall = TextStyle(
        fontFamily = FontFamily.Default,
        fontWeight = FontWeight.Medium,
        fontSize = 13.sp,
        letterSpacing = 5.sp,
        color = Color(0xFF64748B)
    )
)

@Composable
fun FootpryntTheme(
    darkTheme: Boolean = isSystemInDarkTheme(),
    content: @Composable () -> Unit
) {
    val colorScheme = if (darkTheme) DarkColorScheme else LightColorScheme

    MaterialTheme(
        colorScheme = colorScheme,
        typography = Typography,
        content = content
    )
}
