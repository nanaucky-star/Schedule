package com.wuwu.schedule.test.filter;


import jakarta.servlet.*;
import jakarta.servlet.http.HttpServletRequest;
import jakarta.servlet.http.HttpServletResponse;

import java.io.IOException;
import java.text.SimpleDateFormat;
import java.util.Date;

public class LoggingFilter implements Filter {
    private SimpleDateFormat sdf = new SimpleDateFormat("yyyy-MM-dd HH:mm:ss");
    @Override
    public void doFilter(ServletRequest servletRequest, ServletResponse servletResponse, FilterChain filterChain) throws IOException, ServletException {
        //参数向下转型
        HttpServletRequest req = (HttpServletRequest) servletRequest;
        HttpServletResponse resp = (HttpServletResponse) servletResponse;

        //req前打印日志
        String requestURI = req.getRequestURI();
        String dateTime=sdf.format(new Date());
        String beforeLogging=requestURI+" access at"+dateTime;
        System.out.println(beforeLogging);
        long startTime = System.currentTimeMillis();

        //放行
        filterChain.doFilter(servletRequest, servletResponse);

        long endTime = System.currentTimeMillis();
        //resp后打印***资源的请求耗时
        System.out.println(requestURI+" cost "+(endTime-startTime)+"ms");


    }
}
