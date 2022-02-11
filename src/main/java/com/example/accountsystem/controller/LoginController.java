package com.example.accountsystem.controller;

import com.example.accountsystem.service.impl.LoginServiceImpl;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;

import javax.servlet.ServletException;
import javax.servlet.http.HttpServletRequest;

@Controller
public class LoginController {

    @Autowired
    LoginServiceImpl loginService;

    @GetMapping("/login")
    private String login(){

        return "login";
    }

    @PostMapping("/login")
    private String login(String name, String password, HttpServletRequest req){
        return loginService.getLogin(name, password, req);
    }

    @RequestMapping("/logout")
    private String logout(HttpServletRequest req) throws ServletException {
        return loginService.logout(req);
    }
}
