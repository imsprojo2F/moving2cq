/**   
* @Title: TrashDetailServiceImpl.java 
* @Package com.movingcq.service.impl 
* @Description: TODO(用一句话描述该文件做什么) 
* @author IsProjo
* @date 2016年12月26日 上午10:10:49 
* @version V1.0   
*/
package com.movingcq.service.impl;

import java.util.List;
import java.util.Map;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.movingcq.dao.TrashDetailMapper;
import com.movingcq.entity.TrashCollectionDetailInfo;
import com.movingcq.service.ITrashDetailService;

/**
 * @ClassName: TrashDetailServiceImpl
 * @Description: TODO(这里用一句话描述这个类的作用)
 * @author IsProjo
 * @date 2016年12月26日 上午10:10:49
 * 
 */
@Service("trashDetailService")
public class TrashDetailServiceImpl implements ITrashDetailService {

	@Autowired
	private TrashDetailMapper trashDetailMapper;

	/*
	 * Title: listAllTrash Description:
	 * 
	 * @param qParameters
	 * 
	 * @return
	 * 
	 * @see
	 * com.movingcq.service.ITrashDetailService#listAllTrash(com.movingcq.entity
	 * .QueryParameters)
	 */

	@Override
	public List<Map<Object, Object>> listAllTrash(Map<String, String> map) {
		// TODO Auto-generated method stub
		return trashDetailMapper.listAllTrash(map);
	}

	/*
	 * Title: selectByPage Description:
	 * 
	 * @param qParameters
	 * 
	 * @return
	 * 
	 * @see
	 * com.movingcq.service.ITrashDetailService#selectByPage(com.movingcq.entity
	 * .QueryParameters)
	 */

	@Override
	public List<Map<String, String>> selectByPage(Map<String, String> map) {
		// TODO Auto-generated method stub
		return trashDetailMapper.selectByPage(map);
	}

	/*
	 * Title: insertTrash Description:
	 * 
	 * @param tDetailInfo
	 * 
	 * @return
	 * 
	 * @see
	 * com.movingcq.service.ITrashDetailService#insertTrash(com.movingcq.entity.
	 * TrashCollectionDetailInfo)
	 */

	@Override
	public int insertTrash(TrashCollectionDetailInfo tDetailInfo) {
		// TODO Auto-generated method stub
		return trashDetailMapper.insertTrash(tDetailInfo);
	}

	/*
	 * Title: deleteById Description:
	 * 
	 * @param ids
	 * 
	 * @return
	 * 
	 * @see
	 * com.movingcq.service.ITrashDetailService#deleteById(java.lang.String)
	 */

	@Override
	public int deleteById(String[] ids) {
		// TODO Auto-generated method stub
		return trashDetailMapper.deleteById(ids);
	}

	/*
	 * Title: updateById Description:
	 * 
	 * @param tDetailInfo
	 * 
	 * @return
	 * 
	 * @see
	 * com.movingcq.service.ITrashDetailService#updateById(com.movingcq.entity.
	 * TrashCollectionDetailInfo)
	 */

	@Override
	public int updateById(TrashCollectionDetailInfo tDetailInfo) {
		// TODO Auto-generated method stub
		return trashDetailMapper.updateById(tDetailInfo);
	}

	/*
	 * Title: selectByDistinct Description:
	 * 
	 * @return
	 * 
	 * @see com.movingcq.service.ITrashDetailService#selectByDistinct()
	 */

	@Override
	public List<Map<Object, Object>> selectByDistinct(Map<String, String> map) {
		// TODO Auto-generated method stub
		return trashDetailMapper.selectByDistinct(map);
	}

	/*
	 * Title: selectDistinctByPage Description:
	 * 
	 * @param map
	 * 
	 * @return
	 * 
	 * @see
	 * com.movingcq.service.ITrashDetailService#selectDistinctByPage(java.util.
	 * Map)
	 */

	@Override
	public List<Map<Object, Object>> selectDistinctByPage(Map<String, String> map) {
		// TODO Auto-generated method stub
		return trashDetailMapper.selectDistinctByPage(map);
	}

	/*
	 * Title: selectByDistinctDate Description:
	 * 
	 * @return
	 * 
	 * @see com.movingcq.service.ITrashDetailService#selectByDistinctDate()
	 */

	@Override
	public List<Map<Object, Object>> selectByDistinctDate(Map<String, String> map) {
		// TODO Auto-generated method stub
		return trashDetailMapper.selectByDistinctDate(map);
	}

	/*
	 * Title: selectDistinctDateByPage Description:
	 * 
	 * @param map
	 * 
	 * @return
	 * 
	 * @see
	 * com.movingcq.service.ITrashDetailService#selectDistinctDateByPage(java.
	 * util.Map)
	 */

	@Override
	public List<Map<Object, Object>> selectDistinctDateByPage(Map<String, String> map) {
		// TODO Auto-generated method stub
		return trashDetailMapper.selectDistinctDateByPage(map);
	}

	/*
	 * Title: selectPutByDay Description:
	 * 
	 * @param map
	 * 
	 * @return
	 * 
	 * @see
	 * com.movingcq.service.ITrashDetailService#selectPutByDay(java.util.Map)
	 */

	@Override
	public Map<Object, Object> selectPutByDay(Map<String, String> map) {
		// TODO Auto-generated method stub
		return trashDetailMapper.selectPutByDay(map);
	}

	/*
	 * Title: listRestById Description:
	 * 
	 * @param map
	 * 
	 * @return
	 * 
	 * @see com.movingcq.service.ITrashDetailService#listRestById(java.util.Map)
	 */

	@Override
	public Map<Object, Object> listRestById(Map<String, String> map) {
		// TODO Auto-generated method stub
		return trashDetailMapper.listRestById(map);
	}

}
