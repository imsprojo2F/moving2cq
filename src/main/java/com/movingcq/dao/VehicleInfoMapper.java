/**   
* @Title: VehicleInfoMapper.java 
* @Package com.movingcq.dao 
* @Description: TODO(用一句话描述该文件做什么) 
* @author IsProjo
* @date 2016年12月21日 上午10:17:45 
* @version V1.0   
*/
package com.movingcq.dao;

import java.util.List;

import com.movingcq.entity.QueryParameters;
import com.movingcq.entity.VehicleInfo;

/**
 * @ClassName: VehicleInfoMapper
 * @Description: TODO(这里用一句话描述这个类的作用)
 * @author IsProjo
 * @date 2016年12月21日 上午10:17:45
 * 
 */
public interface VehicleInfoMapper {

	List<VehicleInfo> listAllVehicle(QueryParameters qParameters);

	List<VehicleInfo> selectByPage(QueryParameters qParameters);

	/**
	 * @param vehicleInfo
	 * @return
	 */
	int addVehicle(VehicleInfo vehicleInfo);

	/**
	 * @param ids
	 * @return
	 */
	int deleteById(String[] ids);

	/**
	 * @param VehicleInfo
	 * @return
	 */
	int updateById(VehicleInfo vehicleInfo);

}
