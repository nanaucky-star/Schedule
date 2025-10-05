package com.wuwu.schedule.test;

import jakarta.servlet.ServletContext;
import jakarta.servlet.ServletException;
import jakarta.servlet.annotation.WebServlet;
import jakarta.servlet.http.HttpServlet;
import jakarta.servlet.http.HttpServletRequest;
import jakarta.servlet.http.HttpServletResponse;
import jakarta.servlet.http.HttpSession;

import java.io.IOException;


@WebServlet("/servletA")
public class ServletA extends HttpServlet {
    @Override
    protected void service(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
        //请求域
        req.setAttribute("request", "reqMsg");
        //会话域
        HttpSession session = req.getSession();
        session.setAttribute("session", "sessionMsg");
        //应用域
        ServletContext servletContext = getServletContext();
        servletContext.setAttribute("application", "SCMsg");
        //获取请求域数据
        String request =(String) req.getAttribute("request");
        System.out.println("请求域："+request);
        //转发请求
        req.getRequestDispatcher("/servletB").forward(req, resp);

        //重定向

        //转发请求和重定向的区别
    }
}
