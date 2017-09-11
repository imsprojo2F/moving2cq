/**   
* @Title: CarWeighServiceImpl.java 
* @Package com.movingcq.service.impl 
* @Description: TODO(用一句话描述该文件做什么) 
* @author Imsprojo2FAN
* @date 2017年4月11日 上午10:50:37 
* @version V1.0   
*/
package com.movingcq.service.impl;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.movingcq.dao.CarWeighMapper;
import com.movingcq.entity.CarWeigh;
import com.movingcq.service.ICarWeighService;

/**
 * @ClassName: CarWeighServiceImpl
 * @Description: TODO(这里用一句话描述这个类的作用)
 * @author Imsprojo2FAN
 * @date 2017年4月11日 上午10:50:37
 * 
 */
@Service("carWeighService")
public class CarWeighServiceImpl implements ICarWeighService {

	@Autowired
	private CarWeighMapper carWeighMapper;

	/*
	 * Title: deleteByPrimaryKey Description:
	 * 
	 * @param id
	 * 
	 * @return
	 * 
	 * @see com.movingcq.service.ICarWeighService#deleteByPrimaryKey(java.lang.
	 * String)
	 */

	@Override
	public int deleteByPrimaryKey(String id) {
		// TODO Auto-generated method stub
		return carWeighMapper.deleteByPrimaryKey(id);
	}

	/*
	 * Title: insert Description:
	 * 
	 * @param record
	 * 
	 * @return
	 * 
	 * @see com.movingcq.service.ICarWeighService#insert(com.movingcq.entity.
	 * CarWeigh)
	 */

	@Override
	public int insert(CarWeigh record) {
		// TODO Auto-generated method stub
		return carWeighMapper.insert(record);
	}

	/*
	 * Title: insertSelective Description:
	 * 
	 * @param record
	 * 
	 * @return
	 * 
	 * @see
	 * com.movingcq.service.ICarWeighService#insertSelective(com.movingcq.entity
	 * .CarWeigh)
	 */

	@Override
	public int insertSelective(CarWeigh record) {
		// TODO Auto-generated method stub
		return carWeighMapper.insertSelective(record);
	}

	/*
	 * Title: selectByPrimaryKey Description:
	 * 
	 * @param id
	 * 
	 * @return
	 * 
	 * @see com.movingcq.service.ICarWeighService#selectByPrimaryKey(java.lang.
	 * String)
	 */

	@Override
	public CarWeigh selectByPrimaryKey(String id) {
		// TODO Auto-generated method stub
		return carWeighMapper.selectByPrimaryKey(id);
	}

	/*
	 * Title: updateByPrimaryKeySelective Description:
	 * 
	 * @param record
	 * 
	 * @return
	 * 
	 * @see
	 * com.movingcq.service.ICarWeighService#updateByPrimaryKeySelective(com.
	 * movingcq.entity.CarWeigh)
	 */

	@Override
	public int updateByPrimaryKeySelective(CarWeigh record) {
		// TODO Auto-generated method stub
		return carWeighMapper.updateByPrimaryKeySelective(record);
	}

	/*
	 * Title: updateByPrimaryKeyWithBLOBs Description:
	 * 
	 * @param record
	 * 
	 * @return
	 * 
	 * @see
	 * com.movingcq.service.ICarWeighService#updateByPrimaryKeyWithBLOBs(com.
	 * movingcq.entity.CarWeigh)
	 */

	@Override
	public int updateByPrimaryKeyWithBLOBs(CarWeigh record) {
		// TODO Auto-generated method stub
		return carWeighMapper.updateByPrimaryKeyWithBLOBs(record);
	}

	/*
	 * Title: updateByPrimaryKey Description:
	 * 
	 * @param record
	 * 
	 * @return
	 * 
	 * @see
	 * com.movingcq.service.ICarWeighService#updateByPrimaryKey(com.movingcq.
	 * entity.CarWeigh)
	 */

	@Override
	public int updateByPrimaryKey(CarWeigh record) {
		// TODO Auto-generated method stub
		return carWeighMapper.updateByPrimaryKey(record);
	}

}
