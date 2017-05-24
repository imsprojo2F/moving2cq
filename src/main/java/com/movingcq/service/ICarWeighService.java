/**   
* @Title: ICarWeighService.java 
* @Package com.movingcq.service 
* @Description: TODO(用一句话描述该文件做什么) 
* @author Imsprojo2FAN
* @date 2017年4月11日 上午10:49:46 
* @version V1.0   
*/
package com.movingcq.service;

import com.movingcq.entity.CarWeigh;

/**
 * @ClassName: ICarWeighService
 * @Description: TODO(这里用一句话描述这个类的作用)
 * @author Imsprojo2FAN
 * @date 2017年4月11日 上午10:49:46
 * 
 */
public interface ICarWeighService {
	int deleteByPrimaryKey(String id);

	int insert(CarWeigh record);

	int insertSelective(CarWeigh record);

	CarWeigh selectByPrimaryKey(String id);

	int updateByPrimaryKeySelective(CarWeigh record);

	int updateByPrimaryKeyWithBLOBs(CarWeigh record);

	int updateByPrimaryKey(CarWeigh record);

}
