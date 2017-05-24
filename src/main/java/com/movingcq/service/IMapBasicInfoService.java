/**   
* @Title: IMapBasicInfoService.java 
* @Package com.movingcq.service 
* @Description: TODO(用一句话描述该文件做什么) 
* @author IsProjo
* @date 2017年2月20日 上午10:43:45 
* @version V1.0   
*/
package com.movingcq.service;

import java.util.List;
import java.util.Map;

import com.movingcq.entity.MapBasicInfo;

/**
 * @ClassName: IMapBasicInfoService
 * @Description: TODO(这里用一句话描述这个类的作用)
 * @author IsProjo
 * @date 2017年2月20日 上午10:43:45
 * 
 */
public interface IMapBasicInfoService {

	public int deleteByPrimaryKey(Integer id);

	public int deleteByCodes(String[] codes);

	public int insert(MapBasicInfo record);

	public int insertSelective(MapBasicInfo record);

	public MapBasicInfo selectByPrimaryKey(Integer id);

	public List<Map<Object, Object>> selectByKey(Map<String, String> map);

	public List<Map<Object, Object>> getStartPoint(Map<String, String> qMap);

	public List<Map<Object, Object>> getCarId(Map<String, String> qMap);

	public List<Map<Object, Object>> selectByIds(String[] ids);

	public List<Map<Object, Object>> selectByCarIds(String[] ids);

	public int updateByPrimaryKeySelective(MapBasicInfo record);

	public int updateByPrimaryKey(MapBasicInfo record);

	public int updateByLng(Map<String, String> qMap);

	public int updateByCarId(Map<String, String> qMap);

	public int updateStart(Map<String, String> qMap);

}
