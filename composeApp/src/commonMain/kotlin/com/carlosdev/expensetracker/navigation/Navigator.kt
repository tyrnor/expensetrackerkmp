package com.carlosdev.expensetracker.navigation

import androidx.compose.foundation.background
import androidx.compose.runtime.Composable
import androidx.compose.runtime.getValue
import androidx.compose.ui.Modifier
import com.carlosdev.expensetracker.data.ExpenseManager
import com.carlosdev.expensetracker.data.repository.ExpenseRepositoryImpl
import com.carlosdev.expensetracker.getColorsTheme
import com.carlosdev.expensetracker.presentation.ExpensesViewModel
import com.carlosdev.expensetracker.ui.ExpensesScreen
import moe.tlaster.precompose.flow.collectAsStateWithLifecycle
import moe.tlaster.precompose.navigation.NavHost
import moe.tlaster.precompose.navigation.Navigator
import moe.tlaster.precompose.navigation.path

@Composable
fun Navigation(navigator: Navigator) {

    val colors = getColorsTheme()

    val viewModel = ExpensesViewModel(ExpenseRepositoryImpl(ExpenseManager))
    val uiState by viewModel.uiState.collectAsStateWithLifecycle()

    NavHost(
        modifier = Modifier.background(colors.background),
        navigator = navigator,
        initialRoute = "/home"
    ) {
        scene(route = "/home") {
            ExpensesScreen(uiState = uiState) { expense ->
                navigator.navigate("/addExpenses/${expense.id}")
            }
        }

        scene(route = "/addExpenses/{expenseId}") {
            val idFromPath = it.path<Long>("expenseId")
            val isAddExpense = idFromPath?.let { id ->
                viewModel.getExpensesById(id)
            }
        }
    }
}