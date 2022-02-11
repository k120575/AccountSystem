package com.example.accountsystem.service;

import javax.servlet.ServletException;
import javax.servlet.http.HttpServletRequest;

public interface LoginService {

    String getLogin(String name, String password, HttpServletRequest req);

    String logout(HttpServletRequest req) throws ServletException;
}
