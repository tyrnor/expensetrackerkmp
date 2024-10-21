package com.carlosdev.expensetracker.domain.repository

import com.carlosdev.expensetracker.domain.model.Expense
import com.carlosdev.expensetracker.domain.model.ExpenseCategory

interface ExpenseRepository {
    fun getExpenses(): List<Expense>
    fun addExpense(expense: Expense)
    fun editExpense(expense: Expense)
    fun getCategories(): List<ExpenseCategory>
    fun deleteExpense(expense: Expense)
}