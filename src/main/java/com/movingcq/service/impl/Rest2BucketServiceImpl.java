/**   
* @Title: Rest2BucketServiceImpl.java 
* @Package com.movingcq.service.impl 
* @Description: TODO(用一句话描述该文件做什么) 
* @author IsProjo
* @date 2016年12月22日 下午4:46:49 
* @version V1.0   
*/
package com.movingcq.service.impl;

import java.util.List;
import java.util.Map;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.movingcq.dao.Rest2BucketMapper;
import com.movingcq.entity.RestaurantBucketInfo;
import com.movingcq.service.IRest2BucketService;

/**
 * @ClassName: Rest2BucketServiceImpl
 * @Description: TODO(这里用一句话描述这个类的作用)
 * @author IsProjo
 * @date 2016年12月22日 下午4:46:49
 * 
 */
@Service("rest2bucketService")
public class Rest2BucketServiceImpl implements IRest2BucketService {

	@Autowired
	private Rest2BucketMapper rest2BucketMapper;
	/*
	 * Title: addBinding Description:
	 * 
	 * @param vehicleInfo
	 * 
	 * @return
	 * 
	 * @see
	 * com.movingcq.service.IRest2BucketService#addBinding(com.movingcq.entity.
	 * RestaurantBucketInfo)
	 */

	@Override
	public int addBinding(RestaurantBucketInfo restaurantBucketInfo) {
		// TODO Auto-generated method stub
		return rest2BucketMapper.addBinding(restaurantBucketInfo);
	}

	/*
	 * Title: deleteById Description:
	 * 
	 * @param id
	 * 
	 * @return
	 * 
	 * @see
	 * com.movingcq.service.IRest2BucketService#deleteById(java.lang.String)
	 */

	@Override
	public int deleteById(String id1, String id2) {
		// TODO Auto-generated method stub
		return rest2BucketMapper.deleteById(id1, id2);
	}

	/*
	 * Title: listAllBinding Description:
	 * 
	 * @return
	 * 
	 * @see com.movingcq.service.IRest2BucketService#listAllBinding()
	 */

	@SuppressWarnings("rawtypes")
	@Override
	public List<Map> listAllBinding(String id) {
		// TODO Auto-generated method stub
		return rest2BucketMapper.listAllBinding(id);
	}

	/*
	 * Title: getBindByRestId Description:
	 * 
	 * @param map
	 * 
	 * @return
	 * 
	 * @see
	 * com.movingcq.service.IRest2BucketService#getBindByRestId(java.util.Map)
	 */

	@Override
	public int getBindByRestId(Map<String, String> map) {
		// TODO Auto-generated method stub
		return rest2BucketMapper.getBindByRestId(map);
	}

	/*
	 * Title: getAllBindIdByRestid Description:
	 * 
	 * @param map
	 * 
	 * @return
	 * 
	 * @see
	 * com.movingcq.service.IRest2BucketService#getAllBindIdByRestid(java.util.
	 * Map)
	 */

	@Override
	public List<RestaurantBucketInfo> getAllBindIdByRestid(Map<String, String> map) {
		// TODO Auto-generated method stub
		return rest2BucketMapper.getAllBindIdByRestid(map);
	}

	/*
	 * Title: getBindByRestId Description:
	 * 
	 * @param map
	 * 
	 * @return
	 * 
	 * @see
	 * com.movingcq.service.IRest2BucketService#getBindByRestId(java.util.Map)
	 */

}
