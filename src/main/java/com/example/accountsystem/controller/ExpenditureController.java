package com.example.accountsystem.controller;

import com.example.accountsystem.enums.ErrorTypeEnum;
import com.example.accountsystem.service.impl.ExpenditureServiceImpl;
import org.apache.commons.logging.Log;
import org.apache.commons.logging.LogFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;

import javax.servlet.http.HttpServletRequest;

@Controller
public class ExpenditureController {

    private final Log log = LogFactory.getLog(ExpenditureController.class);

    @Autowired
    ExpenditureServiceImpl expenditureService;

    @GetMapping("/expenditure")
    public String expenditure(Model model, HttpServletRequest request){
        if (request.getSession().getAttribute("user") != null){
            model.addAttribute("isLogin", true);
            return "expenditure";
        } else {
            log.info(ErrorTypeEnum.NOT_LOGIN.getMsg());
            return "login";
        }
    }

    @PostMapping("/expenditure")
    public String expenditure(Integer credits, String expenditureType, String comment, Model model, HttpServletRequest request){
        if (request.getSession().getAttribute("user") != null){
            model.addAttribute("isLogin", true);
            return expenditureService.expenditure(credits, expenditureType, comment, model, request);
        } else {
            model.addAttribute("isLogin", false);
            log.info(ErrorTypeEnum.NOT_LOGIN.getMsg());
            return "login";
        }
    }
}
