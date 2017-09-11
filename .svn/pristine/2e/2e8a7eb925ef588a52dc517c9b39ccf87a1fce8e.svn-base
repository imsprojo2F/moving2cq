package com.movingcq.dao;

import java.util.List;
import java.util.Map;

import com.movingcq.entity.RestaurantInfo;

public interface RestInfoMapper {

	int insert(RestaurantInfo rInfo);

	int insertByCode(String code, String fileName, String filepath);

	/**
	 * @param ids
	 * @return
	 */
	int deleteById(String[] ids);

	/**
	 * @param sysUser
	 * @return
	 */
	int updateById(RestaurantInfo rInfo);

	int updateByCode(RestaurantInfo rInfo);

	int updateByDynamic(Map<String, String> map);

	int updateFilePath(String uuid, String fileName, String filepath);

	int delFilePath(String uuid);

	List<RestaurantInfo> listAllRestInfo(Map<String, Object> qMap);

	List<Map<String, Object>> selectByPage(Map<String, Object> qMap);

	public List<Map<String, String>> getById(Map<String, Object> qMap);

	int selectById(String id);
}