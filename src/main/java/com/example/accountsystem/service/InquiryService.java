package com.example.accountsystem.service;

import org.springframework.ui.Model;

import javax.servlet.http.HttpServletRequest;

public interface InquiryService {

    public String getInquiry(Model model, HttpServletRequest req);
}
