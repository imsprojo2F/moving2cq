package com.movingcq.dao;

import java.util.List;
import java.util.Map;

import com.movingcq.entity.CarInfo;

public interface CarInfoMapper {
	int deleteByPrimaryKey(String id);

	int insert(CarInfo record);

	int insertSelective(CarInfo record);

	CarInfo selectByPrimaryKey(String id);

	int updateByPrimaryKeySelective(CarInfo record);

	int updateByPrimaryKey(CarInfo record);

	List<CarInfo> listAllCar(Map<String, Object> qMap);

	List<Map<String, Object>> selectByPage(Map<String, Object> qMap);

	List<CarInfo> selectByCarCode(Map<String, Object> qMap);
}