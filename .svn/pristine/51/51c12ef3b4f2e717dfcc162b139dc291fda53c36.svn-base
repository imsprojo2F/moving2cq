/**   
* @Title: IDriverInfoService.java 
* @Package com.movingcq.service 
* @Description: TODO(用一句话描述该文件做什么) 
* @author IsProjo
* @date 2016年12月21日 上午10:20:57 
* @version V1.0   
*/
package com.movingcq.service;

import java.util.List;
import java.util.Map;

import com.movingcq.entity.DriverInfo;

/**
 * @ClassName: IDriverInfoService
 * @Description: TODO(这里用一句话描述这个类的作用)
 * @author IsProjo
 * @date 2016年12月21日 上午10:20:57
 * 
 */
public interface IDriverInfoService {

	public int addDriverInfo(DriverInfo driverInfo);

	public int insertByCode(String pic, String fileName, String filePath);

	public int deleteById(String[] ids);

	public int updateById(DriverInfo driverInfo);

	public int updateByCode(DriverInfo driverInfo);

	public int updateFilePath(String uid, String file, String src);

	public List<DriverInfo> listAllDriverInfo(Map<String, Object> qMap);

	public List<Map<String, String>> selectByPage(Map<String, Object> qMap);

}
