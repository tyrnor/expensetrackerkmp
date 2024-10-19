package com.carlosdev.expensetracker

import androidx.compose.runtime.Composable
import androidx.compose.runtime.getValue
import com.carlosdev.expensetracker.data.ExpenseManager
import com.carlosdev.expensetracker.data.repository.ExpenseRepositoryImpl
import com.carlosdev.expensetracker.presentation.ExpensesViewModel
import com.carlosdev.expensetracker.ui.ExpensesScreen
import moe.tlaster.precompose.PreComposeApp
import moe.tlaster.precompose.flow.collectAsStateWithLifecycle

@Composable
fun App() {

    PreComposeApp {

        val viewModel = ExpensesViewModel(ExpenseRepositoryImpl(ExpenseManager))
        val uiState by viewModel.uiState.collectAsStateWithLifecycle()

        AppTheme {
            ExpensesScreen(
                uiState = uiState,
                onExpenseClick = {}
            )
        }
    }
}
