/**   
* @Title: CarDeviceImpl.java 
* @Package com.movingcq.service.impl 
* @Description: TODO(用一句话描述该文件做什么) 
* @author Imsprojo2FAN
* @date 2017年4月11日 上午10:35:24 
* @version V1.0   
*/
package com.movingcq.service.impl;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.movingcq.dao.CarDeviceMapper;
import com.movingcq.entity.CarDevice;
import com.movingcq.service.ICarDeviceService;

/**
 * @ClassName: CarDeviceImpl
 * @Description: TODO(这里用一句话描述这个类的作用)
 * @author Imsprojo2FAN
 * @date 2017年4月11日 上午10:35:24
 * 
 */
@Service("carDeviceService")
public class CarDeviceServiceImpl implements ICarDeviceService {

	@Autowired
	private CarDeviceMapper carDeviceMapper;

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
		return carDeviceMapper.deleteByPrimaryKey(id);
	}

	/*
	 * Title: insert Description:
	 * 
	 * @param record
	 * 
	 * @return
	 * 
	 * @see com.movingcq.service.ICarDeviceService#insert(com.movingcq.entity.
	 * CarDevice)
	 */

	@Override
	public int insert(CarDevice record) {
		// TODO Auto-generated method stub
		return carDeviceMapper.insert(record);
	}

	/*
	 * Title: insertSelective Description:
	 * 
	 * @param record
	 * 
	 * @return
	 * 
	 * @see com.movingcq.service.ICarDeviceService#insertSelective(com.movingcq.
	 * entity.CarDevice)
	 */

	@Override
	public int insertSelective(CarDevice record) {
		// TODO Auto-generated method stub
		return carDeviceMapper.insertSelective(record);
	}

	/*
	 * Title: selectByPrimaryKey Description:
	 * 
	 * @param id
	 * 
	 * @return
	 * 
	 * @see com.movingcq.service.ICarDeviceService#selectByPrimaryKey(java.lang.
	 * String)
	 */

	@Override
	public CarDevice selectByPrimaryKey(String id) {
		// TODO Auto-generated method stub
		return carDeviceMapper.selectByPrimaryKey(id);
	}

	/*
	 * Title: updateByPrimaryKeySelective Description:
	 * 
	 * @param record
	 * 
	 * @return
	 * 
	 * @see
	 * com.movingcq.service.ICarDeviceService#updateByPrimaryKeySelective(com.
	 * movingcq.entity.CarDevice)
	 */

	@Override
	public int updateByPrimaryKeySelective(CarDevice record) {
		// TODO Auto-generated method stub
		return carDeviceMapper.updateByPrimaryKeySelective(record);
	}

	/*
	 * Title: updateByPrimaryKey Description:
	 * 
	 * @param record
	 * 
	 * @return
	 * 
	 * @see
	 * com.movingcq.service.ICarDeviceService#updateByPrimaryKey(com.movingcq.
	 * entity.CarDevice)
	 */

	@Override
	public int updateByPrimaryKey(CarDevice record) {
		// TODO Auto-generated method stub
		return carDeviceMapper.updateByPrimaryKey(record);
	}

}
