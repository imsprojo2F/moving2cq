/**   
* @Title: IDailyReportService.java 
* @Package com.movingcq.service 
* @Description: TODO(用一句话描述该文件做什么) 
* @author Imsprojo2FAN
* @date 2017年5月17日 上午11:28:10 
* @version V1.0   
*/
package com.movingcq.service;

import com.movingcq.entity.DailyReport;

/**
 * @ClassName: IDailyReportService
 * @Description: TODO(这里用一句话描述这个类的作用)
 * @author Imsprojo2FAN
 * @date 2017年5月17日 上午11:28:10
 * 
 */
public interface IDailyReportService {

	int deleteByPrimaryKey(Integer id);

	int insert(DailyReport record);

	int insertSelective(DailyReport record);

	DailyReport selectByPrimaryKey(Integer id);

	int updateByPrimaryKeySelective(DailyReport record);

	int updateByPrimaryKey(DailyReport record);

}
