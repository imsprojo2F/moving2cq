package com.movingcq.dao;

import com.movingcq.entity.CarWeigh;

public interface CarWeighMapper {
    int deleteByPrimaryKey(String id);

    int insert(CarWeigh record);

    int insertSelective(CarWeigh record);

    CarWeigh selectByPrimaryKey(String id);

    int updateByPrimaryKeySelective(CarWeigh record);

    int updateByPrimaryKeyWithBLOBs(CarWeigh record);

    int updateByPrimaryKey(CarWeigh record);
}