package com.movingcq.entity;

import java.util.Date;

public class SysUser {

	private Integer id;

	private String userAccount;

	private String userName;

	private String password;

	private Date createTime;

	private Date updateTime;

	private Integer enabled; // 是否启用 0失效 1 启用 默认1

	private Integer sys_factory_id; // 工厂id

	public Integer getEnabled() {
		return enabled;
	}

	public void setEnabled(Integer enabled) {
		this.enabled = enabled;
	}

	public Integer getSys_factory_id() {
		return sys_factory_id;
	}

	public void setSys_factory_id(Integer sys_factory_id) {
		this.sys_factory_id = sys_factory_id;
	}

	public Integer getId() {
		return id;
	}

	public void setId(Integer id) {
		this.id = id;
	}

	public String getUserAccount() {
		return userAccount;
	}

	public void setUserAccount(String userAccount) {
		this.userAccount = userAccount == null ? null : userAccount.trim();
	}

	public String getUserName() {
		return userName;
	}

	public void setUserName(String userName) {
		this.userName = userName == null ? null : userName.trim();
	}

	public String getPassword() {
		return password;
	}

	public void setPassword(String password) {
		this.password = password == null ? null : password.trim();
	}

	public Date getCreateTime() {
		return createTime;
	}

	public void setCreateTime(Date createTime) {
		this.createTime = createTime;
	}

	public Date getUpdateTime() {
		return updateTime;
	}

	public void setUpdateTime(Date updateTime) {
		this.updateTime = updateTime;
	}

	@Override
	public String toString() {
		return "SysUser [id=" + id + ", userAccount=" + userAccount + ", userName=" + userName + ", password="
				+ password + ", createTime=" + createTime + ", updateTime=" + updateTime + ", enabled=" + enabled
				+ ", sys_factory_id=" + sys_factory_id + "]";
	}

}