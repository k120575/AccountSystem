package com.example.accountsystem.service.impl;

import com.example.accountsystem.entity.AccountDetail;
import com.example.accountsystem.repository.AccountDetailRepository;
import com.example.accountsystem.service.DepositService;
import org.apache.commons.logging.Log;
import org.apache.commons.logging.LogFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.ui.Model;

import javax.servlet.http.HttpServletRequest;
import java.time.LocalDateTime;
import java.util.List;

@Service
public class DepositServiceImpl implements DepositService {

    private Log log = LogFactory.getLog(DepositServiceImpl.class);

    @Autowired
    AccountDetailRepository accountDetailRepository;

    @Override
    public String deposit(Integer credits, Model model, HttpServletRequest request) {
        if (request.getSession().getAttribute("user") != null){
            AccountDetail accountDetail = new AccountDetail();
            accountDetail.setAction("Deposit");
            accountDetail.setCredits(credits);
            String user = (String)request.getSession().getAttribute("user") ;
            int newBalance = 0;
            List<AccountDetail> accountDetails = accountDetailRepository.findByCreateUserOrderByCreateTimeDesc(user);
            if (accountDetails.size() != 0){
                newBalance = credits + accountDetailRepository.findByCreateUserOrderByCreateTimeDesc(user).get(0).getBalance();
            } else {
                newBalance = credits;
            }
            accountDetail.setBalance(newBalance);
            accountDetail.setCreateUser(user);
            accountDetail.setCreateTime(LocalDateTime.now());
            accountDetailRepository.saveAndFlush(accountDetail);
            model.addAttribute("user", user);
            model.addAttribute("isLogin", true);
            log.info("Deposit success");
        }
        return "redirect:/index";
//        else {
//            model.addAttribute("isLogin", false);
//            log.info("Deposit false");
//            return "redirect:/index";
//        }
    }
}
