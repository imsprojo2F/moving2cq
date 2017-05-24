package com.movingcq.dao;

import com.movingcq.entity.ParameterRecord;

public interface ParameterRecordMapper {
    int deleteByPrimaryKey(String id);

    int insert(ParameterRecord record);

    int insertSelective(ParameterRecord record);

    ParameterRecord selectByPrimaryKey(String id);

    int updateByPrimaryKeySelective(ParameterRecord record);

    int updateByPrimaryKey(ParameterRecord record);
}