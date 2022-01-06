package com.godeltech.test.service.impl;

import com.godeltech.test.model.Expense;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;

import java.sql.Date;
import java.util.ArrayList;
import java.util.List;

import static org.junit.jupiter.api.Assertions.*;

class ExpenseServiceImplTest {
    private ExpenseServiceImpl expenseService;
    private List<Expense> expenses;

    @BeforeEach
    void setUp() {
        expenseService = new ExpenseServiceImpl();
        expenses = new ArrayList<>();
        expenses.add(new Expense("Books", new Date(2020,8,11), "Studies", 12.4));
        expenses.add(new Expense("Notebooks", new Date(2020,8,20), "Studies", 120.4));
        expenses.add(new Expense("Rent", new Date(2020,9,1), "Accommodation", 400));
        expenses.add(new Expense("Rent", new Date(2020,8,1), "Accommodation", 400));
        expenses.add(new Expense("Travel card", new Date(2020,9,4), "Transport", 52));
    }

    @Test
    void getTotalAmount() {
        String actual = expenseService.getTotalAmount(expenses);
        String expected = "984.8";
        assertEquals(expected, actual);
    }

    @Test
    void getHighestExpenseCategory() {
        String actual = expenseService.getHighestExpenseCategory(expenses);
        String expected = "Accommodation=800.0";
        assertEquals(expected, actual);
    }

    @Test
    void getHighestExpenseMonth() {
        String actual = expenseService.getHighestExpenseMonth(expenses);
        String expected = "8=532.8";
        assertEquals(expected, actual);
    }
}