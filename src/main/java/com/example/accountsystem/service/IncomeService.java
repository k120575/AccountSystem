package com.example.accountsystem.service;

import org.springframework.ui.Model;

import javax.servlet.http.HttpServletRequest;

public interface IncomeService {

    String income(Integer credits, String incomeType, String comment, Model model, HttpServletRequest request);
}
