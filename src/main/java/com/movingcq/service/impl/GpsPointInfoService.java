/**   
* @Title: GpsPointInfoService.java 
* @Package com.movingcq.service.impl 
* @Description: TODO(用一句话描述该文件做什么) 
* @author Imsprojo2FAN
* @date 2017年4月11日 上午10:56:26 
* @version V1.0   
*/
package com.movingcq.service.impl;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.movingcq.dao.GpsPointInfoMapper;
import com.movingcq.entity.GpsPointInfo;
import com.movingcq.service.IGpsPointInfoService;

/**
 * @ClassName: GpsPointInfoService
 * @Description: TODO(这里用一句话描述这个类的作用)
 * @author Imsprojo2FAN
 * @date 2017年4月11日 上午10:56:26
 * 
 */
@Service("gpsPointInfoService")
public class GpsPointInfoService implements IGpsPointInfoService {

	@Autowired
	private GpsPointInfoMapper gpsPointInfoMapper;

	/*
	 * Title: deleteByPrimaryKey Description:
	 * 
	 * @param id
	 * 
	 * @return
	 * 
	 * @see
	 * com.movingcq.service.IGpsPointInfoService#deleteByPrimaryKey(java.lang.
	 * Integer)
	 */

	@Override
	public int deleteByPrimaryKey(Integer id) {
		// TODO Auto-generated method stub
		return gpsPointInfoMapper.deleteByPrimaryKey(id);
	}

	/*
	 * Title: insert Description:
	 * 
	 * @param record
	 * 
	 * @return
	 * 
	 * @see
	 * com.movingcq.service.IGpsPointInfoService#insert(com.movingcq.entity.
	 * GpsPointInfo)
	 */

	@Override
	public int insert(GpsPointInfo record) {
		// TODO Auto-generated method stub
		return gpsPointInfoMapper.insert(record);
	}

	/*
	 * Title: insertSelective Description:
	 * 
	 * @param record
	 * 
	 * @return
	 * 
	 * @see
	 * com.movingcq.service.IGpsPointInfoService#insertSelective(com.movingcq.
	 * entity.GpsPointInfo)
	 */

	@Override
	public int insertSelective(GpsPointInfo record) {
		// TODO Auto-generated method stub
		return gpsPointInfoMapper.insertSelective(record);
	}

	/*
	 * Title: selectByPrimaryKey Description:
	 * 
	 * @param id
	 * 
	 * @return
	 * 
	 * @see
	 * com.movingcq.service.IGpsPointInfoService#selectByPrimaryKey(java.lang.
	 * Integer)
	 */

	@Override
	public GpsPointInfo selectByPrimaryKey(Integer id) {
		// TODO Auto-generated method stub
		return gpsPointInfoMapper.selectByPrimaryKey(id);
	}

	/*
	 * Title: updateByPrimaryKeySelective Description:
	 * 
	 * @param record
	 * 
	 * @return
	 * 
	 * @see
	 * com.movingcq.service.IGpsPointInfoService#updateByPrimaryKeySelective(com
	 * .movingcq.entity.GpsPointInfo)
	 */

	@Override
	public int updateByPrimaryKeySelective(GpsPointInfo record) {
		// TODO Auto-generated method stub
		return gpsPointInfoMapper.updateByPrimaryKeySelective(record);
	}

	/*
	 * Title: updateByPrimaryKey Description:
	 * 
	 * @param record
	 * 
	 * @return
	 * 
	 * @see
	 * com.movingcq.service.IGpsPointInfoService#updateByPrimaryKey(com.movingcq
	 * .entity.GpsPointInfo)
	 */

	@Override
	public int updateByPrimaryKey(GpsPointInfo record) {
		// TODO Auto-generated method stub
		return gpsPointInfoMapper.updateByPrimaryKey(record);
	}

}
