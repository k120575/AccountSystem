package com.example.accountsystem.controller;

import com.example.accountsystem.entity.Member;
import org.apache.commons.logging.Log;
import org.apache.commons.logging.LogFactory;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;

import javax.servlet.http.HttpServletRequest;
import java.util.Objects;

@Controller
public class IndexController {

    private Log log = LogFactory.getLog(IndexController.class);

    @GetMapping("/index")
    private String index(Model model, HttpServletRequest request){
        Member member = new Member();
        boolean isLogin = false;
        if (request.getSession().getAttribute("user") != null){
            String name = (String) request.getSession().getAttribute("user");
            member.setName(name);
            model.addAttribute("member", member);
            model.addAttribute("isLogin", true);
        } else {
            model.addAttribute("isLogin", false);
        }
        return "index";
    }
}
