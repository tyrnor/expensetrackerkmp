package com.carlosdev.expensetracker

import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.fillMaxSize
import androidx.compose.material.Text
import androidx.compose.runtime.Composable
import androidx.compose.ui.Modifier
import moe.tlaster.precompose.PreComposeApp

@Composable
fun App() {

    val colors = getColorsTheme()

    PreComposeApp {
        AppTheme {
            Column (modifier = Modifier.fillMaxSize()){
                Text("Test text", color = colors.text)
            }
        }
    }
}
