package com.wuwu.schedule.DAO.Impl;

import com.wuwu.schedule.DAO.BaseDAO;
import com.wuwu.schedule.DAO.SysScheduleDAO;
import com.wuwu.schedule.POJO.SysSchedule;

import java.util.List;

public class SysScheduleImpl extends BaseDAO implements SysScheduleDAO {
    @Override
    public int addSchedule(SysSchedule schedule) {
        String sql = "INSERT INTO sys_schedule VALUES (default, ?, ?, ?)";
        return baseUpdate(sql, schedule.getUid(), schedule.getTitle(), schedule.getCompleted());
    }

    @Override
    public List<SysSchedule> findAll() {
        String sql = "SELECT * FROM sys_schedule";
        return baseQuery(SysSchedule.class, sql);
    }
}
