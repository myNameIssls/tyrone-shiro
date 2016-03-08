package cn.tyrone.shiro;

import org.apache.shiro.authc.AuthenticationException;
import org.apache.shiro.authc.AuthenticationInfo;
import org.apache.shiro.authc.AuthenticationToken;
import org.apache.shiro.authc.SimpleAuthenticationInfo;
import org.apache.shiro.authz.AuthorizationInfo;
import org.apache.shiro.authz.SimpleAuthorizationInfo;
import org.apache.shiro.realm.AuthorizingRealm;
import org.apache.shiro.subject.PrincipalCollection;
import org.apache.shiro.util.ByteSource;

public class SysAuthorizingRealm extends AuthorizingRealm {

	@Override
	protected AuthenticationInfo doGetAuthenticationInfo(
			AuthenticationToken token) throws AuthenticationException {
		System.out.println("**************************************");
		
		int salt = 1;
		
		SimpleAuthenticationInfo simpleAuthenticationInfo = new SimpleAuthenticationInfo("admin","admin", this.getName());
		
		return simpleAuthenticationInfo;
		
	}
	
	@Override
	protected AuthorizationInfo doGetAuthorizationInfo(
			PrincipalCollection principals) {
		System.out.println("--------------------------------------");
		
		SimpleAuthorizationInfo simpAuthorizationInfo = new SimpleAuthorizationInfo();
		
		Object primaryPrincipal = principals.getPrimaryPrincipal();
		
		System.out.println("------------:" + primaryPrincipal);
		
		simpAuthorizationInfo.addStringPermission("user:home");
		return simpAuthorizationInfo;
	}

}
