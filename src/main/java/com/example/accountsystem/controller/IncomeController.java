package com.example.accountsystem.controller;

import com.example.accountsystem.enums.ErrorTypeEnum;
import com.example.accountsystem.service.impl.IncomeServiceImpl;
import org.apache.commons.logging.Log;
import org.apache.commons.logging.LogFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;

import javax.servlet.http.HttpServletRequest;

@Controller
public class IncomeController {

    private Log log = LogFactory.getLog(IncomeController.class);

    @Autowired
    IncomeServiceImpl incomeService;

    @GetMapping("/income")
    public String income(Model model, HttpServletRequest request){
        if (request.getSession().getAttribute("user") != null){
            model.addAttribute("isLogin", true);
            return "income";
        } else {
            model.addAttribute("isLogin", false);
            log.info(ErrorTypeEnum.NOT_LOGIN.getMsg());
            return "index";
        }
    }

    @PostMapping("/income")
    public String income(Integer credits, String comment, Model model, HttpServletRequest request){
        return incomeService.income(credits, comment, model, request);
    }
}
