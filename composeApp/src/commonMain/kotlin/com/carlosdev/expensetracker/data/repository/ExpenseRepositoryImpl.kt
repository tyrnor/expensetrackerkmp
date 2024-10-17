package com.carlosdev.expensetracker.data.repository

import com.carlosdev.expensetracker.data.ExpenseManager
import com.carlosdev.expensetracker.domain.model.Expense
import com.carlosdev.expensetracker.domain.model.ExpenseCategory
import com.carlosdev.expensetracker.domain.repository.ExpenseRepository

class ExpenseRepositoryImpl: ExpenseRepository {
    override suspend fun getExpenses(): List<Expense> {
        return ExpenseManager.fakeExpenseList
    }

    override suspend fun addExpense(expense: Expense) {
        ExpenseManager.addExpense(expense)
    }

    override suspend fun editExpense(expense: Expense) {
        ExpenseManager.editExpense(expense)
    }

    override suspend fun getCategories(): List<ExpenseCategory> {
        return ExpenseManager.getCategories()
    }
}