package com.movingcq.service;

import java.util.List;
import java.util.Map;

import com.movingcq.entity.RfidInfo;

public interface IRfidInfoService {

	public int insert(RfidInfo rfidInfo);

	public int deleteById(String[] ids);

	public int updateById(RfidInfo rfidInfo);

	public int updateByRfid(int isUse, String rfid);

	public int updateByIds(String[] ids);

	public List<RfidInfo> listAllRfidInfo(Map<String, Object> qMap);

	public List<RfidInfo> listUnUseRfid(String[] ids);

	public List<Map<String, String>> selectByPage(Map<String, Object> qMap);

	RfidInfo selectByRfid(String rfid);

	int selectById(String id);
}
