package com.carlosdev.expensetracker.data.repository

import com.carlosdev.expensetracker.data.ExpenseManager
import com.carlosdev.expensetracker.domain.model.Expense
import com.carlosdev.expensetracker.domain.model.ExpenseCategory
import com.carlosdev.expensetracker.domain.repository.ExpenseRepository

class ExpenseRepositoryImpl(private val expenseManager: ExpenseManager): ExpenseRepository {
    override suspend fun getExpenses(): List<Expense> {
        return expenseManager.fakeExpenseList
    }

    override suspend fun addExpense(expense: Expense) {
        expenseManager.addExpense(expense)
    }

    override suspend fun editExpense(expense: Expense) {
        expenseManager.editExpense(expense)
    }

    override suspend fun getCategories(): List<ExpenseCategory> {
        return expenseManager.getCategories()
    }
}