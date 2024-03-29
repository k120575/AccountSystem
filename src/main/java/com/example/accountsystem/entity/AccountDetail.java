package com.example.accountsystem.entity;

import lombok.Data;

import javax.persistence.*;
import java.time.LocalDateTime;

@Entity
@Data
@Table(name = "account_detail")
public class AccountDetail {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private int id;

    @Column
    private String action;

    @Column
    private int credits;

    @Column
    private int balance;

    @Column(name = "income_type")
    private String incomeType;

    @Column(name = "expenditure_type")
    private String expenditureType;

    @Column(name = "transfer_from")
    private String transferFrom;

    @Column(name = "transfer_to")
    private String transferTo;

    @Column
    private String comment;

    @Column(name = "create_user")
    private String createUser;

    @Column(name = "create_time")
    private LocalDateTime createTime;
}
