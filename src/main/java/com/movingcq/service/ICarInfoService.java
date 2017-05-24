/**   
* @Title: CarInfoService.java 
* @Package com.movingcq.service 
* @Description: TODO(用一句话描述该文件做什么) 
* @author Imsprojo2FAN
* @date 2017年4月11日 上午10:43:15 
* @version V1.0   
*/
package com.movingcq.service;

import java.util.List;
import java.util.Map;

import com.movingcq.entity.CarInfo;

/**
 * @ClassName: CarInfoService
 * @Description: TODO(这里用一句话描述这个类的作用)
 * @author Imsprojo2FAN
 * @date 2017年4月11日 上午10:43:15
 * 
 */
public interface ICarInfoService {

	int deleteByPrimaryKey(String id);

	int insert(CarInfo record);

	int insertSelective(CarInfo record);

	CarInfo selectByPrimaryKey(String id);

	int updateByPrimaryKeySelective(CarInfo record);

	int updateByPrimaryKey(CarInfo record);

	List<CarInfo> listAllCar(Map<String, Object> qMap);

	List<Map<String, Object>> selectByPage(Map<String, Object> qMap);

	List<CarInfo> selectByCarCode(Map<String, Object> qMap);

}
