/**   
* @Title: ParameterRecordService.java 
* @Package com.movingcq.service.impl 
* @Description: TODO(用一句话描述该文件做什么) 
* @author Imsprojo2FAN
* @date 2017年4月11日 上午11:07:27 
* @version V1.0   
*/
package com.movingcq.service.impl;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.movingcq.dao.ParameterRecordMapper;
import com.movingcq.entity.ParameterRecord;
import com.movingcq.service.IParameterRecordService;

/**
 * @ClassName: ParameterRecordService
 * @Description: TODO(这里用一句话描述这个类的作用)
 * @author Imsprojo2FAN
 * @date 2017年4月11日 上午11:07:27
 * 
 */
@Service("parameterRecordService")
public class ParameterRecordService implements IParameterRecordService {
	@Autowired
	private ParameterRecordMapper parameterRecordMapper;

	/*
	 * Title: deleteByPrimaryKey Description:
	 * 
	 * @param id
	 * 
	 * @return
	 * 
	 * @see
	 * com.movingcq.service.IParameterRecordService#deleteByPrimaryKey(java.lang
	 * .String)
	 */

	@Override
	public int deleteByPrimaryKey(String id) {
		// TODO Auto-generated method stub
		return parameterRecordMapper.deleteByPrimaryKey(id);
	}

	/*
	 * Title: insert Description:
	 * 
	 * @param record
	 * 
	 * @return
	 * 
	 * @see
	 * com.movingcq.service.IParameterRecordService#insert(com.movingcq.entity.
	 * ParameterRecord)
	 */

	@Override
	public int insert(ParameterRecord record) {
		// TODO Auto-generated method stub
		return parameterRecordMapper.insert(record);
	}

	/*
	 * Title: insertSelective Description:
	 * 
	 * @param record
	 * 
	 * @return
	 * 
	 * @see
	 * com.movingcq.service.IParameterRecordService#insertSelective(com.movingcq
	 * .entity.ParameterRecord)
	 */

	@Override
	public int insertSelective(ParameterRecord record) {
		// TODO Auto-generated method stub
		return parameterRecordMapper.insertSelective(record);
	}

	/*
	 * Title: selectByPrimaryKey Description:
	 * 
	 * @param id
	 * 
	 * @return
	 * 
	 * @see
	 * com.movingcq.service.IParameterRecordService#selectByPrimaryKey(java.lang
	 * .String)
	 */

	@Override
	public ParameterRecord selectByPrimaryKey(String id) {
		// TODO Auto-generated method stub
		return parameterRecordMapper.selectByPrimaryKey(id);
	}

	/*
	 * Title: updateByPrimaryKeySelective Description:
	 * 
	 * @param record
	 * 
	 * @return
	 * 
	 * @see
	 * com.movingcq.service.IParameterRecordService#updateByPrimaryKeySelective(
	 * com.movingcq.entity.ParameterRecord)
	 */

	@Override
	public int updateByPrimaryKeySelective(ParameterRecord record) {
		// TODO Auto-generated method stub
		return parameterRecordMapper.updateByPrimaryKeySelective(record);
	}

	/*
	 * Title: updateByPrimaryKey Description:
	 * 
	 * @param record
	 * 
	 * @return
	 * 
	 * @see com.movingcq.service.IParameterRecordService#updateByPrimaryKey(com.
	 * movingcq.entity.ParameterRecord)
	 */

	@Override
	public int updateByPrimaryKey(ParameterRecord record) {
		// TODO Auto-generated method stub
		return parameterRecordMapper.updateByPrimaryKey(record);
	}

}
