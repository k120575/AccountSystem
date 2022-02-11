package com.example.accountsystem.service.impl;

import com.example.accountsystem.entity.Member;
import com.example.accountsystem.repository.MemberRepository;
import com.example.accountsystem.service.RegisterService;
import org.apache.commons.logging.Log;
import org.apache.commons.logging.LogFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.time.LocalDateTime;
import java.util.Objects;

@Service
public class RegisterServiceImpl implements RegisterService {

    private Log log = LogFactory.getLog(RegisterServiceImpl.class);

    @Autowired
    MemberRepository memberRepository;

    @Override
    public String register(String name, String password) {
        Member member = memberRepository.findByName(name);
        if (Objects.nonNull(member)){
            log.info("Register false");
            return null;
        } else {
            Member newMember = new Member();
            newMember.setName(name);
            newMember.setPassword(password);
            newMember.setCreateTime(LocalDateTime.now());
            memberRepository.saveAndFlush(newMember);
            return "login";
        }
    }
}
