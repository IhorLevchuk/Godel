package com.godeltech.test.model;

import java.sql.Date;
import java.util.Objects;

public class Expense {
    private String name;
    private Date createdAt;
    private String category;
    private double amount;

    public Expense(String name, Date createdAt, String category, double amount) {
        this.name = name;
        this.createdAt = createdAt;
        this.category = category;
        this.amount = amount;
    }

    public Expense() {
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public Date getCreatedAt() {
        return createdAt;
    }

    public void setCreatedAt(Date createdAt) {
        this.createdAt = createdAt;
    }

    public String getCategory() {
        return category;
    }

    public void setCategory(String category) {
        this.category = category;
    }

    public double getAmount() {
        return amount;
    }

    public void setAmount(double amount) {
        this.amount = amount;
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;
        Expense expense = (Expense) o;
        return Double.compare(expense.amount, amount) == 0 && Objects.equals(name, expense.name) && Objects.equals(createdAt, expense.createdAt) && Objects.equals(category, expense.category);
    }

    @Override
    public int hashCode() {
        return Objects.hash(name, createdAt, category, amount);
    }
}
