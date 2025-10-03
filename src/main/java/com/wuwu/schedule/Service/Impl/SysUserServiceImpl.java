package com.wuwu.schedule.Service.Impl;

import com.wuwu.schedule.DAO.Impl.SysUserImpl;
import com.wuwu.schedule.DAO.SysUserDAO;
import com.wuwu.schedule.POJO.SysUser;
import com.wuwu.schedule.Service.SysUserService;
import com.wuwu.schedule.util.MD5Util;

public class SysUserServiceImpl implements SysUserService {

    private SysUserDAO sysUserDAO=new SysUserImpl();

    @Override
    public boolean regist(SysUser sysUser) {
        sysUser.setUserPwd(MD5Util.encrypt(sysUser.getUserPwd()));//加密密码
        //调用DAO层的方法 将sysUser信息存入数据库

        return sysUserDAO.addUser(sysUser);
    }

    @Override
    public boolean login(SysUser sysUser) {
        return false;
    }

    @Override
    public SysUser findByUsername(String username) {
        SysUser sysUser=sysUserDAO.findByUsername(username);
        return sysUser;
    }
}
