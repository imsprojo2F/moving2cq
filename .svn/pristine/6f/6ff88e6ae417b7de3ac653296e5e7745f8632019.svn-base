/**   
* @Title: LoadoMeterRecordService.java 
* @Package com.movingcq.service.impl 
* @Description: TODO(用一句话描述该文件做什么) 
* @author Imsprojo2FAN
* @date 2017年4月11日 上午11:02:35 
* @version V1.0   
*/
package com.movingcq.service.impl;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.movingcq.dao.LoadoMasterRecordMapper;
import com.movingcq.entity.LoadoMasterRecord;
import com.movingcq.service.ILoadoMeterRecordService;

/**
 * @ClassName: LoadoMeterRecordService
 * @Description: TODO(这里用一句话描述这个类的作用)
 * @author Imsprojo2FAN
 * @date 2017年4月11日 上午11:02:35
 * 
 */
@Service("loadoMeterRecordService")
public class LoadoMeterRecordService implements ILoadoMeterRecordService {

	@Autowired
	private LoadoMasterRecordMapper loadoMasterRecordMapper;

	/*
	 * Title: deleteByPrimaryKey Description:
	 * 
	 * @param id
	 * 
	 * @return
	 * 
	 * @see
	 * com.movingcq.service.ILoadoMeterRecordService#deleteByPrimaryKey(java.
	 * lang.String)
	 */

	@Override
	public int deleteByPrimaryKey(String id) {
		// TODO Auto-generated method stub
		return loadoMasterRecordMapper.deleteByPrimaryKey(id);
	}

	/*
	 * Title: insert Description:
	 * 
	 * @param record
	 * 
	 * @return
	 * 
	 * @see
	 * com.movingcq.service.ILoadoMeterRecordService#insert(com.movingcq.entity.
	 * LoadoMasterRecord)
	 */

	@Override
	public int insert(LoadoMasterRecord record) {
		// TODO Auto-generated method stub
		return loadoMasterRecordMapper.insert(record);
	}

	/*
	 * Title: insertSelective Description:
	 * 
	 * @param record
	 * 
	 * @return
	 * 
	 * @see com.movingcq.service.ILoadoMeterRecordService#insertSelective(com.
	 * movingcq.entity.LoadoMasterRecord)
	 */

	@Override
	public int insertSelective(LoadoMasterRecord record) {
		// TODO Auto-generated method stub
		return loadoMasterRecordMapper.insertSelective(record);
	}

	/*
	 * Title: selectByPrimaryKey Description:
	 * 
	 * @param id
	 * 
	 * @return
	 * 
	 * @see
	 * com.movingcq.service.ILoadoMeterRecordService#selectByPrimaryKey(java.
	 * lang.String)
	 */

	@Override
	public LoadoMasterRecord selectByPrimaryKey(String id) {
		// TODO Auto-generated method stub
		return loadoMasterRecordMapper.selectByPrimaryKey(id);
	}

	/*
	 * Title: updateByPrimaryKeySelective Description:
	 * 
	 * @param record
	 * 
	 * @return
	 * 
	 * @see
	 * com.movingcq.service.ILoadoMeterRecordService#updateByPrimaryKeySelective
	 * (com.movingcq.entity.LoadoMasterRecord)
	 */

	@Override
	public int updateByPrimaryKeySelective(LoadoMasterRecord record) {
		// TODO Auto-generated method stub
		return loadoMasterRecordMapper.updateByPrimaryKeySelective(record);
	}

	/*
	 * Title: updateByPrimaryKey Description:
	 * 
	 * @param record
	 * 
	 * @return
	 * 
	 * @see
	 * com.movingcq.service.ILoadoMeterRecordService#updateByPrimaryKey(com.
	 * movingcq.entity.LoadoMasterRecord)
	 */

	@Override
	public int updateByPrimaryKey(LoadoMasterRecord record) {
		// TODO Auto-generated method stub
		return loadoMasterRecordMapper.updateByPrimaryKey(record);
	}

}
