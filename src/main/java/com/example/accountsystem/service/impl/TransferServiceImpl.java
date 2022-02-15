package com.example.accountsystem.service.impl;

import com.example.accountsystem.entity.AccountDetail;
import com.example.accountsystem.entity.User;
import com.example.accountsystem.enums.ActionEnum;
import com.example.accountsystem.enums.ErrorTypeEnum;
import com.example.accountsystem.enums.StatusEnum;
import com.example.accountsystem.repository.AccountDetailRepository;
import com.example.accountsystem.repository.UserRepository;
import com.example.accountsystem.service.TransferService;
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
public class TransferServiceImpl implements TransferService {

    private Log log = LogFactory.getLog(TransferServiceImpl.class);

    @Autowired
    AccountDetailRepository accountDetailRepository;

    @Autowired
    UserRepository userRepository;

    @Override
    public String transfer(String transferFrom, String transferTo, Integer credits, String comment, Model model, HttpServletRequest request) {
        if (request.getSession().getAttribute("user") != null){
            if (Objects.isNull(transferFrom)){
                log.info(ErrorTypeEnum.NO_TRANSFER_FROM.getMsg());
                return null;
            }
            if (Objects.isNull(transferTo)){
                log.info(ErrorTypeEnum.NO_TRANSFER_TO.getMsg());
                return null;
            }
            if (Objects.isNull(credits)){
                log.info(ErrorTypeEnum.NO_MONEY.getMsg());
                return null;
            }
            if (credits < 0){
                log.info(ErrorTypeEnum.CREDITS_MUST_GREATER_THAN_ZERO.getMsg());
                return null;
            }

            //依據輸入的轉出帳號及轉入帳號分別找到兩人
            User transferFromUser = userRepository.findByName(transferFrom);
            User transferToUser = userRepository.findByName(transferTo);
            List<AccountDetail> transferFromAccountList = accountDetailRepository.findByCreateUserOrderByCreateTimeDesc(transferFrom);
            List<AccountDetail> transferToAccountList = accountDetailRepository.findByCreateUserOrderByCreateTimeDesc(transferTo);
            if (Objects.isNull(transferFromUser)){
                log.info(ErrorTypeEnum.NO_TRANSFER_FROM.getMsg());
                return null;
            }
            if (Objects.isNull(transferToUser)){
                log.info(ErrorTypeEnum.NO_TRANSFER_TO.getMsg());
                return null;
            }

            // 判斷轉出帳號餘額是否足夠
            if (transferFromAccountList.get(0).getBalance() < credits){
                log.info(ErrorTypeEnum.BALANCE_NOT_ENOUGH.getMsg());
                return null;
            }

            // 處理轉出帳號資料
            AccountDetail transferFromAccount = new AccountDetail();
            transferFromAccount.setAction(ActionEnum.TRANSFER.getMsg());
            transferFromAccount.setCredits(credits);
            transferFromAccount.setBalance(transferFromAccountList.get(0).getBalance() - credits);
            if (Objects.nonNull(comment)){
                transferFromAccount.setComment(comment);
            }
            transferFromAccount.setTransferTo(transferTo);
            transferFromAccount.setCreateUser(transferFrom);
            transferFromAccount.setCreateTime(LocalDateTime.now());
            accountDetailRepository.saveAndFlush(transferFromAccount);

            // 處理轉入帳號資料
            AccountDetail transferToAccount = new AccountDetail();
            transferToAccount.setAction(ActionEnum.TRANSFER.getMsg());
            transferToAccount.setCredits(credits);
            if (CollectionUtils.isEmpty(transferToAccountList) || transferToAccountList.get(0).getBalance() == 0){
                transferToAccount.setBalance(credits);
            } else {
                transferToAccount.setBalance(transferToAccountList.get(0).getBalance() + credits);
            }
            if (Objects.nonNull(comment)){
                transferToAccount.setComment(comment);
            }
            transferToAccount.setTransferFrom(transferFrom);
            transferToAccount.setCreateUser(transferTo);
            transferToAccount.setCreateTime(LocalDateTime.now());
            accountDetailRepository.saveAndFlush(transferToAccount);

            log.info(StatusEnum.TRANSFER_SUCCESS.getMsg());
        }
        return "redirect:/index";
    }
}
