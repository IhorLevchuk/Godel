package com.godeltech.test.service.impl;

import com.godeltech.test.dao.ExpensesDAO;
import com.godeltech.test.model.Category;
import com.godeltech.test.model.Expense;
import com.godeltech.test.model.Statistics;
import com.godeltech.test.service.ExpenseService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.context.annotation.PropertySource;
import org.springframework.core.env.Environment;
import org.springframework.stereotype.Service;

import java.sql.Date;
import java.util.*;
import java.util.stream.Collectors;

@Service
@PropertySource("classpath:service.properties")
public class ExpenseServiceImpl implements ExpenseService {

    private ExpensesDAO expensesDAO;
    private Environment env;

    @Autowired
    public ExpenseServiceImpl(ExpensesDAO expensesDAO, Environment environment) {
        this.expensesDAO = expensesDAO;
        this.env = environment;
    }

    public ExpenseServiceImpl() {
    }

    @Override
    public List<Expense> getExpensesByParam(String selectedCategory, Date fromDate, Date toDate) {

        List<Expense> expenses = new ArrayList<>();

        if (selectedCategory.equals(env.getProperty("category.noOne"))) {
            expenses.addAll(expensesDAO.getExpensesWithoutCategory());
        } else {
            if (selectedCategory.equals(env.getProperty("category.all"))){
                expenses.addAll(expensesDAO.getExpenses());
            } else {
                expenses.addAll(expensesDAO.getExpensesByCategory(Integer.parseInt(selectedCategory)));
            }
        }

        if (!Objects.equals(env.getProperty("date.notSet"), fromDate.toString())) {
            expenses.retainAll(expensesDAO.getExpensesFrom(fromDate));
        }
        if (!Objects.equals(env.getProperty("date.notSet"), toDate.toString())) {
            expenses.retainAll(expensesDAO.getExpensesTo(toDate));
        }
        return expenses;
    }

    @Override
    public List<Category> getCategories() {
        return expensesDAO.getCategories();
    }

    @Override
    public List<Statistics> getStatistics() {
        List<Statistics> statistics = new ArrayList<>();
        List<Expense> expenses = expensesDAO.getExpenses();
        statistics.add(new Statistics(env.getProperty("stat.1"), getTotalAmount(expenses)));
        statistics.add(new Statistics(env.getProperty("stat.2"), getHighestExpenseCategory(expenses)));
        statistics.add(new Statistics(env.getProperty("stat.3"), getHighestExpenseMonth(expenses)));
        return statistics;
    }

    @Override
    public List<Expense> getExpenses() {
        return expensesDAO.getExpenses();
    }

    @Override
    public Expense getExpenseById(int id) {
        return expensesDAO.getExpenseById(id);
    }

    @Override
    public void createExpense(Expense expense) {
        expensesDAO.createExpense(expense);
    }

    @Override
    public void updateExpenseById(Expense expense, int id) {
        expensesDAO.updateExpenseById(expense, id);
    }

    @Override
    public void deleteExpenseById(int id) {
        expensesDAO.deleteExpenseById(id);
    }

    public String getTotalAmount(List<Expense> expenses) {
        return String.valueOf(expenses.stream().mapToDouble(Expense::getAmount).sum());
    }

    public String getHighestExpenseCategory(List<Expense> expenses) {
        return expenses.stream()
                .filter(expense -> expense.getCategory() != null)
                .collect(Collectors.groupingBy(Expense::getCategory,
                        Collectors.summingDouble(Expense::getAmount)))
                .entrySet()
                .stream()
                .max(Map.Entry.comparingByValue())
                .get().toString();
    }

    public String getHighestExpenseMonth(List<Expense> expenses) {
        return expenses.stream()
                .collect(Collectors.groupingBy(expense -> expense.getCreatedAt().getMonth(), Collectors.summingDouble(Expense::getAmount)))
                .entrySet()
                .stream()
                .max(Map.Entry.comparingByValue())
                .get().toString();
    }
}
