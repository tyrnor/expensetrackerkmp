package com.carlosdev.expensetracker.domain.repository

import com.carlosdev.expensetracker.domain.model.Expense
import com.carlosdev.expensetracker.domain.model.ExpenseCategory

interface ExpenseRepository {
    suspend fun getExpenses(): List<Expense>
    suspend fun addExpense(expense: Expense)
    suspend fun editExpense(expense: Expense)
    suspend fun getCategories(): List<ExpenseCategory>
}