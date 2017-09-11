package com.movingcq.dao;

import java.util.List;
import java.util.Map;

import com.movingcq.entity.SysUser;

public interface SysUserMapper {

	SysUser selectByPrimaryKey(Integer id);

	SysUser login(SysUser record);

	SysUser selectByAccount(String userAccount);

	List<SysUser> listAllUser(Map<String, Object> qMap);

	List<Map<String, String>> selectByPage(Map<String, Object> qMap);

	/**
	 * @param sysUser
	 * @return
	 */
	int addUser(SysUser sysUser);

	/**
	 * @param ids
	 * @return
	 */
	int deleteById(String[] ids);

	/**
	 * @param sysUser
	 * @return
	 */
	int updateById(SysUser sysUser);
}