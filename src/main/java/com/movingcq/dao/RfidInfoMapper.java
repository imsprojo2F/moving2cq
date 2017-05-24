package com.movingcq.dao;

import java.util.List;
import java.util.Map;

import com.movingcq.entity.RfidInfo;

public interface RfidInfoMapper {

	List<RfidInfo> listAllRfid(Map<String, Object> qMap);

	List<RfidInfo> listUnUseRfid(String[] ids);

	List<Map<String, String>> selectByPage(Map<String, Object> qMap);

	RfidInfo selectByRfid(String rfid);

	/**
	 * @param sysBucket
	 * @return
	 */
	int insert(RfidInfo rfidInfo);

	/**
	 * @param ids
	 * @return
	 */
	int deleteById(String[] ids);

	/**
	 * @param RfidInfo
	 * @return
	 */
	int updateById(RfidInfo rfidInfo);

	int updateByIds(String[] ids);

	int updateByRfid(int isUse, String rfid);

	int selectById(String id);
}