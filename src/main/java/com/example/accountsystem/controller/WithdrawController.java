package com.example.accountsystem.controller;

import com.example.accountsystem.service.impl.DepositServiceImpl;
import com.example.accountsystem.service.impl.WithdrawServiceImpl;
import org.apache.commons.logging.Log;
import org.apache.commons.logging.LogFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;

import javax.servlet.http.HttpServletRequest;

@Controller
public class WithdrawController {

    private Log log = LogFactory.getLog(WithdrawController.class);

    @Autowired
    WithdrawServiceImpl withdrawService;

    @GetMapping("/withdraw")
    public String withdraw(Model model, HttpServletRequest request){
        if (request.getSession().getAttribute("user") != null){
            model.addAttribute("isLogin", true);
            return "withdraw";
        } else {
            model.addAttribute("isLogin", false);
            log.info("no login");
            return "index";
        }
    }

    @PostMapping("/withdraw")
    public String withdraw(Integer credits, Model model, HttpServletRequest request){
        return withdrawService.withdraw(credits, model, request);
    }
}
