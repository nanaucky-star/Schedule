package com.wuwu.schedule.DAO;

import com.wuwu.schedule.POJO.SysUser;

public interface SysUserDAO {

    boolean addUser(SysUser sysUser);

    SysUser findByUsername(String username);
}
