package com.example.accountsystem.controller;

import com.example.accountsystem.entity.User;
import org.apache.commons.logging.Log;
import org.apache.commons.logging.LogFactory;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;

import javax.servlet.http.HttpServletRequest;

@Controller
public class IndexController {

    private Log log = LogFactory.getLog(IndexController.class);

    @GetMapping("/index")
    private String index(Model model, HttpServletRequest request){
        User user = new User();
        if (request.getSession().getAttribute("user") != null){
            String name = (String) request.getSession().getAttribute("user");
            user.setName(name);
            model.addAttribute("user", user);
            model.addAttribute("isLogin", true);
        } else {
            model.addAttribute("isLogin", false);
        }
        return "index";
    }
}
