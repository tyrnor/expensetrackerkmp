package com.carlosdev.expensetracker.navigation

import androidx.compose.runtime.Composable
import androidx.compose.runtime.getValue
import com.carlosdev.expensetracker.data.ExpenseManager
import com.carlosdev.expensetracker.data.repository.ExpenseRepositoryImpl
import com.carlosdev.expensetracker.presentation.ExpensesViewModel
import moe.tlaster.precompose.flow.collectAsStateWithLifecycle
import moe.tlaster.precompose.navigation.NavHost
import moe.tlaster.precompose.navigation.Navigator

@Composable
fun Navigation(navigator: Navigator) {
    val viewModel = ExpensesViewModel(ExpenseRepositoryImpl(ExpenseManager))
    val uiState by viewModel.uiState.collectAsStateWithLifecycle()

    NavHost() {

    }
}