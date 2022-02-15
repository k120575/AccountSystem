package com.example.accountsystem.service.impl;

import com.example.accountsystem.entity.AccountDetail;
import com.example.accountsystem.enums.ActionEnum;
import com.example.accountsystem.enums.ErrorTypeEnum;
import com.example.accountsystem.enums.StatusEnum;
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
import java.util.Objects;

@Service
public class DepositServiceImpl implements DepositService {

    private Log log = LogFactory.getLog(DepositServiceImpl.class);

    @Autowired
    AccountDetailRepository accountDetailRepository;

    @Override
    public String deposit(Integer credits, String comment, Model model, HttpServletRequest request) {
        if (request.getSession().getAttribute("user") != null){
            AccountDetail accountDetail = new AccountDetail();
            accountDetail.setAction(ActionEnum.DEPOSIT.getMsg());
            if (Objects.isNull(credits)){
                log.info(ErrorTypeEnum.NO_MONEY.getMsg());
                return null;
            }
            if (credits >= 0){
                accountDetail.setCredits(credits);
            } else {
                log.info(ErrorTypeEnum.AMOUNT_MUST_GREATER_THAN_ZERO.getMsg());
                return null;
            }
            String user = (String)request.getSession().getAttribute("user") ;
            int newBalance = 0;
            List<AccountDetail> accountDetails = accountDetailRepository.findByCreateUserOrderByCreateTimeDesc(user);
            if (accountDetails.size() != 0){
                newBalance = credits + accountDetails.get(0).getBalance();
            } else {
                newBalance = credits;
            }
            accountDetail.setBalance(newBalance);
            if (Objects.nonNull(comment)){
                accountDetail.setComment(comment);
            }
            accountDetail.setCreateUser(user);
            accountDetail.setCreateTime(LocalDateTime.now());
            accountDetailRepository.saveAndFlush(accountDetail);
            model.addAttribute("user", user);
            model.addAttribute("isLogin", true);
            log.info(StatusEnum.DEPOSIT_SUCCESS.getMsg());
        }
        return "redirect:/index";
    }
}
