package com.wuwu.schedule.test;

import com.wuwu.schedule.DAO.Impl.SysScheduleImpl;
import com.wuwu.schedule.DAO.SysScheduleDAO;
import com.wuwu.schedule.POJO.SysSchedule;
import org.testng.annotations.BeforeClass;
import org.testng.annotations.Test;

import java.util.List;

public class TestSysScheduleDao {
    private static SysScheduleDAO sysScheduleDao;
    @BeforeClass
    public static void initSysScheduleDao(){
        sysScheduleDao = new SysScheduleImpl();
    }
    @Test
    public void testAddSchedule(){
        int rows = sysScheduleDao.addSchedule(new SysSchedule(null, 2, "学你吗", 0));
        System.out.println(rows);
    }
    @Test
    public void testFindAll(){
        List<SysSchedule> list = sysScheduleDao.findAll();
        list.forEach(System.out::println);
    }
}
