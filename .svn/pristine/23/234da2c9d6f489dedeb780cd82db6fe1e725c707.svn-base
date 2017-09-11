/**   
* @Title: DriverInfoMapper.java 
* @Package com.movingcq.dao 
* @Description: TODO(用一句话描述该文件做什么) 
* @author IsProjo
* @date 2016年12月21日 上午10:17:45 
* @version V1.0   
*/
package com.movingcq.dao;

import java.util.List;
import java.util.Map;

import com.movingcq.entity.DriverInfo;

/**
 * @ClassName: DriverInfoMapper
 * @Description: TODO(这里用一句话描述这个类的作用)
 * @author IsProjo
 * @date 2016年12月21日 上午10:17:45
 * 
 */
public interface DriverInfoMapper {

	List<DriverInfo> listAllDriver(Map<String, Object> qMap);

	List<Map<String, String>> selectByPage(Map<String, Object> qMap);

	/**
	 * @param driverInfo
	 * @return
	 */
	int addDriver(DriverInfo driverInfo);

	int insertByCode(String pic, String fileName, String filePath);

	/**
	 * @param ids
	 * @return
	 */
	int deleteById(String[] ids);

	/**
	 * @param DriverInfo
	 * @return
	 */
	int updateById(DriverInfo driverInfo);

	int updateByCode(DriverInfo driverInfo);

	int updateFilePath(String uid, String file, String src);
}
