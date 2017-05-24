package com.movingcq.service.impl;

import java.util.List;
import java.util.Map;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.movingcq.dao.SysUserMapper;
import com.movingcq.entity.SysUser;
import com.movingcq.service.ISysUserService;

@Service("sysUserService")
public class SysUserServiceImpl implements ISysUserService {

	@Autowired
	private SysUserMapper sysUserMapper;

	@Override
	public SysUser getUserById(Integer id) {
		return sysUserMapper.selectByPrimaryKey(id);
	}

	@Override
	public SysUser login(SysUser user) {
		return sysUserMapper.login(user);
	}

	@Override
	public SysUser selectByAccount(String userAccount) {
		return sysUserMapper.selectByAccount(userAccount);
	}

	@Override
	public int addUser(SysUser sysUser) {
		return sysUserMapper.addUser(sysUser);
	}

	@Override
	public int deleteById(String[] ids) {
		return sysUserMapper.deleteById(ids);
	}

	@Override
	public int updateById(SysUser sysUser) {
		return sysUserMapper.updateById(sysUser);
	}

	/*
	 * Title: listAllUser Description:
	 * 
	 * @param qParameters
	 * 
	 * @return
	 * 
	 * @see
	 * com.movingcq.service.ISysUserService#listAllUser(com.movingcq.entity.
	 * QueryParameters)
	 */

	@Override
	public List<SysUser> listAllUser(Map<String, Object> qMap) {
		// TODO Auto-generated method stub
		return sysUserMapper.listAllUser(qMap);
	}

	/*
	 * Title: selectByPage Description:
	 * 
	 * @param qParameters
	 * 
	 * @return
	 * 
	 * @see
	 * com.movingcq.service.ISysUserService#selectByPage(com.movingcq.entity.
	 * QueryParameters)
	 */

	@Override
	public List<Map<String, String>> selectByPage(Map<String, Object> qMap) {
		// TODO Auto-generated method stub
		return sysUserMapper.selectByPage(qMap);
	}
}
