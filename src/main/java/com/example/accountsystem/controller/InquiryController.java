package com.example.accountsystem.controller;

import org.apache.commons.logging.Log;
import org.apache.commons.logging.LogFactory;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;

import javax.servlet.http.HttpServletRequest;
import java.util.Objects;

@Controller
public class InquiryController {

    private final Log log = LogFactory.getLog(InquiryController.class);

    @GetMapping("/inquiry")
    public String inquiry(Model model, HttpServletRequest req){
        boolean isLogin = false;
        if (req.getSession().getAttribute("user") != null){
            log.info("Inquiry success : " + req.getSession().getId());
            model.addAttribute("isLogin", true);
            return "inquiry";
        } else {
            model.addAttribute("isLogin", false);
            log.info("Inquiry false");
            return "redirect:/index";
        }
    }
}
