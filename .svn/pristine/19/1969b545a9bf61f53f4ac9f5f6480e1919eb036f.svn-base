package com.movingcq.service.impl;

import java.util.List;
import java.util.Map;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.movingcq.dao.RfidInfoMapper;
import com.movingcq.entity.RfidInfo;
import com.movingcq.service.IRfidInfoService;

@Service("rfidService")
public class RfidInfoServiceImpl implements IRfidInfoService {

	@Autowired
	private RfidInfoMapper rfidInfoMapper;

	/*
	 * Title: addRfidInfo Description:
	 * 
	 * @param rfidInfo
	 * 
	 * @return
	 * 
	 * @see
	 * com.movingcq.service.IRfidInfoService#addRfidInfo(com.movingcq.entity
	 * .RfidInfo)
	 */

	@Override
	public int insert(RfidInfo rfidInfo) {
		// TODO Auto-generated method stub
		return rfidInfoMapper.insert(rfidInfo);
	}

	/*
	 * Title: deleteById Description:
	 * 
	 * @param ids
	 * 
	 * @return
	 * 
	 * @see com.movingcq.service.IRfidInfoService#deleteById(java.lang.String[])
	 */

	@Override
	public int deleteById(String[] ids) {
		// TODO Auto-generated method stub
		return rfidInfoMapper.deleteById(ids);
	}

	/*
	 * Title: updateById Description:
	 * 
	 * @param rfidInfo
	 * 
	 * @return
	 * 
	 * @see
	 * com.movingcq.service.IRfidInfoService#updateById(com.movingcq.entity.
	 * RfidInfo)
	 */

	@Override
	public int updateById(RfidInfo rfidInfo) {
		// TODO Auto-generated method stub
		return rfidInfoMapper.updateById(rfidInfo);
	}

	@Override
	public int updateByIds(String[] ids) {
		// TODO Auto-generated method stub
		return rfidInfoMapper.updateByIds(ids);
	}

	/*
	 * Title: listAllRfidInfo Description:
	 * 
	 * @param qParameters
	 * 
	 * @return
	 * 
	 * @see com.movingcq.service.IRfidInfoService#listAllRfidInfo(com.movingcq.
	 * entity.QueryParameters)
	 */

	@Override
	public List<RfidInfo> listAllRfidInfo(Map<String, Object> qMap) {
		// TODO Auto-generated method stub
		return rfidInfoMapper.listAllRfid(qMap);
	}

	@Override
	public List<RfidInfo> listUnUseRfid(String[] ids) {
		// TODO Auto-generated method stub
		return rfidInfoMapper.listUnUseRfid(ids);
	}

	/*
	 * Title: selectByPage Description:
	 * 
	 * @param qParameters
	 * 
	 * @return
	 * 
	 * @see
	 * com.movingcq.service.IRfidInfoService#selectByPage(com.movingcq.entity.
	 * QueryParameters)
	 */

	@Override
	public List<Map<String, String>> selectByPage(Map<String, Object> qMap) {
		// TODO Auto-generated method stub
		return rfidInfoMapper.selectByPage(qMap);
	}

	@Override
	public RfidInfo selectByRfid(String rfid) {
		// TODO Auto-generated method stub
		return rfidInfoMapper.selectByRfid(rfid);
	}

	/*
	 * Title: updateByRfid Description:
	 * 
	 * @param isUse
	 * 
	 * @param rfid
	 * 
	 * @return
	 * 
	 * @see com.movingcq.service.IRfidInfoService#updateByRfid(int,
	 * java.lang.String)
	 */

	@Override
	public int updateByRfid(int isUse, String rfid) {
		// TODO Auto-generated method stub
		return rfidInfoMapper.updateByRfid(isUse, rfid);
	}

	/*
	 * Title: selectById Description:
	 * 
	 * @param id
	 * 
	 * @return
	 * 
	 * @see com.movingcq.service.IRfidInfoService#selectById(java.lang.String)
	 */

	@Override
	public int selectById(String id) {
		// TODO Auto-generated method stub
		return rfidInfoMapper.selectById(id);
	}

}
