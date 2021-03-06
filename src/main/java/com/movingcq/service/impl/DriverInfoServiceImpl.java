/**   
* @Title: DriverInfoServiceImpl.java 
* @Package com.movingcq.service.impl 
* @Description: TODO(用一句话描述该文件做什么) 
* @author IsProjo
* @date 2016年12月21日 上午10:23:08 
* @version V1.0   
*/
package com.movingcq.service.impl;

import java.util.List;
import java.util.Map;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.movingcq.dao.DriverInfoMapper;
import com.movingcq.entity.DriverInfo;
import com.movingcq.service.IDriverInfoService;

/**
 * @ClassName: DriverInfoServiceImpl
 * @Description: TODO(这里用一句话描述这个类的作用)
 * @author IsProjo
 * @date 2016年12月21日 上午10:23:08
 * 
 */
@Service("driverService")
public class DriverInfoServiceImpl implements IDriverInfoService {

	@Autowired
	private DriverInfoMapper driverInfoMapper;

	/*
	 * Title: addDriverInfo Description:
	 * 
	 * @param driverInfo
	 * 
	 * @return
	 * 
	 * @see
	 * com.movingcq.service.IDriverInfoService#addDriverInfo(com.movingcq.entity
	 * .DriverInfo)
	 */

	@Override
	public int addDriverInfo(DriverInfo driverInfo) {
		// TODO Auto-generated method stub
		return driverInfoMapper.addDriver(driverInfo);
	}

	@Override
	public int insertByCode(String pic, String fileName, String filePath) {
		// TODO Auto-generated method stub
		return driverInfoMapper.insertByCode(pic, fileName, filePath);
	}

	/*
	 * Title: deleteById Description:
	 * 
	 * @param ids
	 * 
	 * @return
	 * 
	 * @see
	 * com.movingcq.service.IDriverInfoService#deleteById(java.lang.String[])
	 */

	@Override
	public int deleteById(String[] ids) {
		// TODO Auto-generated method stub
		return driverInfoMapper.deleteById(ids);
	}

	/*
	 * Title: updateById Description:
	 * 
	 * @param driverInfo
	 * 
	 * @return
	 * 
	 * @see
	 * com.movingcq.service.IDriverInfoService#updateById(com.movingcq.entity.
	 * DriverInfo)
	 */

	@Override
	public int updateById(DriverInfo driverInfo) {
		// TODO Auto-generated method stub
		return driverInfoMapper.updateById(driverInfo);
	}

	/*
	 * Title: listAllDriverInfo Description:
	 * 
	 * @param qParameters
	 * 
	 * @return
	 * 
	 * @see
	 * com.movingcq.service.IDriverInfoService#listAllDriverInfo(com.movingcq.
	 * entity.QueryParameters)
	 */

	@Override
	public List<DriverInfo> listAllDriverInfo(Map<String, Object> qMap) {
		// TODO Auto-generated method stub
		return driverInfoMapper.listAllDriver(qMap);
	}

	/*
	 * Title: selectByPage Description:
	 * 
	 * @param qParameters
	 * 
	 * @return
	 * 
	 * @see
	 * com.movingcq.service.IDriverInfoService#selectByPage(com.movingcq.entity.
	 * QueryParameters)
	 */

	@Override
	public List<Map<String, String>> selectByPage(Map<String, Object> qMap) {
		// TODO Auto-generated method stub
		return driverInfoMapper.selectByPage(qMap);
	}

	/*
	 * Title: updateByPhoto Description:
	 * 
	 * @param driverInfo
	 * 
	 * @return
	 * 
	 * @see
	 * com.movingcq.service.IDriverInfoService#updateByPhoto(com.movingcq.entity
	 * .DriverInfo)
	 */

	@Override
	public int updateByCode(DriverInfo driverInfo) {
		// TODO Auto-generated method stub
		return driverInfoMapper.updateByCode(driverInfo);
	}

	/*
	 * Title: updateFilePath Description:
	 * 
	 * @param uid
	 * 
	 * @param file
	 * 
	 * @param src
	 * 
	 * @return
	 * 
	 * @see
	 * com.movingcq.service.IDriverInfoService#updateFilePath(java.lang.String,
	 * java.lang.String, java.lang.String)
	 */

	@Override
	public int updateFilePath(String uid, String file, String src) {
		// TODO Auto-generated method stub
		return driverInfoMapper.updateFilePath(uid, file, src);
	}

}
