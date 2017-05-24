/**   
* @Title: IParameterRecordService.java 
* @Package com.movingcq.service 
* @Description: TODO(用一句话描述该文件做什么) 
* @author Imsprojo2FAN
* @date 2017年4月11日 上午11:06:45 
* @version V1.0   
*/
package com.movingcq.service;

import com.movingcq.entity.ParameterRecord;

/**
 * @ClassName: IParameterRecordService
 * @Description: TODO(这里用一句话描述这个类的作用)
 * @author Imsprojo2FAN
 * @date 2017年4月11日 上午11:06:45
 * 
 */
public interface IParameterRecordService {
	int deleteByPrimaryKey(String id);

	int insert(ParameterRecord record);

	int insertSelective(ParameterRecord record);

	ParameterRecord selectByPrimaryKey(String id);

	int updateByPrimaryKeySelective(ParameterRecord record);

	int updateByPrimaryKey(ParameterRecord record);

}
