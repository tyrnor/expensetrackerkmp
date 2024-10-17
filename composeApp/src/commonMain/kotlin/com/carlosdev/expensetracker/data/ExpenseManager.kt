package com.carlosdev.expensetracker.data

import com.carlosdev.expensetracker.domain.model.Expense
import com.carlosdev.expensetracker.domain.model.ExpenseCategory

object ExpenseManager {

    private var currentId = 1L

    val fakeExpenseList = mutableListOf(
        Expense(
            id = currentId++,
            amount = 100.0,
            category = ExpenseCategory.GROCERIES,
            description = "Groceries"
        ),
        Expense(
            id = currentId++,
            amount = 50.0,
            category = ExpenseCategory.PARTY,
            description = "Party"
        ),
        Expense(
            id = currentId++,
            amount = 75.0,
            category = ExpenseCategory.SNACKS,
            description = "Hommies"
        ),
        Expense(
            id = currentId++,
            amount = 200.0,
            category = ExpenseCategory.COFFEE,
            description = "Coffee"
        ),
        Expense(
            id = currentId++,
            amount = 150.0,
            category = ExpenseCategory.CAR,
            description = "Car"
        ),
        Expense(
            id = currentId++,
            amount = 300.0,
            category = ExpenseCategory.HOUSE,
            description = "House"
        ),
        Expense(
            id = currentId++,
            amount = 80.0,
            category = ExpenseCategory.OTHER,
            description = "Other"
        )
    )

    fun addExpense(expense: Expense) {
        fakeExpenseList.add(expense.copy(id = currentId++))
    }

    fun editExpense(expense: Expense) {
        val index = fakeExpenseList.indexOfFirst { it.id == expense.id }
        if (index != -1) {
            fakeExpenseList[index] = fakeExpenseList[index].copy(
                amount = expense.amount,
                category = expense.category,
                description = expense.description
            )
        }
    }

    fun getCategories(): List<ExpenseCategory> {
        return ExpenseCategory.entries
    }
}