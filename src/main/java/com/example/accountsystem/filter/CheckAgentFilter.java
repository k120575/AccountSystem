package com.example.accountsystem.filter;


import org.apache.commons.logging.Log;
import org.apache.commons.logging.LogFactory;
import org.springframework.core.annotation.Order;

import javax.servlet.*;
import javax.servlet.annotation.WebFilter;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.io.IOException;

@Order(1)
@WebFilter(filterName = "CheckAgentFilter", urlPatterns = "/*")
public class CheckAgentFilter implements Filter {

    private Log log = LogFactory.getLog(CheckAgentFilter.class);

    @Override
    public void init(FilterConfig filterConfig) throws ServletException {

    }

    @Override
    public void doFilter(ServletRequest servletRequest, ServletResponse servletResponse, FilterChain filterChain) throws IOException, ServletException {
        HttpServletRequest req = (HttpServletRequest)servletRequest;
        String url[] = req.getRequestURI().split("/");

        if(!(url[1].contains("login") || url[1].contains("register"))) {
            if (req.getSession().getAttribute("user") == null) {
                HttpServletResponse res = (HttpServletResponse) servletResponse;
                res.sendRedirect(req.getContextPath() + "/login");
            }
        }
        filterChain.doFilter(servletRequest,servletResponse);
    }

    @Override
    public void destroy() {

    }
}
