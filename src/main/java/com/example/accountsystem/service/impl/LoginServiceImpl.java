package com.example.accountsystem.service.impl;

import com.example.accountsystem.entity.Member;
import com.example.accountsystem.repository.MemberRepository;
import com.example.accountsystem.service.LoginService;
import org.apache.commons.logging.Log;
import org.apache.commons.logging.LogFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import javax.servlet.ServletException;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpSession;
import java.util.Objects;

@Service
public class LoginServiceImpl implements LoginService {

    private Log log = LogFactory.getLog(LoginServiceImpl.class);

    @Autowired
    MemberRepository memberRepository;

    @Override
    public String getLogin(String name, String password, HttpServletRequest req) {
        Member member = memberRepository.findByNameAndPassword(name, password);
        if (Objects.nonNull(member)){
            log.info("Login success");
            HttpSession session = req.getSession();
            session.setAttribute("user", name);
            String sessionId = session.getId();
            log.info("sessionId : " + sessionId);
            return "redirect:/index";
        } else {
            log.info("Login false");
            return null;
        }
    }

    @Override
    public String logout(HttpServletRequest req) throws ServletException {
        req.getSession().removeAttribute("user");
        req.logout();
        log.info("Logout");
        return "redirect:/index";
    }
}
