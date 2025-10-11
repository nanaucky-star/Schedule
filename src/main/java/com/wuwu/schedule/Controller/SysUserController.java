package com.wuwu.schedule.Controller;

import com.fasterxml.jackson.databind.ObjectMapper;
import com.wuwu.schedule.POJO.SysUser;
import com.wuwu.schedule.Service.Impl.SysUserServiceImpl;
import com.wuwu.schedule.Service.SysUserService;
import com.wuwu.schedule.common.Result;
import com.wuwu.schedule.common.ResultCodeEnum;
import com.wuwu.schedule.util.MD5Util;
import com.wuwu.schedule.util.WebUtil;
import jakarta.servlet.ServletException;
import jakarta.servlet.annotation.WebServlet;
import jakarta.servlet.http.HttpServlet;
import jakarta.servlet.http.HttpServletRequest;
import jakarta.servlet.http.HttpServletResponse;
import jakarta.servlet.http.HttpSession;

import java.io.IOException;
import java.lang.reflect.Method;


@WebServlet("/user/*")
public class SysUserController extends BaseController {

    private SysUserService userService=new SysUserServiceImpl();

    protected void regist(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
        String username = req.getParameter("username");
        String password = req.getParameter("userPwd");
        SysUser sysUser=new SysUser(null,username,password);

        if(userService.regist(sysUser)){
            resp.sendRedirect("/registSuccess.html");
        }else {
            resp.sendRedirect("/registFail.html");
        }

        resp.sendRedirect("/login");
    }

    protected void checkUsernameUsed(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
        String username = req.getParameter("username");

        SysUser user = userService.findByUsername(username);

        Result result=Result.ok(null);

        if(user!=null){
            result=Result.build(null, ResultCodeEnum.USERNAME_USED);
        }

        WebUtil.writeJson(resp,result);

    }


    protected void login(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
        String username = req.getParameter("username");
        String password = req.getParameter("userPwd");
        SysUser loginUser=userService.findByUsername(username);

        if(loginUser==null){
            resp.sendRedirect("/loginUsernameError.html");
        }else if(!MD5Util.encrypt(password).equals(loginUser.getUserPwd())){
            resp.sendRedirect("/loginUserPwdError.html");
        }else{
            //登陆成功后将登陆的用户信息放入session
            HttpSession session=req.getSession();
            session.setAttribute("sysUser",loginUser);

            resp.sendRedirect("/loginSuccess.html");
        }
    }
}
