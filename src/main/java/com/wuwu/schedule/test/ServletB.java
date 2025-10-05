package com.wuwu.schedule.test;


import jakarta.servlet.ServletContext;
import jakarta.servlet.ServletException;
import jakarta.servlet.annotation.WebServlet;
import jakarta.servlet.http.HttpServlet;
import jakarta.servlet.http.HttpServletRequest;
import jakarta.servlet.http.HttpServletResponse;
import jakarta.servlet.http.HttpSession;

import java.io.IOException;

@WebServlet("/servletB")
public class ServletB extends HttpServlet {
    @Override
    protected void service(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
        //获取请求域数据
        String request =(String) req.getAttribute("request");
        System.out.println("请求域："+request);

        //获取会话域数据
        HttpSession session = req.getSession();
        String sessionMsg = (String)session.getAttribute("sessionMsg");
        System.out.println("会话域："+sessionMsg);

        //获取应用域数据
        ServletContext servletContext = getServletContext();
        String SCMsg =(String)servletContext.getAttribute("application");
        System.out.println("应用域："+SCMsg);

    }
}
