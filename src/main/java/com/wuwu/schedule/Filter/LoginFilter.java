package com.wuwu.schedule.Filter;

import com.wuwu.schedule.POJO.SysUser;
import jakarta.servlet.*;
import jakarta.servlet.annotation.WebFilter;
import jakarta.servlet.http.HttpServletRequest;
import jakarta.servlet.http.HttpServletResponse;
import jakarta.servlet.http.HttpSession;

import java.io.IOException;

@WebFilter(urlPatterns = {"/showSchedule.html","/schedule/*"})
public class LoginFilter implements Filter {
    @Override
    public void doFilter(ServletRequest servletRequest, ServletResponse servletResponse, FilterChain filterChain) throws IOException, ServletException {
        //参数向下转型
        HttpServletRequest req = (HttpServletRequest) servletRequest;
        HttpServletResponse resp = (HttpServletResponse) servletResponse;

        //获取session中的用户信息
        HttpSession session=req.getSession();
        SysUser sysUser=(SysUser) session.getAttribute("sysUser");

        if(sysUser==null){
            resp.sendRedirect("/filter.html");
        }else{
            filterChain.doFilter(servletRequest,servletResponse);
        }
    }
}
