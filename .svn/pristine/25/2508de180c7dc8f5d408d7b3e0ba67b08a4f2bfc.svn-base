/**   
* @Title: TrashDetailMapper.java 
* @Package com.movingcq.dao 
* @Description: TODO(用一句话描述该文件做什么) 
* @author IsProjo
* @date 2016年12月26日 上午10:02:05 
* @version V1.0   
*/
package com.movingcq.dao;

import java.util.List;
import java.util.Map;

import com.movingcq.entity.TrashCollectionDetailInfo;

/**
 * @ClassName: TrashDetailMapper
 * @Description: TODO(这里用一句话描述这个类的作用)
 * @author IsProjo
 * @date 2016年12月26日 上午10:02:05
 * 
 */
public interface TrashDetailMapper {

	public List<Map<Object, Object>> listAllTrash(Map<String, String> map);

	public List<Map<String, String>> selectByPage(Map<String, String> map);

	public List<Map<Object, Object>> selectByDistinct(Map<String, String> map);

	public List<Map<Object, Object>> selectDistinctByPage(Map<String, String> map);

	public List<Map<Object, Object>> selectByDistinctDate(Map<String, String> map);

	public List<Map<Object, Object>> selectDistinctDateByPage(Map<String, String> map);

	public Map<Object, Object> selectPutByDay(Map<String, String> map);

	public Map<Object, Object> listRestById(Map<String, String> map);

	public int insertTrash(TrashCollectionDetailInfo tDetailInfo);

	public int deleteById(String[] ids);

	public int updateById(TrashCollectionDetailInfo tDetailInfo);

}
