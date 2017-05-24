package com.movingcq.dao;

import com.movingcq.entity.DailyReport;

public interface DailyReportMapper {
    int deleteByPrimaryKey(Integer id);

    int insert(DailyReport record);

    int insertSelective(DailyReport record);

    DailyReport selectByPrimaryKey(Integer id);

    int updateByPrimaryKeySelective(DailyReport record);

    int updateByPrimaryKey(DailyReport record);
}