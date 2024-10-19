package com.carlosdev.expensetracker.presentation

import com.carlosdev.expensetracker.domain.model.Expense
import com.carlosdev.expensetracker.domain.repository.ExpenseRepository
import kotlinx.coroutines.flow.MutableStateFlow
import kotlinx.coroutines.flow.StateFlow
import kotlinx.coroutines.flow.asStateFlow
import kotlinx.coroutines.flow.update
import kotlinx.coroutines.launch
import moe.tlaster.precompose.viewmodel.ViewModel
import moe.tlaster.precompose.viewmodel.viewModelScope

data class ExpensesUiState(
    val expenses: List<Expense> = emptyList(),
    val total: Double = 0.0
)


class ExpensesViewModel(private val expenseRepository: ExpenseRepository) : ViewModel() {

    private val _uiState = MutableStateFlow(ExpensesUiState())
    val uiState: StateFlow<ExpensesUiState> = _uiState.asStateFlow()
    private val allExpenses = expenseRepository.getExpenses()

    init {
        getAllExpenses()
    }

    private fun getAllExpenses() {
        viewModelScope.launch {
            updateState()
        }
    }

    fun addExpense(expense: Expense) {
        viewModelScope.launch {
            expenseRepository.addExpense(expense)
            updateState()
        }

    }

    fun editExpense(expense: Expense) {
        viewModelScope.launch {
            expenseRepository.editExpense(expense)
            updateState()
        }

    }

    fun getExpensesById(id: Long): Expense {
        return allExpenses.first{ it.id == id }
    }

    private fun updateState() {
        _uiState.update { state ->
            state.copy(expenses = allExpenses, total = allExpenses.sumOf { it.amount })
        }
    }
}