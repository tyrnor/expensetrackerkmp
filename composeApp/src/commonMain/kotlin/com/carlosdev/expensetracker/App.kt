package com.carlosdev.expensetracker

import androidx.compose.runtime.Composable
import com.carlosdev.expensetracker.data.ExpenseManager
import com.carlosdev.expensetracker.presentation.ExpensesUiState
import com.carlosdev.expensetracker.ui.ExpensesScreen
import moe.tlaster.precompose.PreComposeApp

@Composable
fun App() {

    PreComposeApp {
        AppTheme {
            ExpensesScreen(
                uiState = ExpensesUiState(
                    expenses = ExpenseManager.fakeExpenseList,
                    total = ExpenseManager.fakeExpenseList.sumOf { it.amount }
                ),
                onExpenseClick = {}
            )
        }
    }
}
