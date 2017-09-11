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
import java.util.Map;

import com.movingcq.entity.RestaurantBucketInfo;

/**
 * @ClassName: VehicleInfoMapper
 * @Description: TODO(这里用一句话描述这个类的作用)
 * @author IsProjo
 * @date 2016年12月21日 上午10:17:45
 * 
 */
public interface Rest2BucketMapper {

	@SuppressWarnings("rawtypes")
	List<Map> listAllBinding(String id);

	List<RestaurantBucketInfo> getAllBindIdByRestid(Map<String, String> map);

	int getBindByRestId(Map<String, String> map);

	/**
	 * @param vehicleInfo
	 * @return
	 */
	int addBinding(RestaurantBucketInfo restaurantBucketInfo);

	/**
	 * @param id
	 * @return
	 */
	int deleteById(String id, String id2);

}
