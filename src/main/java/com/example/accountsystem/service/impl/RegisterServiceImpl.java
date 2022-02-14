package com.example.accountsystem.service.impl;

import com.example.accountsystem.entity.User;
import com.example.accountsystem.repository.UserRepository;
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
    UserRepository userRepository;

    @Override
    public String register(String name, String password) {
        User user = userRepository.findByName(name);
        if (Objects.nonNull(user)){
            log.info("Register false");
            return null;
        } else {
            User newUser = new User();
            newUser.setName(name);
            newUser.setPassword(password);
            newUser.setCreateTime(LocalDateTime.now());
            userRepository.saveAndFlush(newUser);
            return "login";
        }
    }
}
