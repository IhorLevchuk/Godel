package com.godeltech.test.dao.impl;

import com.godeltech.test.dao.mapper.CategoriesMapper;
import com.godeltech.test.dao.ExpensesDAO;
import com.godeltech.test.dao.mapper.ExpensesMapper;
import com.godeltech.test.model.Category;
import com.godeltech.test.model.Expense;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.jdbc.core.JdbcTemplate;
import org.springframework.stereotype.Repository;

import java.sql.Date;
import java.util.List;

@Repository
public class PostgreSQLExpensesDAO implements ExpensesDAO {

    private final JdbcTemplate jdbcTemplate;

    @Value("${query.expensesByCategory}")
    String queryByCategory;
    @Value("${query.expensesWithoutCategory}")
    String queryWithoutCategory;
    @Value("${query.expensesFrom}")
    String queryExpensesFrom;
    @Value("${query.expensesTo}")
    String queryExpensesTo;
    @Value("${query.expenses}")
    String queryExpenses;
    @Value("${query.categories}")
    String queryCategories;
    @Value("${query.expensesById}")
    String queryExpensesById;
    @Value("${query.addExpenses}")
    String addExpenses;
    @Value("${query.updateExpenses}")
    String updateExpenses;
    @Value("${query.deleteExpenses}")
    String deleteExpenses;

    @Autowired
    public PostgreSQLExpensesDAO(JdbcTemplate jdbcTemplate) {
        this.jdbcTemplate = jdbcTemplate;
    }

    @Override
    public List<Expense> getExpensesByCategory(int selectedCategory) {
        return jdbcTemplate.query(queryByCategory,new Object[]{selectedCategory}, new ExpensesMapper());
    }

    @Override
    public List<Expense> getExpensesWithoutCategory() {
        return jdbcTemplate.query(queryWithoutCategory, new ExpensesMapper());
    }

    @Override
    public List<Expense> getExpensesFrom(Date fromDate) {
        return jdbcTemplate.query(queryExpensesFrom,new Object[]{fromDate}, new ExpensesMapper());
    }

    @Override
    public List<Expense> getExpensesTo(Date toDate) {
        return jdbcTemplate.query(queryExpensesTo,new Object[]{toDate}, new ExpensesMapper());
    }

    @Override
    public List<Expense> getExpenses() {
        return jdbcTemplate.query(queryExpenses, new ExpensesMapper());
    }

    @Override
    public List<Category> getCategories() {
        return jdbcTemplate.query(queryCategories, new CategoriesMapper());
    }

    @Override
    public Expense getExpenseById(int id) {
        return jdbcTemplate.query(queryExpensesById,new Object[]{id}, new ExpensesMapper()).stream().findAny().get();
    }

    @Override
    public void createExpense(Expense expense) {
        jdbcTemplate.update(addExpenses,
                expense.getName(),
                expense.getCreatedAt(),
                Integer.parseInt(expense.getCategory()),
                expense.getAmount());
    }

    @Override
    public void updateExpenseById(Expense expense, int id) {
        jdbcTemplate.update(updateExpenses,
                expense.getName(),
                expense.getCreatedAt(),
                Integer.parseInt(expense.getCategory()),
                expense.getAmount(),
                id);
    }

    @Override
    public void deleteExpenseById(int id) {
        jdbcTemplate.update(deleteExpenses, id);
    }
}
