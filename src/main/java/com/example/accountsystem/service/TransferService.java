package com.example.accountsystem.service;

import org.springframework.ui.Model;

import javax.servlet.http.HttpServletRequest;

public interface TransferService {

    String transfer(String transferFrom, String transferTo, Integer credits, String comment, Model model, HttpServletRequest request);
}
