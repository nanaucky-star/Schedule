package com.wuwu.schedule.Service;

import com.wuwu.schedule.POJO.SysUser;

public interface SysUserService {
    /**
     * 注册用户
     * @param sysUser
     * @return
     */
    boolean regist(SysUser sysUser);

    boolean login(SysUser sysUser);

    SysUser findByUsername(String username);
}
