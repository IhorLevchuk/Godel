package com.godeltech.test.controller;

import com.godeltech.test.model.Expense;
import com.godeltech.test.service.ExpenseService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.*;
import org.springframework.web.servlet.ModelAndView;

import java.sql.Date;

@Controller
@RequestMapping("/expenses")
public class ExpenseController {

    private final ExpenseService expenseService;

    @Autowired
    public ExpenseController(ExpenseService expenseService) {
        this.expenseService = expenseService;
    }

    @GetMapping("/parameters")
    public ModelAndView getExpensesByParam(@RequestParam("selectedCategory") String selectedCategory,
                                           @RequestParam("from_date") Date fromDate,
                                           @RequestParam("to_date") Date toDate,
                                           @RequestParam(value = "statistic", required = false) String statistic,
                                           ModelAndView modelAndView) {
        modelAndView.addObject("expenses", expenseService.getExpensesByParam(selectedCategory, fromDate, toDate));
        if (statistic != null) {
            modelAndView.addObject("statistics", expenseService.getStatistics());
        }
        modelAndView.addObject("categories", expenseService.getCategories());
        modelAndView.setViewName("searchByExpenses");
        return modelAndView;
    }

    @GetMapping("/searchParameters")
    public ModelAndView getCategories(ModelAndView modelAndView) {
        modelAndView.addObject("categories", expenseService.getCategories());
        modelAndView.setViewName("searchByExpenses");
        return modelAndView;
    }

    @GetMapping()
    public ModelAndView index(ModelAndView modelAndView) {
        modelAndView.addObject("expenses",expenseService.getExpenses());
        modelAndView.setViewName("expense/index");
        return modelAndView;
    }

    @GetMapping("/{id}")
    public ModelAndView show(@PathVariable("id") int id, ModelAndView modelAndView) {
        modelAndView.addObject("expense",expenseService.getExpenseById(id));
        modelAndView.setViewName("expense/show");
        return modelAndView;
    }

    @GetMapping("/new")
    public ModelAndView newExpense(ModelAndView modelAndView) {
        modelAndView.addObject("categories", expenseService.getCategories());
        modelAndView.setViewName("expense/new");
        return modelAndView;
    }

    @PostMapping()
    public ResponseEntity create(@ModelAttribute Expense expense) {
        expenseService.createExpense(expense);
        return new ResponseEntity("Successful operation", HttpStatus.OK);
    }

    @GetMapping("/{id}/edit")
    public ModelAndView edit(@PathVariable("id") int id, ModelAndView modelAndView) {
        modelAndView.addObject("expense",expenseService.getExpenseById(id));
        modelAndView.addObject("categories", expenseService.getCategories());
        modelAndView.addObject("id", id);
        modelAndView.setViewName("expense/edit");
        return modelAndView;
    }

    @PatchMapping("/{id}")
    public ResponseEntity update(@ModelAttribute Expense expense, @PathVariable("id") int id) {
        expenseService.updateExpenseById(expense, id);
        return new ResponseEntity("Successful operation", HttpStatus.OK);
    }

    @DeleteMapping("/{id}")
    public ResponseEntity delete(@PathVariable("id") int id, ModelAndView modelAndView) {
        expenseService.deleteExpenseById(id);
        return new ResponseEntity("Successful operation", HttpStatus.OK);
    }
}
