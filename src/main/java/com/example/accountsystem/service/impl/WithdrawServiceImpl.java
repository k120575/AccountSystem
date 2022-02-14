package com.example.accountsystem.service.impl;

import com.example.accountsystem.entity.AccountDetail;
import com.example.accountsystem.repository.AccountDetailRepository;
import com.example.accountsystem.service.DepositService;
import com.example.accountsystem.service.WithdrawService;
import org.apache.commons.logging.Log;
import org.apache.commons.logging.LogFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.ui.Model;

import javax.servlet.http.HttpServletRequest;
import java.time.LocalDateTime;
import java.util.List;

@Service
public class WithdrawServiceImpl implements WithdrawService {

    private Log log = LogFactory.getLog(WithdrawServiceImpl.class);

    @Autowired
    AccountDetailRepository accountDetailRepository;

    @Override
    public String withdraw(Integer credits, Model model, HttpServletRequest request) {
        if (request.getSession().getAttribute("user") != null){
            AccountDetail accountDetail = new AccountDetail();
            accountDetail.setAction("Withdraw");
            if (credits >= 0){
                accountDetail.setCredits(credits);
            } else {
                log.info("金額需大於0");
                return "redirect:/index";
            }
            String user = (String)request.getSession().getAttribute("user") ;
            int newBalance = 0;
            List<AccountDetail> accountDetails = accountDetailRepository.findByCreateUserOrderByCreateTimeDesc(user);
            if (accountDetails.size() != 0 && accountDetails.get(0).getBalance() != 0){
                newBalance = accountDetails.get(0).getBalance() - credits;
                accountDetail.setBalance(newBalance);
                accountDetail.setCreateUser(user);
                accountDetail.setCreateTime(LocalDateTime.now());
                accountDetailRepository.saveAndFlush(accountDetail);
                model.addAttribute("user", user);
                model.addAttribute("isLogin", true);
                log.info("Deposit success");
            } else {
                log.info("no money");
            }
        }
        return "redirect:/index";

    }
}
