package cyd.admin.shiro;

import java.util.HashSet;

import org.apache.shiro.authc.AuthenticationException;
import org.apache.shiro.authc.AuthenticationInfo;
import org.apache.shiro.authc.AuthenticationToken;
import org.apache.shiro.authc.SimpleAuthenticationInfo;
import org.apache.shiro.authc.UnknownAccountException;
import org.apache.shiro.authz.AuthorizationInfo;
import org.apache.shiro.authz.SimpleAuthorizationInfo;
import org.apache.shiro.realm.AuthorizingRealm;
import org.apache.shiro.subject.PrincipalCollection;
import org.springframework.beans.factory.annotation.Autowired;

import cyd.admin.sys.entity.SystemUser;
import cyd.admin.sys.repository.SystemResourcesRepository;
import cyd.admin.sys.repository.SystemRolesRepository;
import cyd.admin.sys.repository.SystemUserRepository;

/**
 * 用户认证与授权
 * @author chenyd
 * 2018年1月10日
 */
public class AuthorizingRealmExtends extends AuthorizingRealm {
	
	@Autowired
	private SystemUserRepository sysUserRepository;
	
	@Autowired
	private SystemRolesRepository sysRolesRepository;
	
	@Autowired
	private SystemResourcesRepository SysResourcesRepository;
	

	@Override
	protected AuthenticationInfo doGetAuthenticationInfo(AuthenticationToken token) throws AuthenticationException {
		System.out.println("do doGetAuthenticationInfo");
		String username = (String) token.getPrincipal();
		SystemUser user = sysUserRepository.findByUserName(username);
		if (user == null) {
			throw new UnknownAccountException();
		}
		SimpleAuthenticationInfo authenticationInfo = new SimpleAuthenticationInfo(user.getUserName(),
				user.getPassWord(),
				getName()
		);
		return authenticationInfo;
	}

	@Override
	protected AuthorizationInfo doGetAuthorizationInfo(PrincipalCollection principals) {
		System.out.println("do doGetAuthorizationInfo");
		String username = (String)principals.getPrimaryPrincipal();  
        SimpleAuthorizationInfo authorizationInfo = new SimpleAuthorizationInfo();
        //从数据库加载当前用户的角色，[admin]
        authorizationInfo.setRoles(new HashSet<String>(sysRolesRepository.findRolesByUsername(username)));
        //从数据库加载当前用户可以访问的资源，[index.jsp, abc.jsp]
        authorizationInfo.setStringPermissions(new HashSet<String>(SysResourcesRepository.findResourceByUsername(username)));
        return authorizationInfo;  
	}
}
