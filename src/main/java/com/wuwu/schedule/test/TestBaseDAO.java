package com.wuwu.schedule.test;

import com.wuwu.schedule.DAO.BaseDAO;
import com.wuwu.schedule.POJO.SysUser;
import org.testng.annotations.BeforeClass;
import org.testng.annotations.Test;

import java.util.List;

public class TestBaseDAO {

    private static BaseDAO baseDAO;

    @BeforeClass
    public static void initBaseDAO(){
        baseDAO = new BaseDAO();
    }

    @Test
    public void testBaseQueryObject(){
        //查询用户数量
        String sql="select count(1) from sys_user";
        Long l = baseDAO.baseQueryObject(Long.class, sql);
        System.out.println(l);
    }

    @Test
    public void testBaseQuery(){
        String sql="select uid,username,user_pwd as userPwd from sys_user";
        List<SysUser> sysUserList = baseDAO.baseQuery(SysUser.class, sql);
        sysUserList.forEach(System.out::println);
    }

    @Test
    public void testBaseUpdate(){
        String sql="insert into sys_schedule values(default,?,?,?)";
        int rows =baseDAO.baseUpdate(sql,1,"123",0);
        System.out.println(rows);
    }
}
