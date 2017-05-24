/**   
* @Title: DailyReportServiceImpl.java 
* @Package com.movingcq.service.impl 
* @Description: TODO(用一句话描述该文件做什么) 
* @author Imsprojo2FAN
* @date 2017年5月17日 下午1:14:07 
* @version V1.0   
*/
package com.movingcq.service.impl;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.movingcq.dao.DailyReportMapper;
import com.movingcq.entity.DailyReport;
import com.movingcq.service.IDailyReportService;

/**
 * @ClassName: DailyReportServiceImpl
 * @Description: TODO(这里用一句话描述这个类的作用)
 * @author Imsprojo2FAN
 * @date 2017年5月17日 下午1:14:07
 * 
 */
@Service("dailyReportService")
public class DailyReportServiceImpl implements IDailyReportService {

	@Autowired
	private DailyReportMapper dailyMapper;

	/*
	 * Title: deleteByPrimaryKey Description:
	 * 
	 * @param id
	 * 
	 * @return
	 * 
	 * @see
	 * com.movingcq.service.IDailyReportService#deleteByPrimaryKey(java.lang.
	 * Integer)
	 */

	@Override
	public int deleteByPrimaryKey(Integer id) {
		// TODO Auto-generated method stub
		return dailyMapper.deleteByPrimaryKey(id);
	}

	/*
	 * Title: insert Description:
	 * 
	 * @param record
	 * 
	 * @return
	 * 
	 * @see com.movingcq.service.IDailyReportService#insert(com.movingcq.entity.
	 * DailyReport)
	 */

	@Override
	public int insert(DailyReport record) {
		// TODO Auto-generated method stub
		return dailyMapper.insert(record);
	}

	/*
	 * Title: insertSelective Description:
	 * 
	 * @param record
	 * 
	 * @return
	 * 
	 * @see
	 * com.movingcq.service.IDailyReportService#insertSelective(com.movingcq.
	 * entity.DailyReport)
	 */

	@Override
	public int insertSelective(DailyReport record) {
		// TODO Auto-generated method stub
		return dailyMapper.insertSelective(record);
	}

	/*
	 * Title: selectByPrimaryKey Description:
	 * 
	 * @param id
	 * 
	 * @return
	 * 
	 * @see
	 * com.movingcq.service.IDailyReportService#selectByPrimaryKey(java.lang.
	 * Integer)
	 */

	@Override
	public DailyReport selectByPrimaryKey(Integer id) {
		// TODO Auto-generated method stub
		return dailyMapper.selectByPrimaryKey(id);
	}

	/*
	 * Title: updateByPrimaryKeySelective Description:
	 * 
	 * @param record
	 * 
	 * @return
	 * 
	 * @see
	 * com.movingcq.service.IDailyReportService#updateByPrimaryKeySelective(com.
	 * movingcq.entity.DailyReport)
	 */

	@Override
	public int updateByPrimaryKeySelective(DailyReport record) {
		// TODO Auto-generated method stub
		return dailyMapper.updateByPrimaryKeySelective(record);
	}

	/*
	 * Title: updateByPrimaryKey Description:
	 * 
	 * @param record
	 * 
	 * @return
	 * 
	 * @see
	 * com.movingcq.service.IDailyReportService#updateByPrimaryKey(com.movingcq.
	 * entity.DailyReport)
	 */

	@Override
	public int updateByPrimaryKey(DailyReport record) {
		// TODO Auto-generated method stub
		return dailyMapper.updateByPrimaryKey(record);
	}

}
