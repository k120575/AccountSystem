package com.example.accountsystem.service.impl;

import com.example.accountsystem.entity.AccountDetail;
import com.example.accountsystem.entity.User;
import com.example.accountsystem.enums.ErrorTypeEnum;
import com.example.accountsystem.enums.StatusEnum;
import com.example.accountsystem.repository.AccountDetailRepository;
import com.example.accountsystem.service.InquiryService;
import org.apache.commons.logging.Log;
import org.apache.commons.logging.LogFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.domain.Page;
import org.springframework.stereotype.Service;
import org.springframework.ui.Model;
import org.springframework.util.CollectionUtils;

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
                model.addAttribute("accountDetails", accountDetails);
            } else {
                model.addAttribute("hasData", false);
                model.addAttribute("balance", 0);
            }
            log.info(StatusEnum.INQUIRY_SUCCESS.getMsg());
            return "inquiry";
        } else {
            model.addAttribute("isLogin", false);
            log.info(ErrorTypeEnum.NOT_LOGIN.getMsg());
            return "redirect:/index";
        }
    }

    @Override
    public String doSearch(String startDate, String endDate, Model model, HttpServletRequest req) {
        User user = new User();
        if (req.getSession().getAttribute("user") != null){
            if (Objects.nonNull(startDate) && Objects.isNull(endDate)){
                log.info(ErrorTypeEnum.NO_END_DATE.getMsg());
                return null;
            }
            if (Objects.isNull(startDate) && Objects.nonNull(endDate)){
                log.info(ErrorTypeEnum.NO_START_DATE.getMsg());
                return null;
            }

            String name = (String)req.getSession().getAttribute("user");
            user.setName(name);
            DateTimeFormatter dtf = DateTimeFormatter.ofPattern("yyyy/MM/dd HH:mm:ss");
            DateTimeFormatter dtf2 = DateTimeFormatter.ofPattern("yyyy-MM-dd HH:mm:ss");
            model.addAttribute("user", user);
            model.addAttribute("isLogin", true);
            model.addAttribute("currentTime", dtf.format(LocalDateTime.now()));
            if (Objects.nonNull(startDate) && Objects.nonNull(endDate)){
                List<AccountDetail> accountDetails = accountDetailRepository.findByCreateTimeBetweenOrderByCreateTimeDesc(
                        LocalDateTime.parse(startDate + " 00:00:00", dtf2), LocalDateTime.parse(endDate + " 23:59:59", dtf2));
                if (CollectionUtils.isEmpty(accountDetails)){
                    log.info(ErrorTypeEnum.NO_DATA.getMsg());
                    model.addAttribute("hasData", false);
                    model.addAttribute("balance", 0);
                } else {
                    model.addAttribute("hasData", true);
                    model.addAttribute("balance", accountDetails.get(0).getBalance());
                    model.addAttribute("accountDetails", accountDetails);
                }
                log.info(StatusEnum.SEARCH_SUCCESS.getMsg());
            }
        }
        return "inquiry";
    }
}
