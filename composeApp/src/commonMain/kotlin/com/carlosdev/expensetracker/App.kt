package com.carlosdev.expensetracker

import androidx.compose.runtime.Composable
import com.carlosdev.expensetracker.ui.ExpensesScreen
import moe.tlaster.precompose.PreComposeApp

@Composable
fun App() {

    val colors = getColorsTheme()

    PreComposeApp {
        AppTheme {
            ExpensesScreen()
        }
    }
}
