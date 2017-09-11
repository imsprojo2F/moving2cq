package com.movingcq.service.impl;

import java.util.List;
import java.util.Map;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.movingcq.dao.RestInfoMapper;
import com.movingcq.entity.RestaurantInfo;
import com.movingcq.service.IRestInfoService;

@Service("restInfoService")
public class RestInfoServiceImpl implements IRestInfoService {

	@Autowired
	private RestInfoMapper restInfoMapper;

	@Override
	public int insert(RestaurantInfo rInfo) {
		// TODO Auto-generated method stub
		return restInfoMapper.insert(rInfo);
	}

	/*
	 * Title: deleteById Description:
	 * 
	 * @param ids
	 * 
	 * @return
	 * 
	 * @see com.movingcq.service.IRestInfoService#deleteById(java.lang.String[])
	 */

	@Override
	public int deleteById(String[] ids) {
		// TODO Auto-generated method stub
		return restInfoMapper.deleteById(ids);
	}

	/*
	 * Title: updateById Description:
	 * 
	 * @param sysUser
	 * 
	 * @return
	 * 
	 * @see
	 * com.movingcq.service.IRestInfoService#updateById(com.movingcq.entity.
	 * SysUser)
	 */

	@Override
	public int updateById(RestaurantInfo rInfo) {
		// TODO Auto-generated method stub
		return restInfoMapper.updateById(rInfo);
	}

	@Override
	public int updateByCode(RestaurantInfo rInfo) {
		// TODO Auto-generated method stub
		return restInfoMapper.updateByCode(rInfo);
	}

	/*
	 * Title: listAllRestInfo Description:
	 * 
	 * @param key
	 * 
	 * @return
	 * 
	 * @see
	 * com.movingcq.service.IRestInfoService#listAllRestInfo(java.lang.String)
	 */

	@Override
	public List<RestaurantInfo> listAllRestInfo(Map<String, Object> qMap) {
		// TODO Auto-generated method stub
		return restInfoMapper.listAllRestInfo(qMap);
	}

	/*
	 * Title: selectByPage Description:
	 * 
	 * @param qParameters
	 * 
	 * @return
	 * 
	 * @see
	 * com.movingcq.service.IRestInfoService#selectByPage(com.movingcq.entity.
	 * QueryParameters)
	 */

	@Override
	public List<Map<String, Object>> selectByPage(Map<String, Object> qMap) {
		// TODO Auto-generated method stub
		return restInfoMapper.selectByPage(qMap);
	}

	/*
	 * (non-Javadoc)
	 * 
	 * @see com.movingcq.service.IRestInfoService#insertByCode(java.lang.String,
	 * java.lang.String)
	 */
	@Override
	public int insertByCode(String code, String fileName, String filepath) {
		// TODO Auto-generated method stub
		return restInfoMapper.insertByCode(code, fileName, filepath);
	}

	/*
	 * (non-Javadoc)
	 * 
	 * @see
	 * com.movingcq.service.IRestInfoService#updateFilePath(java.lang.String)
	 */
	@Override
	public int updateFilePath(String uuid, String fileName, String filepath) {
		// TODO Auto-generated method stub
		return restInfoMapper.updateFilePath(uuid, fileName, filepath);
	}

	@Override
	public int delFilePath(String uuid) {
		// TODO Auto-generated method stub
		return restInfoMapper.delFilePath(uuid);
	}

	/*
	 * Title: updateByDynamic Description:
	 * 
	 * @param map
	 * 
	 * @return
	 * 
	 * @see com.movingcq.service.IRestInfoService#updateByDynamic(java.util.Map)
	 */

	@Override
	public int updateByDynamic(Map<String, String> map) {
		// TODO Auto-generated method stub
		return restInfoMapper.updateByDynamic(map);
	}

	/*
	 * Title: selectById Description:
	 * 
	 * @param qMap
	 * 
	 * @return
	 * 
	 * @see com.movingcq.service.IRestInfoService#selectById(java.util.Map)
	 */

	@Override
	public List<Map<String, String>> selectById(Map<String, Object> qMap) {
		// TODO Auto-generated method stub

		return restInfoMapper.getById(qMap);
	}

	@Override
	public int selectById(String id) {
		// TODO Auto-generated method stub
		return restInfoMapper.selectById(id);
	}

}
