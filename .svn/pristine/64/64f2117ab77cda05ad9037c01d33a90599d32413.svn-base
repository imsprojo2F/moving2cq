package com.movingcq.service;

import java.util.List;
import java.util.Map;

import com.movingcq.entity.SysUser;

public interface ISysUserService {

	public SysUser getUserById(Integer id);

	public SysUser login(SysUser user);

	SysUser selectByAccount(String userAccount);

	public List<SysUser> listAllUser(Map<String, Object> qMap);

	public List<Map<String, String>> selectByPage(Map<String, Object> qMap);

	public int addUser(SysUser sysUser);

	/**
	 * @param ids
	 * @return
	 */
	public int deleteById(String[] ids);

	/**
	 * @param sysUser
	 * @return
	 */
	public int updateById(SysUser sysUser);
}
