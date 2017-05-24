/**   
* @Title: IGpsPointInfoService.java 
* @Package com.movingcq.service 
* @Description: TODO(用一句话描述该文件做什么) 
* @author Imsprojo2FAN
* @date 2017年4月11日 上午10:55:50 
* @version V1.0   
*/
package com.movingcq.service;

import com.movingcq.entity.GpsPointInfo;

/**
 * @ClassName: IGpsPointInfoService
 * @Description: TODO(这里用一句话描述这个类的作用)
 * @author Imsprojo2FAN
 * @date 2017年4月11日 上午10:55:50
 * 
 */
public interface IGpsPointInfoService {
	int deleteByPrimaryKey(Integer id);

	int insert(GpsPointInfo record);

	int insertSelective(GpsPointInfo record);

	GpsPointInfo selectByPrimaryKey(Integer id);

	int updateByPrimaryKeySelective(GpsPointInfo record);

	int updateByPrimaryKey(GpsPointInfo record);

}
