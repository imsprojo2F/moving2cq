package com.movingcq.shiro.realm;

import org.apache.shiro.authc.AuthenticationException;
import org.apache.shiro.authc.AuthenticationInfo;
import org.apache.shiro.authc.AuthenticationToken;
import org.apache.shiro.authc.DisabledAccountException;
import org.apache.shiro.authc.SimpleAuthenticationInfo;
import org.apache.shiro.authc.UnknownAccountException;
import org.apache.shiro.authc.UsernamePasswordToken;
import org.apache.shiro.authz.AuthorizationInfo;
import org.apache.shiro.authz.SimpleAuthorizationInfo;
import org.apache.shiro.realm.AuthorizingRealm;
import org.apache.shiro.subject.PrincipalCollection;
import org.springframework.beans.factory.annotation.Autowired;

import com.movingcq.entity.SysUser;
import com.movingcq.service.ISysUserService;

public class MyRealm extends AuthorizingRealm {

	@Autowired
	private ISysUserService sysUserService;

	/**
	 * 授权
	 */
	@Override
	protected AuthorizationInfo doGetAuthorizationInfo(PrincipalCollection principals) {
		SysUser sysUser = (SysUser) super.getAvailablePrincipal(principals);
		SimpleAuthorizationInfo info = new SimpleAuthorizationInfo();
		if ("admin".equals(sysUser.getUserAccount())) {
			info.addRole("admin");
		} else {
			info.addRole("user");
		}
		return info;
	}

	/**
	 * 认证
	 */
	@Override
	protected AuthenticationInfo doGetAuthenticationInfo(AuthenticationToken authcToken)
			throws AuthenticationException {
		UsernamePasswordToken token = (UsernamePasswordToken) authcToken;
		String account = token.getUsername();
		SysUser sysUser = sysUserService.selectByAccount(account);
		if (sysUser == null) {
			throw new UnknownAccountException();
		}
		if (!sysUser.getPassword().equals(new String(token.getPassword()))) {
			throw null;
		}
		if (sysUser.getEnabled() == 0) {
			throw new DisabledAccountException();
		}

		SysUser principal = sysUser;

		String credentials = sysUser.getPassword();
		String realmName = getName();

		SimpleAuthenticationInfo info = new SimpleAuthenticationInfo(principal, credentials, realmName);
		return info;
	}
}
