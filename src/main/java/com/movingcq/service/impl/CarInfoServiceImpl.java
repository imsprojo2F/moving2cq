/**   
* @Title: CarInfoServiceImpl.java 
* @Package com.movingcq.service.impl 
* @Description: TODO(用一句话描述该文件做什么) 
* @author Imsprojo2FAN
* @date 2017年4月11日 上午10:44:37 
* @version V1.0   
*/
package com.movingcq.service.impl;

import java.util.List;
import java.util.Map;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.movingcq.dao.CarInfoMapper;
import com.movingcq.entity.CarInfo;
import com.movingcq.service.ICarInfoService;

/**
 * @ClassName: CarInfoServiceImpl
 * @Description: TODO(这里用一句话描述这个类的作用)
 * @author Imsprojo2FAN
 * @date 2017年4月11日 上午10:44:37
 * 
 */
@Service("carInfoService")
public class CarInfoServiceImpl implements ICarInfoService {

	@Autowired
	private CarInfoMapper carInfoMapper;

	/*
	 * Title: deleteByPrimaryKey Description:
	 * 
	 * @param id
	 * 
	 * @return
	 * 
	 * @see com.movingcq.service.ICarDeviceService#deleteByPrimaryKey(java.lang.
	 * String)
	 */

	@Override
	public int deleteByPrimaryKey(String id) {
		// TODO Auto-generated method stub
		return carInfoMapper.deleteByPrimaryKey(id);
	}

	/*
	 * Title: insert Description:
	 * 
	 * @param record
	 * 
	 * @return
	 * 
	 * @see
	 * com.movingcq.service.ICarInfoService#insert(com.movingcq.entity.CarInfo)
	 */

	@Override
	public int insert(CarInfo record) {
		// TODO Auto-generated method stub
		return carInfoMapper.insert(record);
	}

	/*
	 * Title: insertSelective Description:
	 * 
	 * @param record
	 * 
	 * @return
	 * 
	 * @see
	 * com.movingcq.service.ICarInfoService#insertSelective(com.movingcq.entity.
	 * CarInfo)
	 */

	@Override
	public int insertSelective(CarInfo record) {
		// TODO Auto-generated method stub
		return carInfoMapper.insertSelective(record);
	}

	/*
	 * Title: selectByPrimaryKey Description:
	 * 
	 * @param id
	 * 
	 * @return
	 * 
	 * @see
	 * com.movingcq.service.ICarInfoService#selectByPrimaryKey(java.lang.String)
	 */

	@Override
	public CarInfo selectByPrimaryKey(String id) {
		// TODO Auto-generated method stub
		return carInfoMapper.selectByPrimaryKey(id);
	}

	/*
	 * Title: updateByPrimaryKeySelective Description:
	 * 
	 * @param record
	 * 
	 * @return
	 * 
	 * @see
	 * com.movingcq.service.ICarInfoService#updateByPrimaryKeySelective(com.
	 * movingcq.entity.CarInfo)
	 */

	@Override
	public int updateByPrimaryKeySelective(CarInfo record) {
		// TODO Auto-generated method stub
		return carInfoMapper.updateByPrimaryKeySelective(record);
	}

	/*
	 * Title: updateByPrimaryKey Description:
	 * 
	 * @param record
	 * 
	 * @return
	 * 
	 * @see
	 * com.movingcq.service.ICarInfoService#updateByPrimaryKey(com.movingcq.
	 * entity.CarInfo)
	 */

	@Override
	public int updateByPrimaryKey(CarInfo record) {
		// TODO Auto-generated method stub
		return carInfoMapper.updateByPrimaryKey(record);
	}

	/*
	 * Title: listAllCar Description:
	 * 
	 * @param qMap
	 * 
	 * @return
	 * 
	 * @see com.movingcq.service.ICarInfoService#listAllCar(java.util.Map)
	 */

	@Override
	public List<CarInfo> listAllCar(Map<String, Object> qMap) {
		// TODO Auto-generated method stub
		return carInfoMapper.listAllCar(qMap);
	}

	/*
	 * Title: selectByPage Description:
	 * 
	 * @param qMap
	 * 
	 * @return
	 * 
	 * @see com.movingcq.service.ICarInfoService#selectByPage(java.util.Map)
	 */

	@Override
	public List<Map<String, Object>> selectByPage(Map<String, Object> qMap) {
		// TODO Auto-generated method stub
		return carInfoMapper.selectByPage(qMap);
	}

	/*
	 * Title: selectByCarCode Description:
	 * 
	 * @param qMap
	 * 
	 * @return
	 * 
	 * @see com.movingcq.service.ICarInfoService#selectByCarCode(java.util.Map)
	 */

	@Override
	public List<CarInfo> selectByCarCode(Map<String, Object> qMap) {
		// TODO Auto-generated method stub
		return carInfoMapper.selectByCarCode(qMap);
	}

}
