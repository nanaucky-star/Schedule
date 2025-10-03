package com.wuwu.schedule.DAO;


import com.wuwu.schedule.POJO.SysSchedule;

import java.util.List;

public interface SysScheduleDAO {

    int addSchedule(SysSchedule schedule);
    List<SysSchedule> findAll();

}
