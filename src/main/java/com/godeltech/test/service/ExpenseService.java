package com.godeltech.test.service;

import com.godeltech.test.model.Category;
import com.godeltech.test.model.Expense;
import com.godeltech.test.model.Statistics;

import java.sql.Date;
import java.util.List;

public interface ExpenseService {
    List<Expense> getExpensesByParam(String selectedCategory, Date fromDate, Date toDate);
    List<Category> getCategories();
    List<Statistics> getStatistics();
    List<Expense> getExpenses();
    Expense getExpenseById(int id);
    void createExpense(Expense expense);
    void updateExpenseById(Expense expense, int id);
    void deleteExpenseById(int id);
}
