package com.movingcq.dao;

import java.util.List;
import java.util.Map;

import com.movingcq.entity.MapBasicInfo;

public interface MapBasicInfoMapper {
	int deleteByPrimaryKey(Integer id);

	int deleteByCodes(String[] codes);

	int insert(MapBasicInfo record);

	int insertSelective(MapBasicInfo record);

	MapBasicInfo selectByPrimaryKey(Integer id);

	List<Map<Object, Object>> selectByKey(Map<String, String> map);

	List<Map<Object, Object>> getStartPoint(Map<String, String> map);

	List<Map<Object, Object>> getCarId(Map<String, String> map);

	List<Map<Object, Object>> selectByIds(String[] ids);

	List<Map<Object, Object>> selectByCarIds(String[] ids);

	int updateByPrimaryKeySelective(MapBasicInfo record);

	int updateByPrimaryKey(MapBasicInfo record);

	int updateByLng(Map<String, String> map);

	int updateByCarId(Map<String, String> map);

	int updateStart(Map<String, String> map);
}