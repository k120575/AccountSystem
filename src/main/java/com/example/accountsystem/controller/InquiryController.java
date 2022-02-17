package com.example.accountsystem.controller;

import com.example.accountsystem.service.impl.InquiryServiceImpl;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestParam;

import javax.servlet.http.HttpServletRequest;

@Controller
public class InquiryController {

    @Autowired
    InquiryServiceImpl inquiryService;

    @GetMapping("/inquiry")
    public String inquiry(@RequestParam(value = "page", defaultValue = "1") Integer page,
                          @RequestParam(value = "size", defaultValue = "10") Integer size,
                          Model model, HttpServletRequest req){
        return inquiryService.getInquiry(page, size, model, req);
    }

    @PostMapping("/search")
    public String search(String startDate,
                         String endDate,
                         @RequestParam(value = "page", defaultValue = "1") Integer page,
                         @RequestParam(value = "size", defaultValue = "10") Integer size,
                         Model model, HttpServletRequest req){
        return inquiryService.doSearch(startDate, endDate, page, size, model, req);
    }
}
