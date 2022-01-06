package com.godeltech.test.dao;

import com.godeltech.test.model.Category;
import com.godeltech.test.model.Expense;

import java.sql.Date;
import java.util.List;

public interface ExpensesDAO {
    List<Expense> getExpensesByCategory(int selectedCategory);
    List<Expense> getExpensesWithoutCategory();
    List<Expense> getExpensesFrom(Date fromDate);
    List<Expense> getExpensesTo(Date toDate);
    List<Expense> getExpenses();
    List<Category> getCategories();
    Expense getExpenseById(int id);
    void createExpense(Expense expense);
    void updateExpenseById(Expense expense, int id);
    void deleteExpenseById(int id);
}
