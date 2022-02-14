package com.example.accountsystem.controller;

import com.example.accountsystem.service.impl.InquiryServiceImpl;
import org.apache.commons.logging.Log;
import org.apache.commons.logging.LogFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;

import javax.servlet.http.HttpServletRequest;
import java.util.Objects;

@Controller
public class InquiryController {

    @Autowired
    InquiryServiceImpl inquiryService;

    @GetMapping("/inquiry")
    public String inquiry(Model model, HttpServletRequest req){
        return inquiryService.getInquiry(model, req);
    }
}
