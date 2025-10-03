package com.wuwu.schedule.DAO.Impl;

import com.wuwu.schedule.DAO.BaseDAO;
import com.wuwu.schedule.DAO.SysUserDAO;
import com.wuwu.schedule.POJO.SysUser;

import java.util.List;

public class SysUserImpl extends BaseDAO implements SysUserDAO {

    @Override
    public boolean addUser(SysUser sysUser) {
        String sql = "INSERT INTO sys_user VALUES (default, ?,  ?)";
        return baseUpdate(sql, sysUser.getUsername(), sysUser.getUserPwd())>0;
    }

    @Override
    public SysUser findByUsername(String username) {
        String sql = "SELECT uid,username,user_pwd as userPwd FROM sys_user WHERE username=?";
        List<SysUser> sysUsers = baseQuery(SysUser.class, sql, username);
        return !sysUsers.isEmpty() ? sysUsers.get(0) : null;
    }
}
