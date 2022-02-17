package com.example.accountsystem.service.impl;

import com.example.accountsystem.entity.AccountDetail;
import com.example.accountsystem.enums.ActionEnum;
import com.example.accountsystem.enums.ErrorTypeEnum;
import com.example.accountsystem.enums.StatusEnum;
import com.example.accountsystem.repository.AccountDetailRepository;
import com.example.accountsystem.service.ExpenditureService;
import org.apache.commons.logging.Log;
import org.apache.commons.logging.LogFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.ui.Model;
import org.springframework.util.CollectionUtils;

import javax.servlet.http.HttpServletRequest;
import java.time.LocalDateTime;
import java.util.List;
import java.util.Objects;

@Service
public class ExpenditureServiceImpl implements ExpenditureService {

    private Log log = LogFactory.getLog(ExpenditureServiceImpl.class);

    @Autowired
    AccountDetailRepository accountDetailRepository;

    @Override
    public String expenditure(Integer credits, String expenditureType, String comment, Model model, HttpServletRequest request) {
        if (request.getSession().getAttribute("user") != null){
            AccountDetail accountDetail = new AccountDetail();
            accountDetail.setAction(ActionEnum.EXPENDITURE.getMsg());
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
            int newBalance = 0;
            List<AccountDetail> accountDetails = accountDetailRepository.findByCreateUserOrderByCreateTimeDesc(user);
            // 判斷是否有資料
            if (CollectionUtils.isEmpty(accountDetails)){
                log.info(ErrorTypeEnum.BALANCE_NOT_ENOUGH.getMsg());
                return null;
            }

            // 判斷餘額夠不夠
            if (accountDetails.get(0).getBalance() < credits){
                log.info(ErrorTypeEnum.BALANCE_NOT_ENOUGH.getMsg());
                return null;
            }
            // 找出全部帳務資料，如果有資料且最新的餘額不為0，則將最新餘額扣掉支出金額
            if (accountDetails.size() != 0 && accountDetails.get(0).getBalance() != 0){
                newBalance = accountDetails.get(0).getBalance() - credits;
                accountDetail.setBalance(newBalance);
                accountDetail.setExpenditureType(expenditureType);
                if (Objects.nonNull(comment)){
                    accountDetail.setComment(comment);
                }
                accountDetail.setCreateUser(user);
                accountDetail.setCreateTime(LocalDateTime.now());
                accountDetailRepository.saveAndFlush(accountDetail);
                model.addAttribute("user", user);
                model.addAttribute("isLogin", true);
                log.info(StatusEnum.EXPENDITURE_SUCCESS.getMsg());
            } else {
                log.info(ErrorTypeEnum.NO_MONEY.getMsg());
                return null;
            }
        }
        return "redirect:/index";

    }
}
