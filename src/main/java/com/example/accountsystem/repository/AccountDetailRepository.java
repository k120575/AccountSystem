package com.example.accountsystem.repository;

import com.example.accountsystem.entity.AccountDetail;
import org.springframework.data.domain.Page;
import org.springframework.data.jpa.repository.JpaRepository;

import java.time.LocalDateTime;
import java.util.List;

public interface AccountDetailRepository extends JpaRepository<AccountDetail, Integer> {

    List<AccountDetail> findByCreateUserOrderByCreateTimeDesc(String user);

    List<AccountDetail> findByCreateUserAndCreateTimeBetweenOrderByCreateTimeDesc(String user, LocalDateTime startDate, LocalDateTime endDate);
}
