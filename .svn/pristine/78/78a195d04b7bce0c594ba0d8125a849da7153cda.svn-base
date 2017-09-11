package com.movingcq.test;

import org.apache.log4j.Logger;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.test.context.ContextConfiguration;
import org.springframework.test.context.junit4.SpringJUnit4ClassRunner;

import com.alibaba.fastjson.JSON;
import com.movingcq.entity.SysUser;
import com.movingcq.service.ISysUserService;

@RunWith(SpringJUnit4ClassRunner.class)
@ContextConfiguration(locations = { "classpath:spring.xml", "classpath:spring-mybatis.xml" })
public class SysUserTest {
	
	private Logger logger = Logger.getLogger(SysUserTest.class);
	
	@Autowired
	private ISysUserService sysUserService;
	
	@Test
	public void selectByAccount(){
		SysUser sysUser = sysUserService.selectByAccount("admin");
		logger.info(JSON.toJSONString(sysUser));
	}

}
