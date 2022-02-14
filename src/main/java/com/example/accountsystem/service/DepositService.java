package com.example.accountsystem.service;

import org.springframework.ui.Model;

import javax.servlet.http.HttpServletRequest;

public interface DepositService {

    String deposit(Integer credits, Model model, HttpServletRequest request);
}
