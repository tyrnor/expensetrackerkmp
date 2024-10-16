package com.carlosdev.expensetracker

import androidx.compose.foundation.shape.AbsoluteCutCornerShape
import androidx.compose.material.MaterialTheme
import androidx.compose.runtime.Composable
import androidx.compose.ui.Modifier
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.unit.dp

@Composable
fun AppTheme(content: @Composable () -> Unit) {
    MaterialTheme(
        colors = MaterialTheme.colors.copy(
            primary = Color.Black
        ),
        shapes = MaterialTheme.shapes.copy(
            small = AbsoluteCutCornerShape(0.dp),
            medium = AbsoluteCutCornerShape(0.dp),
            large = AbsoluteCutCornerShape(0.dp)
        )
    ) {
        content()
    }
}

@Composable
fun getColorsTheme(modifier: Modifier = Modifier) : AppThemeColors {
    val isDarkMode = false

    val purple = Color(0xFF6A66FF)
    val expenseItem = if (isDarkMode) Color(0xFF090808) else Color(0xFFF1F1F1)
    val background = if (isDarkMode) Color(0xFF1E1C1C) else Color.White
    val text = if (isDarkMode) Color.White else Color.Black
    val addIcon = if (isDarkMode) purple else Color.Black
    val arrowRound = if (isDarkMode) purple else Color.Gray.copy(alpha = 0.2f)

    return AppThemeColors(purple, expenseItem, background, text, addIcon, arrowRound)
}

data class AppThemeColors(
    val purple: Color,
    val expenseItem: Color,
    val background: Color,
    val text: Color,
    val addIcon: Color,
    val arrowRound: Color
)