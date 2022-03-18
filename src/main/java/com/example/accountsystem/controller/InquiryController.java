package com.example.accountsystem.controller;

import com.example.accountsystem.enums.ErrorTypeEnum;
import com.example.accountsystem.service.impl.InquiryServiceImpl;
import org.apache.commons.logging.Log;
import org.apache.commons.logging.LogFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestParam;

import javax.servlet.http.HttpServletRequest;

@Controller
public class InquiryController {

    private Log log = LogFactory.getLog(InquiryController.class);

    @Autowired
    InquiryServiceImpl inquiryService;

    @GetMapping("/inquiry")
    public String inquiry(@RequestParam(value = "page", defaultValue = "1") Integer page,
                          @RequestParam(value = "size", defaultValue = "10") Integer size,
                          Model model, HttpServletRequest req){
        if (req.getSession().getAttribute("user") != null){
            model.addAttribute("isLogin", true);
            return inquiryService.getInquiry(page, size, model, req);
        } else {
            model.addAttribute("isLogin", false);
            log.info(ErrorTypeEnum.NOT_LOGIN.getMsg());
            return "login";
        }
    }

    @PostMapping("/search")
    public String search(String startDate,
                         String endDate,
                         @RequestParam(value = "page", defaultValue = "1") Integer page,
                         @RequestParam(value = "size", defaultValue = "10") Integer size,
                         Model model, HttpServletRequest req){
        if (req.getSession().getAttribute("user") != null){
            model.addAttribute("isLogin", true);
            return inquiryService.doSearch(startDate, endDate, page, size, model, req);
        } else {
            model.addAttribute("isLogin", false);
            log.info(ErrorTypeEnum.NOT_LOGIN.getMsg());
            return "login";
        }
    }
}
