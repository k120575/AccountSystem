package com.example.accountsystem.service.impl;

import com.example.accountsystem.entity.AccountDetail;
import com.example.accountsystem.entity.User;
import com.example.accountsystem.repository.AccountDetailRepository;
import com.example.accountsystem.service.InquiryService;
import org.apache.commons.logging.Log;
import org.apache.commons.logging.LogFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.domain.Page;
import org.springframework.stereotype.Service;
import org.springframework.ui.Model;

import javax.servlet.http.HttpServletRequest;
import java.time.LocalDateTime;
import java.time.format.DateTimeFormatter;
import java.util.List;
import java.util.Objects;

@Service
public class InquiryServiceImpl implements InquiryService {

    private Log log = LogFactory.getLog(InquiryServiceImpl.class);

    @Autowired
    AccountDetailRepository accountDetailRepository;

    @Override
    public String getInquiry(Model model, HttpServletRequest req) {
        User user = new User();
        boolean isLogin = false;
        boolean hasData = false;
        if (req.getSession().getAttribute("user") != null){
            String name = (String)req.getSession().getAttribute("user");
            List<AccountDetail> accountDetails = accountDetailRepository.findByCreateUserOrderByCreateTimeDesc(name);
            DateTimeFormatter dtf = DateTimeFormatter.ofPattern("yyyy/MM/dd HH:mm:ss");
            user.setName(name);
            model.addAttribute("user", user);
            model.addAttribute("isLogin", true);
            model.addAttribute("currentTime", dtf.format(LocalDateTime.now()));
            if (accountDetails.size() != 0){
                model.addAttribute("hasData", true);
                model.addAttribute("balance", accountDetails.get(0).getBalance());
                model.addAllAttributes(accountDetails);
            } else {
                model.addAttribute("hasData", false);
                model.addAttribute("balance", 0);
            }
            log.info("Inquiry success : " + req.getSession().getId());
            return "inquiry";
        } else {
            model.addAttribute("isLogin", false);
            log.info("Inquiry false");
            return "redirect:/index";
        }
    }
}
