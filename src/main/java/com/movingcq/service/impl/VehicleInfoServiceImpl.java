/**   
* @Title: VehicleInfoServiceImpl.java 
* @Package com.movingcq.service.impl 
* @Description: TODO(用一句话描述该文件做什么) 
* @author IsProjo
* @date 2016年12月21日 上午10:23:08 
* @version V1.0   
*/
package com.movingcq.service.impl;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.movingcq.dao.VehicleInfoMapper;
import com.movingcq.entity.QueryParameters;
import com.movingcq.entity.VehicleInfo;
import com.movingcq.service.IVehicleInfoService;

/**
 * @ClassName: VehicleInfoServiceImpl
 * @Description: TODO(这里用一句话描述这个类的作用)
 * @author IsProjo
 * @date 2016年12月21日 上午10:23:08
 * 
 */
@Service("vehicleService")
public class VehicleInfoServiceImpl implements IVehicleInfoService {

	@Autowired
	private VehicleInfoMapper vehicleInfoMapper;

	/*
	 * Title: addVehicleInfo Description:
	 * 
	 * @param vehicleInfo
	 * 
	 * @return
	 * 
	 * @see
	 * com.movingcq.service.IVehicleInfoService#addVehicleInfo(com.movingcq.
	 * entity .VehicleInfo)
	 */

	@Override
	public int addVehicleInfo(VehicleInfo vehicleInfo) {
		// TODO Auto-generated method stub
		return vehicleInfoMapper.addVehicle(vehicleInfo);
	}

	/*
	 * Title: deleteById Description:
	 * 
	 * @param ids
	 * 
	 * @return
	 * 
	 * @see
	 * com.movingcq.service.IVehicleInfoService#deleteById(java.lang.String[])
	 */

	@Override
	public int deleteById(String[] ids) {
		// TODO Auto-generated method stub
		return vehicleInfoMapper.deleteById(ids);
	}

	/*
	 * Title: updateById Description:
	 * 
	 * @param vehicleInfo
	 * 
	 * @return
	 * 
	 * @see
	 * com.movingcq.service.IVehicleInfoService#updateById(com.movingcq.entity.
	 * VehicleInfo)
	 */

	@Override
	public int updateById(VehicleInfo vehicleInfo) {
		// TODO Auto-generated method stub
		return vehicleInfoMapper.updateById(vehicleInfo);
	}

	/*
	 * Title: listAllVehicleInfo Description:
	 * 
	 * @param qParameters
	 * 
	 * @return
	 * 
	 * @see
	 * com.movingcq.service.IVehicleInfoService#listAllVehicleInfo(com.movingcq.
	 * entity.QueryParameters)
	 */

	@Override
	public List<VehicleInfo> listAllVehicleInfo(QueryParameters qParameters) {
		// TODO Auto-generated method stub
		return vehicleInfoMapper.listAllVehicle(qParameters);
	}

	/*
	 * Title: selectByPage Description:
	 * 
	 * @param qParameters
	 * 
	 * @return
	 * 
	 * @see com.movingcq.service.IVehicleInfoService#selectByPage(com.movingcq.
	 * entity. QueryParameters)
	 */

	@Override
	public List<VehicleInfo> selectByPage(QueryParameters qParameters) {
		// TODO Auto-generated method stub
		return vehicleInfoMapper.selectByPage(qParameters);
	}

}
