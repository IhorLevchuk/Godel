package com.godeltech.test.dao.mapper;


import com.godeltech.test.model.Expense;
import org.springframework.jdbc.core.RowMapper;

import java.sql.ResultSet;
import java.sql.SQLException;

public class ExpensesMapper implements RowMapper<Expense> {

    @Override
    public Expense mapRow(ResultSet rs, int rowNum) throws SQLException {
        Expense expense = new Expense();
        expense.setName(rs.getString("name"));
        expense.setCreatedAt(rs.getDate("created_at"));
        expense.setCategory(rs.getString("category"));
        expense.setAmount(rs.getDouble("amount"));
        return expense;
    }
}
