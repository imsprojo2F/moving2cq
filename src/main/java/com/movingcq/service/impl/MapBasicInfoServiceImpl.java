/**   
* @Title: MapBasicInfoServiceImpl.java 
* @Package com.movingcq.service.impl 
* @Description: TODO(用一句话描述该文件做什么) 
* @author IsProjo
* @date 2017年2月20日 上午10:44:52 
* @version V1.0   
*/
package com.movingcq.service.impl;

import java.util.List;
import java.util.Map;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.movingcq.dao.MapBasicInfoMapper;
import com.movingcq.entity.MapBasicInfo;
import com.movingcq.service.IMapBasicInfoService;

/**
 * @ClassName: MapBasicInfoServiceImpl
 * @Description: TODO(这里用一句话描述这个类的作用)
 * @author IsProjo
 * @date 2017年2月20日 上午10:44:52
 * 
 */
@Service("mapBasicInfoService")
public class MapBasicInfoServiceImpl implements IMapBasicInfoService {

	@Autowired
	private MapBasicInfoMapper mapMapper;

	/*
	 * Title: deleteByPrimaryKey Description:
	 * 
	 * @param id
	 * 
	 * @return
	 * 
	 * @see
	 * com.movingcq.service.IMapBasicInfoService#deleteByPrimaryKey(java.lang.
	 * Integer)
	 */

	@Override
	public int deleteByPrimaryKey(Integer id) {
		// TODO Auto-generated method stub
		return mapMapper.deleteByPrimaryKey(id);
	}

	/*
	 * Title: insert Description:
	 * 
	 * @param record
	 * 
	 * @return
	 * 
	 * @see
	 * com.movingcq.service.IMapBasicInfoService#insert(com.movingcq.entity.
	 * MapBasicInfo)
	 */

	@Override
	public int insert(MapBasicInfo record) {
		// TODO Auto-generated method stub
		return mapMapper.insert(record);
	}

	/*
	 * Title: insertSelective Description:
	 * 
	 * @param record
	 * 
	 * @return
	 * 
	 * @see
	 * com.movingcq.service.IMapBasicInfoService#insertSelective(com.movingcq.
	 * entity.MapBasicInfo)
	 */

	@Override
	public int insertSelective(MapBasicInfo record) {
		// TODO Auto-generated method stub
		return mapMapper.insertSelective(record);
	}

	/*
	 * Title: selectByPrimaryKey Description:
	 * 
	 * @param id
	 * 
	 * @return
	 * 
	 * @see
	 * com.movingcq.service.IMapBasicInfoService#selectByPrimaryKey(java.lang.
	 * Integer)
	 */

	@Override
	public MapBasicInfo selectByPrimaryKey(Integer id) {
		// TODO Auto-generated method stub
		return mapMapper.selectByPrimaryKey(id);
	}

	/*
	 * Title: updateByPrimaryKeySelective Description:
	 * 
	 * @param record
	 * 
	 * @return
	 * 
	 * @see
	 * com.movingcq.service.IMapBasicInfoService#updateByPrimaryKeySelective(com
	 * .movingcq.entity.MapBasicInfo)
	 */

	@Override
	public int updateByPrimaryKeySelective(MapBasicInfo record) {
		// TODO Auto-generated method stub
		return mapMapper.updateByPrimaryKeySelective(record);
	}

	/*
	 * Title: updateByPrimaryKey Description:
	 * 
	 * @param record
	 * 
	 * @return
	 * 
	 * @see
	 * com.movingcq.service.IMapBasicInfoService#updateByPrimaryKey(com.movingcq
	 * .entity.MapBasicInfo)
	 */

	@Override
	public int updateByPrimaryKey(MapBasicInfo record) {
		// TODO Auto-generated method stub
		return mapMapper.updateByPrimaryKey(record);
	}

	/*
	 * Title: deleteByCodes Description:
	 * 
	 * @param codes
	 * 
	 * @return
	 * 
	 * @see
	 * com.movingcq.service.IMapBasicInfoService#deleteByCodes(java.lang.String)
	 */

	@Override
	public int deleteByCodes(String[] codes) {
		// TODO Auto-generated method stub
		return mapMapper.deleteByCodes(codes);
	}

	/*
	 * Title: selectByArea Description:
	 * 
	 * @param map
	 * 
	 * @return
	 * 
	 * @see
	 * com.movingcq.service.IMapBasicInfoService#selectByArea(java.util.Map)
	 */

	@Override
	public List<Map<Object, Object>> selectByKey(Map<String, String> map) {
		// TODO Auto-generated method stub
		return mapMapper.selectByKey(map);
	}

	/*
	 * Title: selectAll Description:
	 * 
	 * @param map
	 * 
	 * @return
	 * 
	 * @see com.movingcq.service.IMapBasicInfoService#selectAll(java.util.Map)
	 */

	@Override
	public List<Map<Object, Object>> getStartPoint(Map<String, String> map) {
		// TODO Auto-generated method stub
		return mapMapper.getStartPoint(map);
	}

	/*
	 * Title: getCarId Description:
	 * 
	 * @param qMap
	 * 
	 * @return
	 * 
	 * @see com.movingcq.service.IMapBasicInfoService#getCarId(java.util.Map)
	 */

	@Override
	public List<Map<Object, Object>> getCarId(Map<String, String> qMap) {
		// TODO Auto-generated method stub
		return mapMapper.getCarId(qMap);
	}

	/*
	 * Title: selectByIds Description:
	 * 
	 * @param ids
	 * 
	 * @return
	 * 
	 * @see
	 * com.movingcq.service.IMapBasicInfoService#selectByIds(java.lang.String[])
	 */

	@Override
	public List<Map<Object, Object>> selectByIds(String[] ids) {
		// TODO Auto-generated method stub
		return mapMapper.selectByIds(ids);
	}

	/*
	 * Title: updateByLng Description:
	 * 
	 * @param map
	 * 
	 * @return
	 * 
	 * @see com.movingcq.service.IMapBasicInfoService#updateByLng(java.util.Map)
	 */

	@Override
	public int updateByLng(Map<String, String> map) {
		// TODO Auto-generated method stub
		return mapMapper.updateByLng(map);
	}

	/*
	 * Title: selectByCarIds Description:
	 * 
	 * @param ids
	 * 
	 * @return
	 * 
	 * @see
	 * com.movingcq.service.IMapBasicInfoService#selectByCarIds(java.lang.String
	 * [])
	 */

	@Override
	public List<Map<Object, Object>> selectByCarIds(String[] ids) {
		// TODO Auto-generated method stub
		return mapMapper.selectByCarIds(ids);
	}

	/*
	 * Title: updateByCarId Description:
	 * 
	 * @param qMap
	 * 
	 * @return
	 * 
	 * @see
	 * com.movingcq.service.IMapBasicInfoService#updateByCarId(java.util.Map)
	 */

	@Override
	public int updateByCarId(Map<String, String> qMap) {
		// TODO Auto-generated method stub
		return mapMapper.updateByCarId(qMap);
	}

	/*
	 * Title: updateStart Description:
	 * 
	 * @param qMap
	 * 
	 * @return
	 * 
	 * @see com.movingcq.service.IMapBasicInfoService#updateStart(java.util.Map)
	 */

	@Override
	public int updateStart(Map<String, String> qMap) {
		// TODO Auto-generated method stub
		return mapMapper.updateStart(qMap);
	}

}
