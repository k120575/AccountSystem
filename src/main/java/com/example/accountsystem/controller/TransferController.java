package com.example.accountsystem.controller;

import com.example.accountsystem.enums.ErrorTypeEnum;
import com.example.accountsystem.service.impl.TransferServiceImpl;
import org.apache.commons.logging.Log;
import org.apache.commons.logging.LogFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;

import javax.servlet.http.HttpServletRequest;

@Controller
public class TransferController {

    private final Log log = LogFactory.getLog(TransferController.class);

    @Autowired
    TransferServiceImpl transferService;

    @GetMapping("/transfer")
    public String transfer(Model model, HttpServletRequest request){
        if (request.getSession().getAttribute("user") != null){
            model.addAttribute("isLogin", true);
            return "transfer";
        } else {
            model.addAttribute("isLogin", false);
            log.info(ErrorTypeEnum.NOT_LOGIN.getMsg());
            return "index";
        }
    }

    @PostMapping("/transfer")
    public String transfer(String transferFrom, String transferTo, Integer credits, String comment, Model model, HttpServletRequest request){
        return transferService.transfer(transferFrom, transferTo, credits, comment, model, request);
    }
}
