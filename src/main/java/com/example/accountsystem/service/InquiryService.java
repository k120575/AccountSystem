package com.example.accountsystem.service;

import org.springframework.ui.Model;

import javax.servlet.http.HttpServletRequest;
import java.time.LocalDateTime;

public interface InquiryService {

    public String getInquiry(Model model, HttpServletRequest req);

    public String doSearch(String startDate, String endDate, Model model, HttpServletRequest req);
}
