package com.example.accountsystem.service.impl;

import com.example.accountsystem.entity.AccountDetail;
import com.example.accountsystem.enums.ActionEnum;
import com.example.accountsystem.enums.ErrorTypeEnum;
import com.example.accountsystem.enums.StatusEnum;
import com.example.accountsystem.repository.AccountDetailRepository;
import com.example.accountsystem.service.IncomeService;
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
public class IncomeServiceImpl implements IncomeService {

    private final Log log = LogFactory.getLog(IncomeServiceImpl.class);

    @Autowired
    AccountDetailRepository accountDetailRepository;

    @Override
    public String income(Integer credits, String incomeType, String comment, Model model, HttpServletRequest request) {
        if (request.getSession().getAttribute("user") != null){
            AccountDetail accountDetail = new AccountDetail();
            accountDetail.setAction(ActionEnum.INCOME.getMsg());
            if (Objects.isNull(credits)){
                log.info(ErrorTypeEnum.NO_MONEY.getMsg());
                return null;
            }
            if (credits >= 0){
                accountDetail.setCredits(credits);
            } else {
                log.info(ErrorTypeEnum.CREDITS_MUST_GREATER_THAN_ZERO.getMsg());
                return null;
            }
            String user = (String)request.getSession().getAttribute("user") ;
            // 餘額預設維0
            int newBalance;
            // 找出所有帳務資料，如果有資料就把輸入金額加上最新的餘額，沒資料就把輸入金額當最新的餘額
            List<AccountDetail> accountDetails = accountDetailRepository.findByCreateUserOrderByCreateTimeDesc(user);
            if (accountDetails.size() != 0){
                newBalance = credits + accountDetails.get(0).getBalance();
            } else {
                newBalance = credits;
            }
            accountDetail.setBalance(newBalance);
            accountDetail.setIncomeType(incomeType);
            if (Objects.nonNull(comment)){
                accountDetail.setComment(comment);
            }
            accountDetail.setCreateUser(user);
            accountDetail.setCreateTime(LocalDateTime.now());
            accountDetailRepository.saveAndFlush(accountDetail);
            model.addAttribute("user", user);
            model.addAttribute("isLogin", true);
            log.info(StatusEnum.INCOME_SUCCESS.getMsg());
        }
        return "redirect:/index";
    }
}
