package com.carlosdev.expensetracker.data.repository

import com.carlosdev.expensetracker.data.ExpenseManager
import com.carlosdev.expensetracker.domain.model.Expense
import com.carlosdev.expensetracker.domain.model.ExpenseCategory
import com.carlosdev.expensetracker.domain.repository.ExpenseRepository

class ExpenseRepositoryImpl(private val expenseManager: ExpenseManager) : ExpenseRepository {
    override fun getExpenses(): List<Expense> {
        return expenseManager.fakeExpenseList
    }

    override fun addExpense(expense: Expense) {
        expenseManager.addExpense(expense)
    }

    override fun editExpense(expense: Expense) {
        expenseManager.editExpense(expense)
    }

    override fun getCategories(): List<ExpenseCategory> {
        return expenseManager.getCategories()
    }
}